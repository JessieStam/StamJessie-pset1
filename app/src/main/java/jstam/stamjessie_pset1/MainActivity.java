package jstam.stamjessie_pset1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
 * MainActivity.java
  * Madlibs
  *
  * By Jessie Stam
  * 10560599
  *
  * Instructs the user on how to use the application, then continues to SecondActivity.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // when start button is clicked, open Second Activity
    public void getStarted(View view) {

        Intent startApp = new Intent(this, SecondActivity.class);
        startActivity(startApp);

        finish();
    }
}