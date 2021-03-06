package messj.strengthenchemistry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import messj.strengthenchemistry.chooserlistitem.ListItemActivity;
import messj.strengthenchemistry.utils.FileUtils;

/**
 * Created by USER on 4/5/2017.
 */

public class MainActivity extends AppCompatActivity {

    private Button btnSelectClass10, btnSelectClass11, btnSelectClass12, btnChemistryStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FileUtils.requestWriteStoragePermission(this);

        btnSelectClass10 = (Button) findViewById(R.id.btnSelectClass10);
        btnSelectClass11 = (Button) findViewById(R.id.btnSelectClass11);
        btnSelectClass12 = (Button) findViewById(R.id.btnSelectClass12);
        btnChemistryStory = (Button) findViewById(R.id.btnChemistryStory);

        btnSelectClass10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, ListItemActivity.class);
                data.putExtra("selectionKey", btnSelectClass10.getId());
                startActivity(data);
            }
        });

        btnSelectClass11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, ListItemActivity.class);
                data.putExtra("selectionKey", btnSelectClass11.getId());
                startActivity(data);
            }
        });

        btnSelectClass12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, ListItemActivity.class);
                data.putExtra("selectionKey", btnSelectClass12.getId());
                startActivity(data);
            }
        });

        btnChemistryStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
