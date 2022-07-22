package com.codewithbee.tictictic.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.codewithbee.tictictic.R;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button01);
        button2 = (Button) findViewById(R.id.button02);
    }

    public void solo_click(View view) {
        intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra(getString(R.string.intent_extra_key_solo_game_mode), true);
        startActivity(intent);
    }

    public void multiplayer_click(View view) {
        intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra(getString(R.string.intent_extra_key_solo_game_mode), false);
        startActivity(intent);
    }
}