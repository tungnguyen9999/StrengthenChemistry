package messj.strengthenchemistry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by USER on 4/10/2017.
 */

public class ItemSelectActivity extends AppCompatActivity {

    private Button btnLessonContent, btnLessonTest, btnLessonTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_select);

        btnLessonContent = (Button) findViewById(R.id.btnLessonContent);
        btnLessonTest = (Button) findViewById(R.id.btnLessonTest);
        btnLessonTip = (Button) findViewById(R.id.btnLessonTip);

        btnLessonContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
