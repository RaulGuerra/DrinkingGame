package com.cs4750.android.truthordrink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button deck1Button;
    private Button deck2Button;
    private Button deck3Button;
    private Button deck4Button;
    private Button spinBottleButton;
    private Button helpButton;

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

        startActivity(intent);
    }
}