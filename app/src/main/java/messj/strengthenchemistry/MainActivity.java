package messj.strengthenchemistry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by USER on 4/5/2017.
 */

public class MainActivity extends AppCompatActivity {

    private Button btnSelectLesson, btnChemistryStory, btnAccSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectLesson = (Button) findViewById(R.id.btnSelectLesson);
        btnChemistryStory = (Button) findViewById(R.id.btnChemistryStory);
        btnAccSetting = (Button) findViewById(R.id.btnAccSetting);

        btnSelectLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnChemistryStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnAccSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
