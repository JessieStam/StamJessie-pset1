package jstam.stamjessie_pset1;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.xml.transform.stream.StreamSource;

/**
 * Created by Jessie on 24/04/2016.
 */
public class SecondActivity extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        // read story text? zorg dat dit random is
        // getNextPlaceholder voor placeholder
        // fillInPlaceholder om in te vullen
        // check hoeveel placeholders er nog moeten
        // toString method om verhaal te krijgen
        // op de een of andere manier kun je om story vragen met extra intent shit
        // je moet ook story en second en third activity nog toevoegen aan dat vage bestand zoals in het filmpje

        // define textfiles InputStreams
        InputStream madlib0 = getResources().openRawResource(R.raw.madlib0_simple);
        InputStream madlib1 = getResources().openRawResource(R.raw.madlib1_tarzan);
        InputStream madlib2 = getResources().openRawResource(R.raw.madlib2_university);
        InputStream madlib3 = getResources().openRawResource(R.raw.madlib3_clothes);
        InputStream madlib4 = getResources().openRawResource(R.raw.madlib4_dance);

        Story storyName = new Story(madlib0);

        // random int between 1 and 5
        Random randomStoryNum = new Random();
        int StoryNum = randomStoryNum.nextInt(5) + 1;

        // define story at random
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

        // nu de story readen? Oke we gaan ervan uit dit ik dit nu heb gedaan yolo
        // (construct is done) pass an input stream or Scanner to read the story text

        // get amount of placeholders and print to screen
        Integer totalPlaceholders = storyName.getPlaceholderCount();

        TextView callingActivityMessage = (TextView)
                findViewById(R.id.wordsLeftAmount);

        callingActivityMessage.append(" " + totalPlaceholders);


        Button okButton = (Button) findViewById(R.id.wordConfirmButton);

        View.OnClickListener okButton = new View.OnClickListener() {
            public void onClickAddWord(View v) {

                // get remaining placeholders and print to screen
                Integer totalPlaceholders = storyName.getPlaceholderRemainingCount();

                TextView callingActivityMessage = (TextView)
                        findViewById(R.id.wordsLeftAmount);

                callingActivityMessage.append(" " + totalPlaceholders);

                // get placeholder and print to screen as an instruction for the user
                String placeholderWord = storyName.getNextPlaceholder();

                TextView placeholderInstruction = (TextView)
                        findViewById(R.id.textToEnter);

                placeholderInstruction.append(" " + placeholderWord);

                // get placeholder and print to screen as an instruction for the user
                String placeholderWord = storyName.getNextPlaceholder();

                TextView placeholderInstruction = (TextView)
                        findViewById(R.id.textToEnter);

                placeholderInstruction.append(" " + placeholderWord);


                // oké, het opslaan van die fucking woorden

                List userWords = new ArrayList();

                String userInput = getText.toString(R.id.wordInput);

                // verander placeholderWord in string
                String placeholderWord = storyName.fillInPlaceholder(string word);

                Boolean filledIn = storyName.isFilledIn();

                if(filledIn) {
                    // replace words with input?? nee, in third activity
                    // open third activity
                    Intent printStory = new Intent(this, ThirdActivity.class);

                    printStory.putExtra("userInputWords");

                    startActivityForResult(printStory, "wordInput");




                }

        }




    }
}
