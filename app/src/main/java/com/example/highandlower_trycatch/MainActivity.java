package com.example.highandlower_trycatch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    int randomNumbber;

    public void setRandomNumbberGenerator(){

        Random rand = new Random();
        randomNumbber = rand.nextInt(20)+1;

    }

    public void onTebak(View view)
    {

        try {
            EditText jawaban;
            jawaban=findViewById(R.id.jawaban);
            int tebakan = Integer.parseInt(jawaban.getText().toString());
            if(tebakan < randomNumbber && tebakan <= 20)
            {

                Toast.makeText(this, "Too low, approaching", Toast.LENGTH_SHORT).show();
            } else if (tebakan > randomNumbber && tebakan <= 20)
            {
                Toast.makeText(this, "Too high, Approaching", Toast.LENGTH_SHORT).show();
            } else if (tebakan == randomNumbber && tebakan <= 20)
            {
                Toast.makeText(this, "Congrat's Guys,correct: "+randomNumbber, Toast.LENGTH_SHORT).show();
                setRandomNumbberGenerator();
            } else if (tebakan > 20) {

                jawaban.setError("Angka tidak boleh lebih dari 20");
            }

        } catch (Exception e)
        {
            EditText jawaban=findViewById(R.id.jawaban);
            jawaban.setError("Jawaban Harus Berupa Angka");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumbber = rand.nextInt(20)+1;

//        RelativeLayout relativeLayout = findViewById(R.id.mainLayout);
//
//        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(25);
//        animationDrawable.setExitFadeDuration(50);
//        animationDrawable.start();

    }
}