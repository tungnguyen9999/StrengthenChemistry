package messj.strengthenchemistry.chooserlistitem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import messj.strengthenchemistry.ItemSelectActivity;
import messj.strengthenchemistry.R;

public class ListItemActivity extends AppCompatActivity {


    ArrayList<DataModel> dataModels;
    ListView listView;
    private static ListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooser_list_item);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        switch (extras.getInt("selectionKey")) {
            case R.id.btnSelectClass10:
                setTitle(R.string.class10_lesson);
                makeClass10SectionList();
                Toast.makeText(getApplicationContext(), "đã chọn chủ đề hóa lớp 10", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSelectClass11:
                setTitle(R.string.class11_lesson);
                makeClass11SectionList();
                Toast.makeText(getApplicationContext(), "đã chọn chủ đề hóa lớp 11", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSelectClass12:
                setTitle(R.string.class12_lesson);
                makeClass12SectionList();
                Toast.makeText(getApplicationContext(), "đã chọn chủ đề hóa lớp 12", Toast.LENGTH_SHORT).show();
                break;
        }

        listView = (ListView) findViewById(R.id.list);

        adapter = new ListItemAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel = dataModels.get(position);

                Snackbar.make(view, dataModel.getName() + "\n", Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();

                Intent i = new Intent(ListItemActivity.this, ItemSelectActivity.class);
                i.putExtra("itemKey", dataModel.getKey());
                startActivity(i);
            }
        });
    }

    public void makeClass10SectionList() {
        dataModels = new ArrayList<>();
        dataModels.add(new DataModel(getResources().getString(R.string.class10_ch1), "September 23, 2008", "c10ch1"));
        dataModels.add(new DataModel(getResources().getString(R.string.class10_ch2), "February 9, 2009", "c10ch2"));
        dataModels.add(new DataModel(getResources().getString(R.string.class10_ch3), "April 27, 2009", "c10ch3"));
        dataModels.add(new DataModel(getResources().getString(R.string.class10_ch4), "September 15, 2009", "c10ch4"));
        dataModels.add(new DataModel(getResources().getString(R.string.class10_ch5), "October 26, 2009", "c10ch5"));
        dataModels.add(new DataModel(getResources().getString(R.string.class10_ch6), "May 20, 2010", "c10ch6"));
        dataModels.add(new DataModel(getResources().getString(R.string.class10_ch7), "December 6, 2010", "c10ch7"));
    }

    public void makeClass11SectionList() {
        dataModels = new ArrayList<>();
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch1), "September 23, 2008", "c11ch1"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch2), "February 9, 2009", "c11ch2"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch3), "April 27, 2009", "c11ch3"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch4), "September 15, 2009", "c11ch4"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch5), "October 26, 2009", "c11ch5"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch6), "May 20, 2010", "c11ch6"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch7), "December 6, 2010", "c11ch7"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch8), "September 23, 2008", "c11ch8"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch9), "February 9, 2009", "c11ch9"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch10), "April 27, 2009", "c11ch10"));
        dataModels.add(new DataModel(getResources().getString(R.string.class11_ch11), "September 15, 2009", "c11ch11"));
    }

    public void makeClass12SectionList() {
        dataModels = new ArrayList<>();
        dataModels.add(new DataModel(getResources().getString(R.string.class12_ch1), "September 23, 2008", "c12ch1"));
        dataModels.add(new DataModel(getResources().getString(R.string.class12_ch2), "February 9, 2009", "c12ch2"));
        dataModels.add(new DataModel(getResources().getString(R.string.class12_ch3), "April 27, 2009", "c12ch3"));
        dataModels.add(new DataModel(getResources().getString(R.string.class12_ch4), "September 15, 2009", "c12ch4"));
        dataModels.add(new DataModel(getResources().getString(R.string.class12_ch5), "October 26, 2009", "c12ch5"));
        dataModels.add(new DataModel(getResources().getString(R.string.class12_ch6), "May 20, 2010", "c12ch6"));
        dataModels.add(new DataModel(getResources().getString(R.string.class12_ch7), "December 6, 2010", "c12ch7"));
        dataModels.add(new DataModel(getResources().getString(R.string.class12_ch8), "September 23, 2008", "c12ch8"));
        dataModels.add(new DataModel(getResources().getString(R.string.class12_ch9), "February 9, 2009", "c12ch9"));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
