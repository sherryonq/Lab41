package com.example.user.lab41;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewName;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = (TextView) findViewById(R.id.textViewName);
        checkBox = (CheckBox) findViewById(R.id.checkBoxEn);

        loadPrefs();
    }

    public void loadPrefs() {
        //sharedPreferences object using the PreferenceManager
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean chk = sp.getBoolean("en", false);
        String name = sp.getString("name", "");
        checkBox.setChecked(chk);
        textViewName.setText(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int d = item.getItemId();

        if(d == R.id.setting) {
            Intent intent = new Intent(getApplicationContext(), SetPreferenceActivity.class);
            startActivityForResult(intent,0);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        loadPrefs();
    }
}
