package com.aboalfarag.assignmnet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        TextView scoreText=findViewById(R.id.scoreText);
        TextView highestText=findViewById(R.id.highestText);
        Button tryAgainBtn=findViewById(R.id.tryAgain);
        TextView gradeText=findViewById(R.id.gradeText);
        Intent intent=getIntent();
        int score=intent.getIntExtra("score",0);
        if(score<10){
            gradeText.setText("Are you dumb?");
        }
        else if(score<15){
            gradeText.setText("Good");

        }
        else{
            gradeText.setText("Genius");

        }
        String ans=String.valueOf(score);
        int high;
        SharedPreferences sharedPreferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("highest")){
             high=sharedPreferences.getInt("highest",0);
        }
        else{
            high=score;
        }
        if(score>high){
            high=score;
        }
        highestText.setText(String.valueOf(high));
        ans+="/20";
        scoreText.setText(ans);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("highest", high);
        editor.apply();

        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ScoresActivity.this,MainActivity.class));
            }
        });

    }
}