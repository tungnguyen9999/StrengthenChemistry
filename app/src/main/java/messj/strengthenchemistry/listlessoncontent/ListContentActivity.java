package messj.strengthenchemistry.listlessoncontent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import messj.strengthenchemistry.R;
import messj.strengthenchemistry.chooserlistitem.DataModel;
import messj.strengthenchemistry.chooserlistitem.ListItemAdapter;

/**
 * Created by USER on 4/18/2017.
 */

public class ListContentActivity extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static ListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_content);

        Bundle extras = getIntent().getExtras();

        ListLessonContentMaker obj = new ListLessonContentMaker();
        dataModels = obj.makeLessonDataModel(extras.getString("itemKey"), this);

        listView = (ListView) findViewById(R.id.list);

        adapter = new ListItemAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel = dataModels.get(position);

                Snackbar.make(view, dataModel.getName() + "\n", Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();

                // make circle view pager for each item in list
//                startActivity(new Intent(ListContentActivity.this, LessonContentSelectActivity.class));

                // call ContentSelectedActivity
                Intent i = new Intent(ListContentActivity.this, ContentSelectedActivity.class);
                i.putExtra("lessonKey", dataModel.getKey());
                startActivity(i);
            }
        });
    }
}
