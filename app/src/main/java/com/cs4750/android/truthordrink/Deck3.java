package com.cs4750.android.truthordrink;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class Deck3 extends AppCompatActivity {

    ArrayList<String > s;
    ArrayAdapter arrayAdapter;
    int n = 0;
    Button answerButton;
    Button drinkButton;
    Button skipButton;
    Button endgameButton;
    Button backToMainButton;
    ImageView bottleGif;
    ImageView no_winners_gif;
    TextView player1;
    TextView player2;
    TextView player3;
    TextView player4;
    TextView player_turn;
    LinearLayout score_board;
    ArrayList<User> userList;
    ArrayList<TextView> textList;
    int currentPlayer=0;
    TextView winner;

    private KonfettiView konfettiView = null;
    private Shape.DrawableShape drawableShape = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_deck3);
        
        Bundle values = getIntent().getExtras();
        final int num_players = values.getInt("players");
        score_board=findViewById(R.id.linearLayout);
        answerButton = findViewById(R.id.answer_button);
        drinkButton = findViewById(R.id.drink_button);
        skipButton = findViewById(R.id.skip_button);
        endgameButton = findViewById(R.id.endgame_button);
        backToMainButton = findViewById(R.id.backToMain_button);
        backToMainButton.setVisibility(View.GONE);

        konfettiView = findViewById(R.id.konfettiView);
        bottleGif = findViewById(R.id.bottleGif);
        no_winners_gif = findViewById(R.id.no_winners_gif);

        player1 = findViewById(R.id.player_1);
        player2 = findViewById(R.id.player_2);
        player3 = findViewById(R.id.player_3);
        player4 = findViewById(R.id.player_4);
        winner = findViewById(R.id.winner);
        textList = new ArrayList<TextView>();
        textList.add(player1);
        textList.add(player2);
        textList.add(player3);
        textList.add(player4);
        player_turn = findViewById(R.id.player_turn);
        userList = new ArrayList<User>();
        for(int i = 0; i < num_players; i++){
            userList.add(new User());
        }
        for(int i = num_players; i < textList.size(); i++){
            textList.get(i).setVisibility(View.GONE);
        }
        player_turn.setText("Player turn: " + (currentPlayer+1));

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userList.get(currentPlayer).incrementScore();
                textList.get(currentPlayer).setText("Player " + (currentPlayer+1) + ": " + userList.get(currentPlayer).getScore()+ " points");
                currentPlayer= (currentPlayer +1)%userList.size();
                player_turn.setText("Player turn: " + (currentPlayer+1));
            }
        });
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayer= (currentPlayer +1)%userList.size();
                player_turn.setText("Player turn: " + (currentPlayer+1));
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayer= (currentPlayer +1)%userList.size();
                player_turn.setText("Player turn: " + (currentPlayer+1));
            }
        });

        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.bottle);
        drawableShape = new Shape.DrawableShape(drawable, true);

        EmitterConfig emitterConfig = new Emitter(10L, TimeUnit.SECONDS).perSecond(100);
        final Party party = new PartyFactory(emitterConfig)
                .angle(270)
                .spread(360)
                .setSpeedBetween(0f, 25f)
                .timeToLive(2000L)
                .shapes(Arrays.asList(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape))
                .sizes(new Size(12, 5f, 0.2f))
                .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def))
                .position(0.0, 0.0, 1.0, 0.0)
                .build();

        endgameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.clear();
                backToMainButton.setVisibility(View.VISIBLE);

                konfettiView.start(party);
                if(num_players>0) {
                    answerButton.setVisibility(View.GONE);
                    drinkButton.setVisibility(View.GONE);
                    skipButton.setVisibility(View.GONE);
                    endgameButton.setVisibility(View.GONE);
                    player1.setVisibility(View.GONE);
                    player2.setVisibility(View.GONE);
                    player3.setVisibility(View.GONE);
                    player4.setVisibility(View.GONE);
                    player_turn.setVisibility(View.GONE);
                    score_board.setVisibility(View.GONE);
                    int winnerIndex = 0;
                    int maxScore = userList.get(0).getScore();
                    for (int i = 1; i < userList.size(); i++) {
                        if (maxScore < userList.get(i).getScore()) {
                            maxScore = userList.get(i).getScore();
                            winnerIndex = i;
                        }
                    }
                    ArrayList<Integer> winners = new ArrayList<Integer>();
                    winners.add(winnerIndex);
                    for (int i = 0; i < userList.size(); i++) {
                        if (i != winnerIndex && maxScore == userList.get(i).getScore()) {
                            winners.add(i);
                        }
                    }

                    if (maxScore == 0) {
                        no_winners_gif.setVisibility(View.VISIBLE);
                        winner.setText("No one scored any points...");
                    } else {
                        bottleGif.setVisibility(View.VISIBLE);
                        if (winners.size() == 1) {
                            winner.setText("Player " + (winnerIndex + 1) + " has won with a score of " + maxScore + " points!!!");
                        } else {
                            String win = "Players ";
                            if (winners.size() == 2) {
                                win += (winners.get(0) + 1) + " and " + (winners.get(1) + 1);
                            } else {
                                for (int i = 0; i < winners.size() - 1; i++) {
                                    win += (i + 1) + ", ";
                                }

                                win += "and " + (winners.get(winners.size() - 1) + 1);
                            }
                            winner.setText(win + " have tied with a score of " + maxScore + " points!!!");
                        }

                    }
                }
                else{
                    winner.setText("The game has finished!");
                    endgameButton.setVisibility(View.GONE);
                }
            }
        });

        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Deck3.this, MainActivity.class));
            }
        });

        if(num_players==0){
            player_turn.setVisibility(View.GONE);
            answerButton.setVisibility(View.GONE);
            drinkButton.setVisibility(View.GONE);
            skipButton.setVisibility(View.GONE);
            score_board.setVisibility(View.GONE);
        }
        s=new ArrayList<String >();
        s.add("Give us a passionate example of your dirty talk.");
        s.add("Would you ever knowingly enter into an open relationship? What rules are required to keep the peace?");
        s.add("Where’s the strangest place you’ve had sex? (Everybody answers)");
        s.add("What’s the sex skill you’re most proud of? (Everybody answers)");
        s.add("Describe your sex life with a movie title, and tell us your reasoning. (Everybody answers)");
        s.add("Have you ever done butt stuff? If not, would you like to? (Everybody answers)");
        s.add("Have you ever had a threesome? Would you?");
        s.add("Tell us about an awkward or inappropriate sex dream you’ve had. Was anyone here involved?");
        s.add("When was the last time you were tested for a sexually transmitted infection? What were the results?");
        s.add("Have I ever popped into your head while you were masturbating? Will it happen now that we’ve asked the question?");
        s.add("Who do you think has had more sexual partners, you or me?");
        s.add("What was your best orgasm? Was it with yourself, or someone else?");
        s.add("Describe your first time having sex. Include every cringey detail.");
        s.add("What’s the messiest thing you’ve ever done sexually?");
        s.add("If we were stuck on a desert island, would we become lovers?");
        s.add("How many people have you hooked up with off dating apps?");
        s.add("Have you ever been caught masturbating or having sex?");
        s.add("Have you ever cheated on anyone? What were the circumstances?");
        s.add("Have you ever had a one-night stand?");
        s.add("Who do you think will have more sexual partners by the time we die, you or me?");
        s.add("Have you ever walked in  on your parents doing that thing that grownups do when they love each other very much?");
        s.add("What was your most shame-filled orgasm?");
        s.add("Who here would have the best sexual chemistry with me? Based upon what evidence?");
        s.add("What’s something you wish your ex would have done sexually, but didn’t?");
        s.add("Have I gotten sexier since you’ve known me?");
        s.add("If I cheat on my partner, is it absolutely essential that I tell them? Why or why not?");
        s.add("True or false: sometimes it’s okay to have unprotected sex. Explain your reasoning.");
        s.add("Have you ever had sex with someone who was already in a committed relationship?");
        s.add("If I had a hot brother/sister, would you let them seduce you?");
        s.add("Have you ever slid into someone’s DMs? Any techniques you want to share?");
        s.add("Assuming we were both single, would you date me?");
        s.add("Have you ever feared for your life or safety while drinking or on drugs? Take us to the scene.");
        s.add("How often are you intoxi- cated when you have sex? How often are you sober? What’s the difference?");
        s.add("Do you find me physically attractive? What if I bat my eyelashes like this?");
        s.add("What is your favorite sexual position and why?");
        s.add("When was the last time you masturbated?");
        s.add("What’s a sexual thing you’ve never been able to try, but wish you could?");
        s.add("What’s your opinion of open relationships?");
        s.add("What’s your experience with monogamy?");
        s.add("What would it take for you to sleep with someone you’re not physically attracted to?");
        s.add("If I had a hot mom/dad, would you let them seduce you?");
        s.add("Have you ever served food or other edibles in an erotic context? How did it go?");
        s.add("What would it take for us to have sex?");
        s.add("What’s a sexual thing you gave a good try, but just couldn’t get into?");
        s.add("Name the person here you’d most like to hook up with (but haven’t).");
        s.add("What’s the last inanimate object you put inside yourself or another person?");
        s.add("Do you have nude images of anyone that I know on your phone right now?");
        s.add("How open are you about your most intimate fantasies with your partner(s)?");
        s.add("If your sex life was a pie chart, what portion of it would be: satisfactory, unsatisfactory, and mind-blowing?");
        s.add("Describe your sex life with a song title.");
        s.add("Are you more sexperimental, or less sexperimental, than the average person?");
        s.add("How much money would a voyeuristic billionaire have to pay us for us to have sex in his velvet blimp?");
        s.add("What’s your most- complimented anatomical feature (as described by your lovers?)");
        s.add("Who was the last person (besides your partner or your kids) whose junk you’ve seen?");
        s.add("True or false: great sex requires a connection beyond physical attraction. Explain your thinking.");
        s.add("Tell us about the first time you ever saw porn.");
        s.add("True or false: great sex requires lube. State your case with first-hand evidence.");
        s.add("Have you ever been injured while having sex?");
        s.add("Have you ever paid for sex? Even if you haven’t, is there anything inherently problematic about it?");
        s.add("Would you be (or have you been) a “guest star” in another couple’s bedroom?");
        s.add("Describe the perfect foreplay: what activities, and for how long?");
        s.add("The various sex juices. Sometimes they get on clothes. Tell us about when it happened to you.");
        s.add("Have you ever sent nudes? How do you compose, frame, and light these images?");
        s.add("What do you think is your most unique sexual interest?");
        s.add("Who was the last person (besides your partner or your doctor) who’s seen your junk?");
        s.add("Have you ever cried after—or during—sex?");
        s.add("Have you ever had to contact past partners for... public health reasons?");
        s.add("What’s the weirdest porn that you’ve ever clicked on?");
        s.add("Do you have an age ceiling for a one-night stand?");
        s.add("If we were in a porn together, what category would it be filed under?");
        s.add("What’s the maximum number of people you’d be interested in having sex with at once?");
        s.add("Tell us a weird but true story about an inappropriate boner.");
        s.add("Who’s had more sex, you or your parents?");
        s.add("Inadvertent nudity. Tell us about when it happened to you.");
        s.add("Have you ever found yourself wearing somebody else’s underwear?");
        s.add("Quick! Name your favorite porn star. And tell us about all the wonderful qualities that make them special.");
        s.add("How would your partner (or your latest ex) describe your sex life with a movie title?");
        s.add("What’s the most surprising discovery you’ve made about your own body?");
        s.add("When was the last time you had unprotected sex? Did it ever cross your mind?");
        s.add("If a studio were to make a porn specifically for you, tailored to your specific tastes, what would it be like?");
        s.add("How did your parents talk to you about sex?");
        s.add("What will be the sexy nickname they give you when you live at the old- folks’ home?");
        s.add("Have you ever been sexual on camera? Would you want to?");
        s.add("You can send a message back in time to your teenage self about sex. What advice will you impart?");
        s.add("Who here is the most likely to star in an adult film? Who here is the most likely to make and direct porn?");
        s.add("What sex-related word are you not sure how to pronounce?");
        s.add("What’s the kinkiest thing you’ve asked someone else to do?");
        s.add("If you can abstain from sex and masturbation for one full year, you’ll win $27,000 and a nice used car. Will you make it?");
        s.add("Are you a good kisser? How do you know?");
        s.add("What did you observe from porn that you later realized was unrealistic? How’d you make this discovery?");
        s.add("Imagine we’re your future (or current) children. How do you present the birds- and-the-bees talk to us?");
        s.add("What scared you the most about sex as you were coming of age?");
        s.add("Do you see yourself committing to one sexual partner for the rest of your life?");
        s.add("Do you think you have more or less sex than your next-door neighbors?");
        s.add("Are you more of a top, a bottom, or versatile? Or do these labels not apply to you?");
        s.add("What’s the kinkiest thing you were ever asked to do, but you declined instead?");
        s.add("Are you loud during sex? Demonstrate with a dramatic interpretation of your signature sex sounds.");
        s.add("Tell us about a time in which a romantic partner just didn’t understand how to do a certain sex thing.");
        s.add("Do you have recurring fantasies that kind of trouble you, or surprise you? What are they?");
        s.add("Have you ever had sexy times in public?");
        s.add("Describe the present state of your pubic hair.");
        s.add("How would you describe your nipples to a blind person?");
        s.add("When it comes to your sexual orientation, have you ever considered experimenting?");
        s.add("Have you ever paid for porn? If so—how much money is in your spank bank budget?");
        s.add("Do you know where your G-spot is? Are you sure?");
        s.add("List all the illicit drugs you’ve tried. What more would you like to try?");
        s.add("How confident are you in your oral sex skills? How do you know?");

        Collections.shuffle(s);

        SwipeFlingAdapterView swipeFlingAdapterView=(SwipeFlingAdapterView) findViewById(R.id.card);

        arrayAdapter=new ArrayAdapter<String>(this, R.layout.details, R.id.textView, s);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter(){
                s.remove(0);
                arrayAdapter.notifyDataSetChanged();

                if(s.size()==0) {
                    backToMainButton.setVisibility(View.VISIBLE);
                    bottleGif.setVisibility(View.VISIBLE);
                    konfettiView.start(party);
                    if (num_players > 0) {
                        answerButton.setVisibility(View.GONE);
                        drinkButton.setVisibility(View.GONE);
                        skipButton.setVisibility(View.GONE);
                        player1.setVisibility(View.GONE);
                        player2.setVisibility(View.GONE);
                        player3.setVisibility(View.GONE);
                        player4.setVisibility(View.GONE);
                        player_turn.setVisibility(View.GONE);
                        score_board.setVisibility(View.GONE);
                        int winnerIndex = 0;
                        int maxScore = userList.get(0).getScore();
                        for (int i = 1; i < userList.size(); i++) {
                            if (maxScore < userList.get(i).getScore()) {
                                maxScore = userList.get(i).getScore();
                                winnerIndex = i;
                            }
                        }
                        ArrayList<Integer> winners = new ArrayList<Integer>();
                        winners.add(winnerIndex);
                        for (int i = 0; i < userList.size(); i++) {
                            if (i != winnerIndex && maxScore == userList.get(i).getScore()) {
                                winners.add(i);
                            }
                        }

                        if (maxScore == 0) {
                            no_winners_gif.setVisibility(View.VISIBLE);
                            winner.setText("No one scored any points...");
                        } else {
                            bottleGif.setVisibility(View.VISIBLE);
                            if (winners.size() == 1) {
                                winner.setText("Player " + (winnerIndex + 1) + " has won with a score of " + maxScore + " points!!!");
                            } else {
                                String win = "Players ";
                                if (winners.size() == 2) {
                                    win += (winners.get(0) + 1) + " and " + (winners.get(1) + 1);
                                } else {
                                    for (int i = 0; i < winners.size() - 1; i++) {
                                        win += (i + 1) + ", ";
                                    }

                                    win += "and " + (winners.get(winners.size() - 1) + 1);
                                }
                                winner.setText(win + " have tied with a score of " + maxScore + " points!!!");
                            }

                        }

                    }
                    else{
                        winner.setText("The game has finished!");
                    }
                }
            }

            @Override
            public void onLeftCardExit(Object o){

            }

            @Override
            public void onRightCardExit(Object o){

            }

            @Override
            public void onAdapterAboutToEmpty(int i){

            }

            @Override
            public void onScroll(float v){

            }


        });

    }
}