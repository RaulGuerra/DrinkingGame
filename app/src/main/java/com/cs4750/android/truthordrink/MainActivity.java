package com.cs4750.android.truthordrink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button deck1Button;
    private Button deck2Button;
    private Button deck3Button;
    private Button deck4Button;
    private Button spinBottleButton;
    private Button helpButton;
    private CheckBox two_players;
    private CheckBox three_players;
    private CheckBox four_players;
    private int num_players = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        deck1Button = (Button) findViewById(R.id.deck1);
        deck1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeck(1);
            }
        });

        deck2Button = (Button) findViewById(R.id.deck2);
        deck2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeck(2);
            }
        });

        deck3Button = (Button) findViewById(R.id.deck3);
        deck3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeck(3);
            }
        });

        deck4Button = (Button) findViewById(R.id.deck4);
        deck4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeck(4);
            }
        });

        two_players = findViewById(R.id.two_players);
        three_players = findViewById(R.id.three_players);
        four_players = findViewById(R.id.four_players);
        two_players.setChecked(true);

        two_players.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    three_players.setChecked(false);
                    four_players.setChecked(false);
                    two_players.setClickable(false);
                    three_players.setClickable(true);
                    four_players.setClickable(true);
                    num_players=2;
                }
            }
        });
        three_players.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    two_players.setChecked(false);
                    four_players.setChecked(false);
                    three_players.setClickable(false);
                    two_players.setClickable(true);
                    four_players.setClickable(true);
                    num_players=3;
                }
            }
        });
        four_players.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    three_players.setChecked(false);
                    two_players.setChecked(false);
                    four_players.setClickable(false);
                    three_players.setClickable(true);
                    two_players.setClickable(true);
                    num_players=4;
                }
            }
        });


        spinBottleButton = (Button) findViewById(R.id.spinBottle);
        spinBottleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bottleIntent;

                bottleIntent = new Intent(view.getContext(), SpinBottle.class);

                startActivity(bottleIntent);
            }

        });

        helpButton = (Button) findViewById(R.id.help);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpIntent;

                helpIntent = new Intent(view.getContext(), Help.class);

                startActivity(helpIntent);
            }
        });



    }

    public void openDeck(int num)
    {
        Intent intent;
        switch (num){
            case 1:
                intent = new Intent(this, Deck1.class);
                break;
            case 2:
                intent = new Intent(this, Deck2.class);
                break;
            case 3:
                intent = new Intent(this, Deck3.class);
                break;
            case 4:
                intent = new Intent(this, Deck4.class);
                break;
            default:
                throw new IllegalStateException("Unexpected deck value: " + num);
        }

        intent.putExtra("players",num_players);
        startActivity(intent);
    }
}