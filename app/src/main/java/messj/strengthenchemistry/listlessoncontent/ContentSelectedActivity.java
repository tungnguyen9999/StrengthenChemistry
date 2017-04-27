package messj.strengthenchemistry.listlessoncontent;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Objects;


import messj.strengthenchemistry.R;
import messj.strengthenchemistry.chooserlistitem.DataModel;
import messj.strengthenchemistry.chooserlistitem.ListItemAdapter;

/**
 * Created by USER on 4/24/2017.
 */

public class ContentSelectedActivity extends AppCompatActivity {

    String[] dirs = null;
    String[] lessonContent = null;

    ArrayList<Object> dataModels = new ArrayList<>();
    ListView listView;
    private static LessonContentViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_selected);
        Bundle extras = getIntent().getExtras();
        String lessonKey = extras.getString("lessonKey");

        AssetManager assetManager = getAssets();
        try {
            dirs = assetManager.list("");
            for (int i = 0; i < dirs.length; i++) {
                if (lessonKey.equals(dirs[i].toString())) {
                    lessonContent = assetManager.list(dirs[i]);

                    // get image content from assets
                    for (int h = 0; h < lessonContent.length; h++) {
                        InputStream ims = assetManager.open(dirs[i] + "/" + lessonContent[h]);

                        // Convert bitmap to byte array
                        Bitmap b = BitmapFactory.decodeStream(ims);
                        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                        b.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                        byte[] bitmapdata = outStream.toByteArray();

                        // write bitmap data to file image
                        ContextWrapper cw = new ContextWrapper(getApplicationContext());
//                        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
                        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
                        File file = new File(path, lessonContent[h]);
                        file.createNewFile();

                        FileOutputStream fOut = new FileOutputStream(file);
                        fOut.write(bitmapdata);
                        fOut.flush();
                        fOut.close();

                        // add image to dataModel
                        dataModels.add(file.getAbsolutePath());
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }

        adapter = new LessonContentViewAdapter(dataModels, getApplicationContext());
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
