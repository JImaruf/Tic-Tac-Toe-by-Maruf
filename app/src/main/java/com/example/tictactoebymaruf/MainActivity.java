package com.example.tictactoebymaruf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tictactoebymaruf.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int count=0;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    MediaPlayer mp1,mp2,mp3;
    LayoutInflater inflater;
    View layout;
    TextView text;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mp1=MediaPlayer.create(MainActivity.this,R.raw.xturns);
        mp2=MediaPlayer.create(MainActivity.this,R.raw.oturns);
        mp3=MediaPlayer.create(MainActivity.this,R.raw.ohno);

        binding.oTurns.setVisibility(View.GONE);


       inflater  = getLayoutInflater();
        layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.wronglayout));


       text = (TextView) layout.findViewById(R.id.wrong);


        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 250);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);


    }

    public void getData(View view) {

        Button currentBTN = (Button) view;



        if(currentBTN.getText().toString().equals("")) {
                count++;
            if (count % 2 == 0) {
                mp1.start();
                currentBTN.setText("O");

                binding.oTurns.setVisibility(View.GONE);

                binding.xTurns.setVisibility(View.VISIBLE);


            } else {
                mp2.start();
                currentBTN.setText("X");
                binding.xTurns.setVisibility(View.GONE);

                binding.oTurns.setVisibility(View.VISIBLE);

            }



        }
        else
        {

            mp3.start();
            toast.show();

        }



        if(count>4)
        {
            getvalues();
            if(b1.equals(b2)&&b2.equals(b3)&&!b1.equals(""))
            {
                winnerResultF(b1);

            }
           else if(b1.equals(b4)&&b4.equals(b7)&& !b1.equals(""))
            {
                winnerResultF(b1);
            }
           else if(b1.equals(b5)&&b5.equals(b9)&& !b1.equals(""))
            {
                winnerResultF(b1);
            }
          else  if(b2.equals(b5)&&b5.equals(b8)&& !b2.equals(""))
            {
                winnerResultF(b2);
            }
           else if(b3.equals(b6)&&b6.equals(b9)&& !b3.equals(""))
            {
                winnerResultF(b3);
            }
           else if(b3.equals(b5)&&b5.equals(b7)&& !b3.equals(""))
            {
                winnerResultF(b3);


            }
           else if(b4.equals(b5)&&b5.equals(b6)&&!b4.equals(""))
            {
                winnerResultF(b4);

            }
          else if(b7.equals(b8)&&b8.equals(b9)&& !b7.equals(""))
            {
                winnerResultF(b7);

            }
            else if(count>=9)
            {
                if(!b1.equals("")&&!b2.equals("")&&!b3.equals("")&&!b4.equals("")&&!b5.equals("")&&!b6.equals("")&&!b7.equals("")&&!b8.equals("")&&!b9.equals(""))
                {
                    winnerResultF("Draw");
                }
            }




        }



    }

    private void winnerResultF(String result) {

        Intent intent = new Intent(MainActivity.this,WinnerResult.class);
        intent.putExtra("winner",result);
        startActivity(intent);
    }

    private void getvalues() {

        b1=binding.bt1.getText().toString();
        b2=binding.bt2.getText().toString();
        b3=binding.bt3.getText().toString();
        b4=binding.bt4.getText().toString();
        b5=binding.bt5.getText().toString();
        b6=binding.bt6.getText().toString();
        b7=binding.bt7.getText().toString();
        b8=binding.bt8.getText().toString();
        b9=binding.bt9.getText().toString();
    }


    public void playAgain(View view) {
        mp1.start();
        startActivity(new Intent(MainActivity.this,MainActivity.class));


    }
}