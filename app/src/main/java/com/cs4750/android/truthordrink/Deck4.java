package com.cs4750.android.truthordrink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;


import java.util.ArrayList;
import java.util.Collections;

public class Deck4 extends AppCompatActivity {

    ArrayList<String > s;
    ArrayAdapter arrayAdapter;
    int n = 0;
    Button answerButton;
    Button drinkButton;
    Button skipButton;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_deck4);

        Bundle values = getIntent().getExtras();
        final int num_players = values.getInt("players");
        score_board=findViewById(R.id.linearLayout);
        answerButton = findViewById(R.id.answer_button);
        drinkButton = findViewById(R.id.drink_button);
        skipButton = findViewById(R.id.skip_button);
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
        if(num_players==0){
            player_turn.setVisibility(View.GONE);
            answerButton.setVisibility(View.GONE);
            drinkButton.setVisibility(View.GONE);
            skipButton.setVisibility(View.GONE);
            score_board.setVisibility(View.GONE);
        }

        s=new ArrayList<String >();
        s.add("Does our relationship bring out the best in you? In me? If not, why? (Everybody answers)");
        s.add("What’s something you resent about me? (Everybody answers)");
        s.add("Describe three ways to improve my physical appearance and general attractiveness. (Everybody answers)");
        s.add("Describe a time you lost a little bit of respect for me. (Everybody answers)");
        s.add("What percentage of the time do you think I’m completely full of shit? (Everybody answers)");
        s.add("Do you even remotely care what I think of you? (Everybody answers)");
        s.add("Do you think I’m more or less honest than you are?");
        s.add("Have you ever broken off plans with me to be with someone else?");
        s.add("Who is in control in our relationship?");
        s.add("Do you ever put me down to make yourself feel better?");
        s.add("What’s a fundamental difference between us, and will we ever resolve it?");
        s.add("Do you think I’ll ever do anything worth being remembered by society?");
        s.add("Where are we, and what are we doing, in ten years? Have we honestly improved each other’s lives?");
        s.add("Have you ever harassed someone online? Do you think they deserved it?");
        s.add("If someone was interested in dating me, what thing about me would you tell them to change their mind?");
        s.add("What have I ruined for you?");
        s.add("What problem do I think I’m successfully hiding from everyone, but is actually completely obvious?");
        s.add("Do you see us as equals?");
        s.add("What do you wish I’d just shut up about?");
        s.add("Do I often seem like I’m being fake?");
        s.add("Do you think I’m good parent material?");
        s.add("What negative thing have I said about you that’s haunted you forever?");
        s.add("What ethical boundaries are you happy to cross?");
        s.add("What thing do I love that you absolutely hate?");
        s.add("What one change could I make that would vastly improve who I am as a person?");
        s.add("Am I too picky? Too petty? Too selfish?");
        s.add("Have you ever considered ending our relationship? Why?");
        s.add("Do you ever think I need to cut back on drinking or drugs?");
        s.add("Have I ever done anything you think should have gotten me shitcanned?");
        s.add("What’s the most amount of money you would lend me?");
        s.add("What’s the most needlessly mean thing you’ve ever heard me say about someone else?");
        s.add("Are there certain situations with me you avoid on purpose?");
        s.add("What’s the most egregious lie you’ve ever told me?");
        s.add("What personal demon are you in denial of?");
        s.add("What advice do I need but don’t want to hear?");
        s.add("Do you think I’m too clingy or demand too much attention?");
        s.add("Do you think I’m continuing to grow, or is this the best I’ll ever be as a person?");
        s.add("Do you think I’m capable of doing something you could never forgive me for?");
        s.add("Are you sometimes embarrassed to be seen with me? Why?");
        s.add("What do I never seem to understand about you?");
        s.add("Do you think I have overachieved or underachieved?");
        s.add("What will you never understand about me?");
        s.add("Name one thing I do that disgusts you.");
        s.add("How have I disappointed you?");
        s.add("Have you ever hurt someone on purpose?");
        s.add("Name a time you wished we weren’t friends.");
        s.add("Do you ever feel like I’m holding you back?");
        s.add("What do you think I need to just let go of?");
        s.add("Who’s someone we know that you wish I was more like and why?");
        s.add("If I was in a relationship with someone you hated, would you tell me?");
        s.add("Is there anything about me that creeps you out?");
        s.add("Do you have any secrets you keep from me and me only?");
        s.add("Have I often struck you as immature or unable to take care of myself?");
        s.add("Would you hire me?");
        s.add("Is there an expiration date on our relationship?");
        s.add("Do you think I sometimes takes advantage of other people?");
        s.add("What do I think I’m great at, but am actually terrible at?");
        s.add("What’s the most serious crime you’ve ever committed?");
        s.add("What’s the worst thought you’ve ever had that you’ve never shared with anyone?");
        s.add("Have you ever been genuinely scared of me?");
        s.add("What is (or would be) the worst thing about having me as a travel companion?");
        s.add("Do you think I’m a bully?");
        s.add("What’s the bitchiest thing you’ve ever said about me behind my back?");
        s.add("What’s the most selfish thing you’ve ever done?");
        s.add("What’s an offensive opinion you will never let go of?");
        s.add("Name a time you could have helped someone, but didn’t bother.");
        s.add("What’s stupidest thing you’ve ever heard me say?");
        s.add("Do you think you’re better than me?");
        s.add("If you do something you know is wrong, but don’t get caught, do you keep doing it?");
        s.add("Have you ever stolen anything from me?");
        s.add("If I died tomorrow, what regrets would you have about our relationship?");
        s.add("What’s the longest period of time you could spend with me before never wanting to see me again?");
        s.add("What’s the weirdest thing about me?");
        s.add("Have you ever knowingly let me embarrass myself, even if you could have stopped it?");
        s.add("Do you sometimes lie about being busy if you don’t want to deal with me?");
        s.add("Would you trust me alone with your kids for more than a couple hours?");
        s.add("Do you ever warn people about me before they meet me?");
        s.add("Do you ever have to fake empathy?");
        s.add("Have you ever ghosted someone you were close with?");
        s.add("What’s the most annoying thing I do without realizing it?");
        s.add("What am I the most ignorant about?");
        s.add("Do you ever think I stir up drama because I enjoy it?");
        s.add("What’s something you know would make you a better person, but you just don’t want to do it?");
        s.add("Have you ever stabbed someone in the back or actively plotted against them?");
        s.add("Is this the best I’ve looked since you’ve known me?");
        s.add("What’s the worst thing you’ve ever done to an animal?");
        s.add("How have I changed for the worse since we’ve met?");
        s.add("What’s the most terrible thing you’ve ever done for money?");
        s.add("In what ways have you used me?");
        s.add("What’s the most unreasonable thing you’ve ever completely lost your shit over?");
        s.add("How have you dishonored your parents?");
        s.add("Have you ever had to apologize to someone for my behavior?");
        s.add("Have you ever intentionally scammed someone or misled them for personal gain?");
        s.add("If someone important to you said they’d stop seeing you unless you stopped seeing me, would you?");
        s.add("Name a time you thought I was weak.");
        s.add("When was the last time you were out of control?");
        s.add("When have you let your pride get in the way of doing the right thing?");
        s.add("Have you ever forced someone to do something against their will?");
        s.add("Have you ever pretended to be someone else on the internet?");
        s.add("Have you ever lied on a resume?");
        s.add("What’s the angriest you’ve ever been at me?");
        s.add("Would your life be any worse if we had never met?");
        s.add("What have you done while intoxicated that you wish you could take back?");
        s.add("If we lived across the country from each other, do you think we’d lose touch?");

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
                            winner.setText("No one scored any points...");
                        } else {
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