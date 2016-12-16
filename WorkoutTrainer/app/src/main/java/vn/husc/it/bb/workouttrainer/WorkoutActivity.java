package vn.husc.it.bb.workouttrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WorkoutActivity extends AppCompatActivity {

    ImageView[] imgOption = new ImageView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        imgOption[0] = (ImageView)findViewById(R.id.imgOption1);
        imgOption[1] = (ImageView)findViewById(R.id.imgOption2);
        imgOption[2] = (ImageView)findViewById(R.id.imgOption3);
        imgOption[3] = (ImageView)findViewById(R.id.imgOption4);

        for(int i=0;i<=3;i++){
            final int id=i+1;
            imgOption[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WorkoutActivity.this, WorkoutList.class);
                    intent.putExtra("Option",id);
                    startActivity(intent);
                }
            });
        }

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(WorkoutActivity.this, MainActivity.class);
                    startActivity(intent);
            }
        });
    }
}
