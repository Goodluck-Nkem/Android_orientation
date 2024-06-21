package com.example.change_orientation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.change_orientation.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button last_button_clicked;
    private int default_button_color;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        Button portrait_button = findViewById(R.id.portrait_button);
        default_button_color = portrait_button.getCurrentTextColor();
        portrait_button.setOnClickListener(
                new View.OnClickListener() {
                    @SuppressLint("SourceLockedOrientationActivity")
                    @Override
                    public void onClick(View view) {
                        highlight_button_text(findViewById(R.id.portrait_button));
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    }
                }
        );

        Button landscape_button = this.findViewById(R.id.landscape_button);
        landscape_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SourceLockedOrientationActivity")
            @Override
            public void onClick(View view) {
                highlight_button_text(findViewById(R.id.landscape_button));
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        });

        Button sensor_portrait_button = findViewById(R.id.sensor_portrait_button);
        sensor_portrait_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SourceLockedOrientationActivity")
            @Override
            public void onClick(View view) {
                highlight_button_text(findViewById(R.id.sensor_portrait_button));
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
            }
        });

        Button sensor_landscape_button = findViewById(R.id.sensor_landscape_button);
        sensor_landscape_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SourceLockedOrientationActivity")
            @Override
            public void onClick(View view) {
                highlight_button_text(findViewById(R.id.sensor_landscape_button));
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            }
        });

        Button reverse_portrait_button = findViewById(R.id.reverse_portrait_button);
        reverse_portrait_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SourceLockedOrientationActivity")
            @Override
            public void onClick(View view) {
                highlight_button_text(findViewById(R.id.reverse_portrait_button));
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
            }
        });

        Button reverse_landscape_button = findViewById(R.id.reverse_landscape_button);
        reverse_landscape_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SourceLockedOrientationActivity")
            @Override
            public void onClick(View view) {
                highlight_button_text(findViewById(R.id.reverse_landscape_button));
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
            }
        });
    }

    private static CharSequence string_value_clicked()
    {
        return "Clicked!";
    }

    private void highlight_button_text(Button button)
    {
        if(last_button_clicked != null)
            last_button_clicked.setTextColor(default_button_color);
        button.setTextColor(Color.GREEN);
        last_button_clicked = button;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
