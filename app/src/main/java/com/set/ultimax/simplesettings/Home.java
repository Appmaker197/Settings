package com.set.ultimax.simplesettings;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

            loadPrefrences();

            Button set = (Button) findViewById(R.id.settings);
            Button ref = (Button) findViewById(R.id.refresh);

            set.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    Intent toSet = new Intent(Home.this, Settings.class);
                    startActivity(toSet);
                }
            });

          ref.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                loadPrefrences();

            }
        });

    }



    private void loadPrefrences() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean setVisable = sharedPreferences.getBoolean("checkbox_preference", false);
        String setText = sharedPreferences.getString("edittext_preference","DEFAULT");

        TextView text = (TextView) findViewById(R.id.tc);
        TextView text2 = (TextView) findViewById(R.id.custom_txt);

        text2.setText(setText);

        if(setVisable){

            text.setVisibility(View.INVISIBLE);
        }
        else{

            text.setVisibility(View.VISIBLE);
        }

    }


}

