package hoshikoo.c4q.nyc.soundcloudoauth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.apache.http.HttpResponse;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String CLIENT_ID = "d46d50786907ef22b5e39614d0915b51";
    public static final String CLIENT_SECRET = "3d63e610a74d1d831e919f7146cccf94";

    public static final String API_URL = "https://api.soundcloud.com";

    public static final String END_USER_AUTHORIZATION = "https://soundcloud.com/connect";
    public static final String TOKEN = "https://api.soundcloud.com/oauth2/token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiWrapper wrapper = new ApiWrapper(CLIENT_ID, CLIENT_SECRET, null, null);
        try {
            wrapper.login("username", "password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            HttpResponse resp = wrapper.get(Request.to("/me"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
