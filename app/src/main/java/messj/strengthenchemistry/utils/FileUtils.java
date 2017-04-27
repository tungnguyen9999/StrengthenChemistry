package messj.strengthenchemistry.utils;

/**
 * Created by USER on 4/18/2017.
 */

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.io.File;

public class FileUtils {

    public static void close(Reader reader) {
        if (reader != null)
            try {
                reader.close();
            } catch (IOException e) {
            }
    }

    public static void close(Writer writer) {
        if (writer != null)
            try {
                writer.close();
            } catch (IOException e) {
            }
    }

    public static void close(InputStream inputStream) {
        if (inputStream != null)
            try {
                inputStream.close();
            } catch (IOException e) {
            }
    }

    public static void close(OutputStream outputStream) {
        if (outputStream != null)
            try {
                outputStream.close();
            } catch (IOException e) {
            }
    }

    public static void requestWriteStoragePermission(final Activity context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(context,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(context, "Please allow write external storage in App Permission for additional functionality.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(context,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
    }
}
