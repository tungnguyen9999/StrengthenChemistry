package messj.strengthenchemistry.utils;

/**
 * Created by USER on 4/18/2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

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
}
