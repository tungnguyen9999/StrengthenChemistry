package messj.strengthenchemistry;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import messj.strengthenchemistry.chooserlistitem.DataModel;
import messj.strengthenchemistry.chooserlistitem.ListItemActivity;
import messj.strengthenchemistry.chooserlistitem.ListItemAdapter;
import messj.strengthenchemistry.listlessoncontent.ListContentActivity;
import messj.strengthenchemistry.listlessoncontent.ListLessonContentMaker;

/**
 * Created by USER on 4/10/2017.
 */

public class ItemSelectActivity extends AppCompatActivity {

    private Button btnLessonContent, btnLessonTest, btnLessonTip;
    ArrayList<DataModel> dataModels;
    ListView listView;
    private static ListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_select);

        final Bundle extras = getIntent().getExtras();

        btnLessonContent = (Button) findViewById(R.id.btnLessonContent);
        btnLessonTest = (Button) findViewById(R.id.btnLessonTest);
        btnLessonTip = (Button) findViewById(R.id.btnLessonTip);

        btnLessonContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ItemSelectActivity.this, ListContentActivity.class);
                i.putExtra("itemKey", extras.getString("itemKey"));
                startActivity(i);
            }
        });

        btnLessonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLessonTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
