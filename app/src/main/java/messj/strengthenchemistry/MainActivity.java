package messj.strengthenchemistry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session;
import com.dropbox.client2.session.TokenPair;
import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.data.photos.UserFeed;

import java.net.URL;

import messj.strengthenchemistry.chooserlistitem.ListItemActivity;
import messj.strengthenchemistry.utils.Constants;
import messj.strengthenchemistry.utils.FileUtils;

/**
 * Created by USER on 4/5/2017.
 */

public class MainActivity extends AppCompatActivity {

    private Button btnSelectClass10, btnSelectClass11, btnSelectClass12, btnChemistryStory;
    private static final int TAKE_PHOTO = 1;
    final static public String DROPBOX_APP_KEY = "mkymswyt61jbyym";
    final static public String DROPBOX_APP_SECRET = "4r4wzl592eu2ias";
    final static public Session.AccessType ACCESS_TYPE = Session.AccessType.DROPBOX;

    private DropboxAPI<AndroidAuthSession> mApi;
    private boolean mLoggedIn, onResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // test dropbox api
        AndroidAuthSession session = buildSession();
        mApi = new DropboxAPI<AndroidAuthSession>(session);

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

//    public void requestAlbumFromPicasa() {
//        Log.d("tungnt", "get photo from picasa");
//
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//
//        try {
//            PicasawebService myService = new PicasawebService("Get photo from Picase Web Albums");
//            URL feedUrl = new URL("https://picasaweb.google.com/data/feed/api/user/tungosper@gmail.com/albumid/6113664871572982641");
//
//            AlbumFeed feed = myService.getFeed(feedUrl, AlbumFeed.class);
//
//            for (PhotoEntry photo : feed.getPhotoEntries()) {
//                System.out.println(photo.getTitle().getPlainText());
//                Log.i("tungnt: ", "first log");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private String[] getKeys() {
        SharedPreferences prefs = getSharedPreferences(
                Constants.ACCOUNT_PREFS_NAME, 0);
        String key = prefs.getString(Constants.ACCESS_KEY_NAME, null);
        String secret = prefs.getString(Constants.ACCESS_SECRET_NAME, null);
        if (key != null && secret != null) {
            String[] ret = new String[2];
            ret[0] = key;
            ret[1] = secret;
            return ret;
        } else {
            return null;
        }
    }

    private AndroidAuthSession buildSession() {
        AppKeyPair appKeyPair = new AppKeyPair(Constants.DROPBOX_APP_KEY,
                Constants.DROPBOX_APP_SECRET);
        AndroidAuthSession session;

        String[] stored = getKeys();
        if (stored != null) {
            AccessTokenPair accessToken = new AccessTokenPair(stored[0],
                    stored[1]);
            session = new AndroidAuthSession(appKeyPair, Constants.ACCESS_TYPE,
                    accessToken);
        } else {
            session = new AndroidAuthSession(appKeyPair, Constants.ACCESS_TYPE);
        }

        return session;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == TAKE_PHOTO) {
//				f = new File(Utils.getPath() + "/temp.jpg");
                if (FileUtils.isOnline(MainActivity.this)) {
                    mApi.getSession().startAuthentication(MainActivity.this);
                    onResume = true;
                } else {
                    FileUtils.showNetworkAlert(MainActivity.this);
                }
            }
        }
    }

    @Override
    protected void onResume() {

        AndroidAuthSession session = mApi.getSession();

        if (session.authenticationSuccessful()) {
            try {
                session.finishAuthentication();

                TokenPair tokens = session.getAccessTokenPair();
                storeKeys(tokens.key, tokens.secret);
//                setLoggedIn(onResume);
            } catch (IllegalStateException e) {
                showToast("Couldn't authenticate with Dropbox:"
                        + e.getLocalizedMessage());
            }
        }
        super.onResume();
    }

    private void storeKeys(String key, String secret) {
        SharedPreferences prefs = getSharedPreferences(
                Constants.ACCOUNT_PREFS_NAME, 0);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(Constants.ACCESS_KEY_NAME, key);
        edit.putString(Constants.ACCESS_SECRET_NAME, secret);
        edit.commit();
    }

    private void showToast(String msg) {
        Toast error = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        error.show();
    }

//    public void setLoggedIn(boolean loggedIn) {
//        mLoggedIn = loggedIn;
//        if (loggedIn) {
//            UploadFile upload = new UploadFile(Main.this, mApi, DIR, f);
//            upload.execute();
//            onResume = false;
//
//        }
//    }
}
