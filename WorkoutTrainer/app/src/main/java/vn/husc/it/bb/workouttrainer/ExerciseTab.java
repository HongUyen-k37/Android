package vn.husc.it.bb.workouttrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Entities.Category;
import Entities.Exercise;

public class ExerciseTab extends AppCompatActivity {

    TextView[] txtCategory=new TextView[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercisetab);

        txtCategory[0] = (TextView)findViewById(R.id.txtCategory1);
        txtCategory[1] = (TextView)findViewById(R.id.txtCategory2);
        txtCategory[2] = (TextView)findViewById(R.id.txtCategory3);
        txtCategory[3] = (TextView)findViewById(R.id.txtCategory4);
        txtCategory[4] = (TextView)findViewById(R.id.txtCategory5);
        txtCategory[5] = (TextView)findViewById(R.id.txtCategory6);
        txtCategory[6] = (TextView)findViewById(R.id.txtCategory7);
        for(int i=0;i<=6;i++){
            final int id=i+1;
            txtCategory[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExerciseTab.this, ExerciseList.class);
                intent.putExtra("Category",id);
                startActivity(intent);
            }
        });
        }
    }
}
