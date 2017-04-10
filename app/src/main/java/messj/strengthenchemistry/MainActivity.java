package messj.strengthenchemistry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by USER on 4/5/2017.
 */

public class MainActivity extends AppCompatActivity {

    private Button btnSelectClass10, btnSelectClass11, btnSelectClass12, btnChemistryStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectClass10 = (Button) findViewById(R.id.btnSelectClass10);
        btnSelectClass11 = (Button) findViewById(R.id.btnSelectClass11);
        btnSelectClass12 = (Button) findViewById(R.id.btnSelectClass12);
        btnChemistryStory = (Button) findViewById(R.id.btnChemistryStory);

        btnSelectClass10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSelectClass11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSelectClass12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnChemistryStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
