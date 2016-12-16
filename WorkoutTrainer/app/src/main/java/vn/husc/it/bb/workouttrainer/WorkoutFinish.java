package vn.husc.it.bb.workouttrainer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutFinish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutfinish);

        MediaPlayer music = MediaPlayer.create(WorkoutFinish.this, R.raw.finish);
        music.start();

        Button btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutFinish.this, WorkoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
