package jstam.stamjessie_pset1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


/*
 * ThirdActivity.java
 * Madlibs
 *
 * By Jessie Stam
 * 10560599
 *
 * Prints the story to the screen and allows the user to start another story.
 *
 * Unfortunately I haven't been able to test this code, due to bugs in SecondActivity.
 */

public class ThirdActivity extends SecondActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);

        Bundle extras = getIntent().getExtras();
        String story = extras.getString("finalStory");

        // print story to the screen
        TextView printingStory = (TextView)
                findViewById(R.id.story_text);

        printingStory.append("" + story);
    }

    public void returnToSecondScreen(View view) {
        // end activity to go back to previous activity
        finish();
    }
}
