package com.cs4750.android.truthordrink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;


import java.util.ArrayList;
import java.util.Collections;

public class Deck1 extends AppCompatActivity {

    ArrayList<String > s;
    ArrayAdapter arrayAdapter;
    int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck1);
        s=new ArrayList<String >();
        s.add("Pay me three sincere compliments. (Everybody answers)");
        s.add("What’s the best compliment you’ve ever been given? (Everybody answers)");
        s.add("What’s something you’re proud of that not many people know about? (Everybody answers)");
        s.add("What’s the most common thing people praise or compliment you for? (Everybody answers)");
        s.add("What bad habit have you kicked? (Everybody answers)");
        s.add("Who here is the kindest? Tell us why—with lovely examples. (Everybody answers)");
        s.add("Would you “take care” of a spider for me? What about a cockroach?");
        s.add("Why do you put up with me?");
        s.add("Tell me your favorite joke. If I laugh, I drink.");
        s.add("What motto would you put on your famliy crest?");
        s.add("Describe a time you accidentally mortified your parents as a child.");
        s.add("If I could help you with one unpleasant task, what would it be?");
        s.add("Fill in the blank. Defend yourself: I don’t care if ____ is for kids, I will still love it until I die.");
        s.add("Do you try to always be honest with me, or do you tell me “that haircut looks great”-level white lies to be nice?");
        s.add("What’s the best zinger you’ve ever come up with on the fly? I know you remember it.");
        s.add("What are the farthest lengths you’ve gone to to cheer someone up?");
        s.add("What’s the the most courageous thing you’ve ever accomplished?");
        s.add("Aside from “moist”, what word can’t you stand the sound of?");
        s.add("What is your ideal name for a dog? A cat? Now pick any non-traditional pet and name it.");
        s.add("What movie or TV character do I most remind you of?");
        s.add("What song are you most ashamed to admit to me that you love? Reply in song.");
        s.add("With what hilarious story about me do you regale people I do not know?");
        s.add("Am I better or worse off when I am caffeinated?");
        s.add("Name a dream of yours that you’ve made come true.");
        s.add("What is your happiest memory from when you were a single-digit-aged child?");
        s.add("What’s a situation that is always improved by my presence?");
        s.add("Who would play me in the Oscar-winning film about my life?");
        s.add("When’s the exact moment you knew we were on the same wavelength?");
        s.add("If you had synesthesia, what color would I make you feel?");
        s.add("How have I helped you the most?");
        s.add("What’s the most consid- erate present you’ve ever received? Given?");
        s.add("If dogs and their owners are supposed to have matching personalities, what type of dog should I get?");
        s.add("What’s the title of your autobiography? Extra imaginary points if it includes a colon and a subtitle.");
        s.add("What’s your favorite memory of our relationship?");
        s.add("What movie or TV quote hits a little too close to home?");
        s.add("Would you give me one of your kidneys?");
        s.add("What snack do you find the most comfort in consuming?");
        s.add("What is something you love about me that other people don’t understand at all?");
        s.add("What positive impact do you think you have on other people?");
        s.add("If you could have any body part of mine (for aesthetic, not medical, reasons), what would it be?");
        s.add("If you could plan the perfect night with all of your friends, what would it entail?");
        s.add("What would you entrust me with above anyone else?");
        s.add("What board game are you positive you could destroy us all at?");
        s.add("What’s something I’m self- conscious about that you think I should stop stressing out over?");
        s.add("Describe the dream vacation you haven’t gotten to take.");
        s.add("Then tell me how you can make it happen in five years or less.");
        s.add("What’s your ultimate Sunday look like? Your ultimate sundae?");
        s.add("What dish do you slay in the kitchen every time you make it?");
        s.add("What are you rooting for me to achieve?");
        s.add("What author’s body of work do you wish you were actually responsible for?");
        s.add("If you could instantly gain any skill, what would it be?");
        s.add("On what topic could you be an expert TV talking head?");
        s.add("If there were no barriers to entry, what job do you think you’d be amazing at?");
        s.add("Out of all of us, whose eyes would you like to see the world through for a day?");
        s.add("Show me the funniest thing on the internet under 30 seconds long. If I laugh, I drink.");
        s.add("We’re binging tonight! Pick the show and the snack.");
        s.add("What song reminds you of me whenever you hear it?");
        s.add("Would you ever see a band in concert that you hated just to make me happy? Have you?");
        s.add("When do you think you peaked?");
        s.add("If I were a perfume or cologne, what would my top, heart, and base notes be?");
        s.add("Do you ever just let me win?");
        s.add("What best represents me as a friend: a weighted blanket, a spin class, or a wine tasting?");
        s.add("What’s the most kickass you’ve ever felt?");
        s.add("What’s the most fun you’ve ever had with strangers? Tell us the story.");
        s.add("We’re starting a business. What venture would we be most successful at as a pair?");
        s.add("If we formed a gang, what would the name of our posse be?");
        s.add("What do you wish you were as good at as me?");
        s.add("What is something you know you’ll accomplish, no matter how many people tell you you can’t?");
        s.add("If someone did me wrong, would you (a) comfort me, (b) distract me, or (c) get revenge for me?");
        s.add("What makes you so much fun?");
        s.add("If you could live anyone else’s life, whose would it be?");
        s.add("How many seconds is the ideal hug? Should we all test your hypothesis?");
        s.add("What is the most comforting sound in the world?");
        s.add("Describe an act of petty protest you waged at work or school.");
        s.add("What’s one thing you can start doing to put more beauty back into the world?");
        s.add("What’s something that completely changed you when you encountered it for the first time?");
        s.add("Do you ever pity-laugh at my jokes, even if you don’t think they’re funny?");
        s.add("What discontinued item would you give anything to bring back?");
        s.add("Would you trust me to pierce your ear, 80’s-sleepover style?");
        s.add("I’m going to have permanent art deposited into my skin with needles. Pick a design for me. Bonus points if you draw it.");
        s.add("What’s the biggest fear you’ve overcome?");
        s.add("What smell takes you back to childhood?");
        s.add("Do you brag about me to other people? What do you say?");
        s.add("You suddenly become wealthy beyond the dreams of avarice. What do you do with the rest of your life?");
        s.add("What’s the weirdest compliment you’ve ever gotten?");
        s.add("What would be your cheesy, 20-second, game-show- contestant anecdote?");
        s.add("If I couldn’t reach an itch, would you do me a solid and scratch it?");
        s.add("What’s guaranteed to hit you right in the feels?");
        s.add("If you were a Care Bear, what would be on your belly?");
        s.add("We’re road tripping through the middle of nowhere.");
        s.add("Do you have me drive or navigate?");
        s.add("What was your first impression of me? Has it turned out to be the case?");
        s.add("What’s the hold music for your brain?");
        s.add("What’s the strangest nickname you’ve ever been given?");
        s.add("You get to travel back in time to warn me about one thing. What would it be?");
        s.add("Liking what piece of pop culture gets someone your automatic stamp of approval?");
        s.add("Of all the things we do together, what is the best thing we do together?");
        s.add("If we were flying some- where together, who would volunteer to sit in the middle seat?");
        s.add("What did you think you would hate, but ended up loving?");
        s.add("What album have you spun the most times? Be honest. You can consult your music apps for verification.");
        s.add("What do you secretly think I’d be amazing at?");
        s.add("Who here is most likely to believe in supernatural, occult, or mystical stuff?");
        s.add("Tell me about a disagree- ment we had—and how we resolved it. Has it made us stronger?");
        s.add("What is your greatest style- related regret as an adult? Have you glo’d up since?");
        s.add("What’s the most embarassing thing you’ve had to ask Google?");
        s.add("When was the last time you laughed so hard you cried?");

        Collections.shuffle(s);

        SwipeFlingAdapterView swipeFlingAdapterView=(SwipeFlingAdapterView) findViewById(R.id.card);

        arrayAdapter=new ArrayAdapter<String>(this, R.layout.details, R.id.textView, s);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter(){
                s.remove(0);
                arrayAdapter.notifyDataSetChanged();
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