package edu.acmatucf.stemdayapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FragmentLogin(), "fragment_login")
                .commit();
    }

    private String getJSONString(String site) throws Exception {
        URL url = new URL(site);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        StringBuilder str = new StringBuilder(in.readLine());
        while ((inputLine = in.readLine()) != null)
            str.append(inputLine);
        in.close();
        str.trimToSize();
        return str.toString();
    }

}
