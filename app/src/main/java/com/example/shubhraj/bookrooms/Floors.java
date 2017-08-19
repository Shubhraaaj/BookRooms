package com.example.shubhraj.bookrooms;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Floors extends AppCompatActivity
{
    private Button bed1, bed2, bed3, bed4, bed5,topButton, downButton;
    private TextView floorName;
    private int floorNum=0;
    private boolean booked[][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floors);
        booked = new boolean[3][5];
        bed1 = (Button) findViewById(R.id.button_bed_1);
        bed2 = (Button) findViewById(R.id.button_bed_2);
        bed3 = (Button) findViewById(R.id.button_bed_3);
        bed4 = (Button) findViewById(R.id.button_bed_4);
        bed5 = (Button) findViewById(R.id.button_bed_5);
        floorName = (TextView) findViewById(R.id.floorName);
        bed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booked[floorNum][0] = true;
                bedColorChange(0);
            }
        });
        bed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booked[floorNum][1] = true;
                bedColorChange(1);
            }
        });
        bed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booked[floorNum][2] = true;;
                bedColorChange(2);
            }
        });
        bed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booked[floorNum][3] = true;
                bedColorChange(3);
            }
        });
        bed5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booked[floorNum][4] = true;
                bedColorChange(4);
            }
        });
        topButton = (Button) findViewById(R.id.top_button);
        downButton  = (Button) findViewById(R.id.down_button);
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementFloor();
            }
        });
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementFloor();
            }
        });
    }

    private void decrementFloor() {
        if(floorNum>=1) {
            floorNum--;
            setBedNames();
        }
        else
            Toast.makeText(this, "Reached Ground Floor", Toast.LENGTH_SHORT).show();
    }

    private void incrementFloor() {
        if(floorNum<2){
            floorNum++;
            setBedNames();
        }
        else
            Toast.makeText(this, "Reached maximum floor", Toast.LENGTH_SHORT).show();
    }

    private void setBedNames() {
        floorName.setText("Floor "+(floorNum+1));
        bed1.setText("BED " + ((floorNum * 5) + 1));
        bed2.setText("BED " + ((floorNum * 5) + 2));
        bed3.setText("BED " + ((floorNum * 5) + 3));
        bed4.setText("BED " + ((floorNum * 5) + 4));
        bed5.setText("BED " + ((floorNum * 5) + 5));
        bed1.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
        bed2.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
        bed3.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
        bed4.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
        bed5.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
        for(int i=0;i<5;i++)
        {
            if(floorNum==3)
                continue;
            if(booked[floorNum][i]==true)
            {
                bedColorChange(i);
            }
        }
    }

    public void bedColorChange(int bedNo)
    {
        if (bedNo == 0)
            bed1.setBackgroundColor(ContextCompat.getColor(this,R.color.grey));
        else if(bedNo == 1)
            bed2.setBackgroundColor(ContextCompat.getColor(this,R.color.grey));
        else if(bedNo == 2)
            bed3.setBackgroundColor(ContextCompat.getColor(this,R.color.grey));
        else if(bedNo == 3)
            bed4.setBackgroundColor(ContextCompat.getColor(this,R.color.grey));
        else if(bedNo == 4)
            bed5.setBackgroundColor(ContextCompat.getColor(this,R.color.grey));
    }
}
