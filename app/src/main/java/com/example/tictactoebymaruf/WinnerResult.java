package com.example.tictactoebymaruf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoebymaruf.databinding.ActivityWinnerResultBinding;

public class WinnerResult extends AppCompatActivity {
    ActivityWinnerResultBinding binding;
    String  FINALRESULT;
     MediaPlayer win,fail,playAgain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWinnerResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        FINALRESULT=getIntent().getStringExtra("winner");
         win = MediaPlayer.create(WinnerResult.this, R.raw.winningsound);
         fail = MediaPlayer.create(WinnerResult.this,R.raw.fail);
       playAgain = MediaPlayer.create(WinnerResult.this,R.raw.xturns);
        if(FINALRESULT.equals("Draw"))
        {
            fail.start();
            binding.tv1.setText("Draw Game");

            binding.imageView.setImageResource(R.drawable.drawwwwww);
        }
        else {
            win.start();
            binding.tv1.setText("The Winner is " + FINALRESULT);

        }

    }

    public void back(View view) {
           playAgain.start();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}