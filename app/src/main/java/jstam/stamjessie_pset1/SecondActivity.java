package jstam.stamjessie_pset1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.io.InputStream;
import java.util.Random;

/*
 * SecondActivity.java
 * Madlibs
 *
 * By Jessie Stam
 * 10560599
 *
 * Lets the user fill in words for the placeholders in the story. Replaces the placeholders for
 * words from user. When all placeholders are filled, continues to ThirdActivity to print the
 * story.
 *
 * This code unfortunately doesn't work yet. Due to trouble with the software and lack of
 * understanding on my part, I wasn't able to debug this code in time. I hope that we can look
 * through the code during office hours so that I can understand my mistakes. Thanks in advance.
 */

public class SecondActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        // define textfiles InputStreams
        InputStream madlib0 = getResources().openRawResource(R.raw.madlib0_simple);
        InputStream madlib1 = getResources().openRawResource(R.raw.madlib1_tarzan);
        InputStream madlib2 = getResources().openRawResource(R.raw.madlib2_university);
        InputStream madlib3 = getResources().openRawResource(R.raw.madlib3_clothes);
        InputStream madlib4 = getResources().openRawResource(R.raw.madlib4_dance);

        Story storyName = new Story(madlib0);

        // get a random integer between 1 and 5
        Random randomStoryNum = new Random();
        int StoryNum = randomStoryNum.nextInt(5) + 1;

        // define story at random using random integer
        if (StoryNum == 1) {
            storyName = new Story(madlib0);
            storyName.read(madlib0);
        } else if (StoryNum == 2) {
            storyName = new Story(madlib1);
            storyName.read(madlib1);
        } else if (StoryNum == 3) {
            storyName = new Story(madlib2);
            storyName.read(madlib2);
        } else if (StoryNum == 4) {
            storyName = new Story(madlib3);
            storyName.read(madlib3);
        } else if (StoryNum == 5) {
            storyName = new Story(madlib4);
            storyName.read(madlib4);
        }

        // get total amount of placeholders and print to screen
        Integer totalPlaceholders = storyName.getPlaceholderCount();

        TextView callingActivityMessage = (TextView)
                findViewById(R.id.wordsLeftAmount);

        callingActivityMessage.append(" " + totalPlaceholders);

        Button okButton = (Button) findViewById(R.id.wordConfirmButton);

        // recognize when button is clicked
        final Story finalStoryName = storyName;
        View.OnClickListener okButton = new View.OnClickListener() {
            public void onClick(View v) {

                // get remaining placeholders and print to screen
                Integer remainingPlaceholders = finalStoryName.getPlaceholderRemainingCount();

                TextView callingActivityMessage = (TextView)
                        findViewById(R.id.wordsLeftAmount);

                callingActivityMessage.append(" " + remainingPlaceholders);

                // get placeholder and print to screen as an instruction for the user
                String placeholderWord = finalStoryName.getNextPlaceholder();

                TextView placeholderInstruction = (TextView)
                        findViewById(R.id.textToEnter);

                placeholderInstruction.append(" " + placeholderWord);

                // get user input and store in string
                EditText givenWord = (EditText) findViewById(R.id.wordInput);
                String userInput = givenWord.getText().toString();

                // change placeholderWord to user input
                String placeholderWord = finalStoryName.fillInPlaceholder(userInput);

                Boolean filledIn = finalStoryName.isFilledIn();

                // when everything is filled in, move on to third activity to print story
                if (filledIn) {
                    // create final story
                    final String finalStory = finalStoryName.toString();

                    // open third activity to display story
                    Intent printStory = new Intent(this, ThirdActivity.class);

                    printStory.putExtra("finalStory",finalStory);

                    // start new activity with the story
                    startActivity(printStory);

                    // finish this activity
                    finish();
                }
            }
        }
    }
}
