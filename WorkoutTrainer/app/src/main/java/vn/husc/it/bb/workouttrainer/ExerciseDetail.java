package vn.husc.it.bb.workouttrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Entities.Exercise;

public class ExerciseDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int id = getIntent().getIntExtra("idExercise", 0);
        setContentView(R.layout.activity_exercisedetail);
        final Exercise data = Exercise.getExercise(this, id);

        TextView txtNameExercise = (TextView)findViewById(R.id.txtNameExercise);
        txtNameExercise.setText(data.getName());
        ImageView imgExercise = (ImageView)findViewById(R.id.imgExercise);
        imgExercise.setImageResource(data.getImage());
        TextView txtNoteExercise = (TextView)findViewById(R.id.txtNoteExercise);
        txtNoteExercise.setText(data.getNote());
    }
}
