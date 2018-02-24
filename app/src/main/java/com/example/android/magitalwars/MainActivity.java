package com.example.android.magitalwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean devConstantDamage = false;
    boolean wizConstantDamage = false;
    int developersScore = 50;
    int wizardsScore = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            devConstantDamage = savedInstanceState.getBoolean("devConstantDamage");
            wizConstantDamage = savedInstanceState.getBoolean("wizConstantDamage");
            developersScore = savedInstanceState.getInt("developersScore");
            wizardsScore = savedInstanceState.getInt("wizardsScore");
        }
        displayScore();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("devConstantDamage", devConstantDamage);
        outState.putBoolean("wizConstantDamage", wizConstantDamage);
        outState.putInt("developersScore", developersScore);
        outState.putInt("wizardsScore", wizardsScore);
    }

    // Subtracts 10 from wizardsScore
    public void developersDamage(View view) {
        wizardsScore -= 10;
        if (wizConstantDamage) {
            developersScore -= 5;
        }
        if (developersScore <= 0) {
            developersScore = 0;
            Toast.makeText(this, R.string.wizards_win, Toast.LENGTH_SHORT).show();
        }
        if (wizardsScore <= 0) {
            wizardsScore = 0;
            Toast.makeText(this, R.string.developers_win, Toast.LENGTH_SHORT).show();
        }
        displayScore();
    }

    // Subtracts 10 from developersScore
    public void wizardsDamage(View view) {
        developersScore -= 10;
        if (devConstantDamage) {
            wizardsScore -= 5;
        }
        if (developersScore <= 0) {
            developersScore = 0;
            Toast.makeText(this, R.string.wizards_win, Toast.LENGTH_SHORT).show();
        }
        if (wizardsScore <= 0) {
            wizardsScore = 0;
            Toast.makeText(this, R.string.developers_win, Toast.LENGTH_SHORT).show();
        }
        displayScore();
    }

    // Subtracts 5 from wizardsScore until wizardsSummon is used
    public void developersConstantDamage(View view) {
        wizardsScore -= 5;
        devConstantDamage = true;
        if (wizConstantDamage) {
            developersScore -= 5;
        }
        if (developersScore <= 0) {
            developersScore = 0;
            Toast.makeText(this, R.string.wizards_win, Toast.LENGTH_SHORT).show();
        }
        if (wizardsScore <= 0) {
            wizardsScore = 0;
            Toast.makeText(this, R.string.developers_win, Toast.LENGTH_SHORT).show();
        }
        displayScore();
    }

    // Subtracts 5 from developersScore until developersSummon is used
    public void wizardsConstantDamage(View view) {
        developersScore -= 5;
        wizConstantDamage = true;
        if (devConstantDamage) {
            wizardsScore -= 5;
        }
        if (developersScore <= 0) {
            developersScore = 0;
            Toast.makeText(this, R.string.wizards_win, Toast.LENGTH_SHORT).show();
        }
        if (wizardsScore <= 0) {
            wizardsScore = 0;
            Toast.makeText(this, R.string.developers_win, Toast.LENGTH_SHORT).show();
        }
        displayScore();
    }

    //Ends effect of wizardsConstantDamage, adds 5 to developersScore, subtracts 5 from wizardsScore
    public void developersSummon(View view) {
        wizConstantDamage = false;
        developersScore += 5;
        wizardsScore -= 5;
        if (wizardsScore <= 0) {
            wizardsScore = 0;
            Toast.makeText(this, R.string.developers_win, Toast.LENGTH_SHORT).show();
        }
        if (developersScore > 100) {
            developersScore = 100;
            Toast.makeText(this, R.string.maximum_score, Toast.LENGTH_SHORT).show();
        }
        displayScore();
    }

    //Ends effect of developersConstantDamage, adds 5 to wizardsScore, subtracts 5 from developersScore
    public void wizardsSummon(View view) {
        devConstantDamage = false;
        wizardsScore += 5;
        developersScore -= 5;
        if (developersScore <= 0) {
            developersScore = 0;
            Toast.makeText(this, R.string.wizards_win, Toast.LENGTH_SHORT).show();
        }
        if (wizardsScore > 100) {
            wizardsScore = 100;
            Toast.makeText(this, R.string.maximum_score, Toast.LENGTH_SHORT).show();
        }
        displayScore();
    }

    //Adds 10 to developersScore
    public void developersHealing(View view) {
        developersScore += 10;
        if (wizConstantDamage) {
            developersScore -= 5;
        }
        if (developersScore > 100) {
            developersScore = 100;
            Toast.makeText(this, R.string.maximum_score, Toast.LENGTH_SHORT).show();
        }
        displayScore();
    }

    //Adds 10 to wizardsScore
    public void wizardsHealing(View view) {
        wizardsScore += 10;
        if (devConstantDamage) {
            wizardsScore -= 5;
        }
        if (wizardsScore > 100) {
            wizardsScore = 100;
            Toast.makeText(this, R.string.maximum_score, Toast.LENGTH_SHORT).show();
        }
        displayScore();
    }

    //Sets developersScore and wizardsScore to 50, ends effect of developersConstantDamage and wizardsConstantDamage
    public void reset(View view) {
        developersScore = 50;
        wizardsScore = 50;
        devConstantDamage = false;
        wizConstantDamage = false;
        displayScore();
    }

    //Updates the score TextViews with their new values
    public void displayScore() {
        TextView developersScoreTextView = findViewById(R.id.developers_score_textview);
        TextView wizardsScoreTextView = findViewById(R.id.wizards_score_textview);
        developersScoreTextView.setText("" + developersScore);
        wizardsScoreTextView.setText("" + wizardsScore);
    }

}