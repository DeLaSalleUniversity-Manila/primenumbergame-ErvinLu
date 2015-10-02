package com.example.lufamily.primenumbergame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private int number;
    private int score = 0;
    private boolean answer;

    public void onClickGenerate(View view)
    {
        randomizer();
    }

    public void onClickPrime(View view)
    {
        if(isComposite())
        {
            score-=5;
            TextView tvScore = (TextView) findViewById(R.id.textViewScore);
            tvScore.setText("Score" + score);
            Toast.makeText(this, "INCORRECT!", Toast.LENGTH_SHORT).show();
        }
        else{
            score++;
            TextView tvScore = (TextView) findViewById(R.id.textViewScore);
            tvScore.setText("Score" + score);
            Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Previous number: "+ number,Toast.LENGTH_SHORT).show();
        randomizer();
    }

    public void onClickComposite(View view)
    {
        if(isComposite())
        {
            score++;
            TextView tvScore = (TextView) findViewById(R.id.textViewScore);
            tvScore.setText("Score: " + score);
            Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show();
        }
        else{
            score-=5;
            TextView tvScore = (TextView) findViewById(R.id.textViewScore);
            tvScore.setText("Score" + score);
            Toast.makeText(this, "INCORRECT!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Previous number: "+ number,Toast.LENGTH_SHORT).show();
        randomizer();
    }

    private void randomizer() //RANDOMIZER
    {
        Random r = new Random();
        number = 2 + r.nextInt(1000);  // Random numbers: 2 - 999
        TextView tvNum = (TextView) findViewById(R.id.textViewNumber);
        tvNum.setText("" + number); // "" + int -> converts int to String
    }

    private boolean isComposite()
    {
        int i, ctr = 0;
        for(i = 2; i < number - 1; i++)
        {
            if(number % i == 0)
            {
                ctr++;
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
