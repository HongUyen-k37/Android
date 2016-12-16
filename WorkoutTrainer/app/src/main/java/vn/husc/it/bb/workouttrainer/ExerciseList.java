package vn.husc.it.bb.workouttrainer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Entities.*;

public class ExerciseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerciselist);
        ListView lvExercise = (ListView) findViewById(R.id.lvExercise);
        int id=getIntent().getIntExtra("Category",0);
        final List<Exercise> data = Exercise.getList(this,id);
        ExerciseAdapter adapter = new ExerciseAdapter(
                this,
                R.layout.list_items_exercise,
                data);
        lvExercise.setAdapter(adapter);
    }

    class ExerciseAdapter extends ArrayAdapter<Exercise>{
        List<Exercise> data;
        public ExerciseAdapter(Context context, int resource, List<Exercise> object) {
            super(context, resource, object);
            data=object;
        }

        @NonNull
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.list_items_exercise, null);
            ImageView imgItem = (ImageView) view.findViewById(R.id.imgItemExe);
            TextView txtName = (TextView) view.findViewById(R.id.txtNameItemExe);
            txtName.setText(data.get(position).getName());
            imgItem.setImageResource(data.get(position).getImage());
            ImageView btnDetail = (ImageView) view.findViewById(R.id.btnDetail);
            btnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ExerciseList.this, ExerciseDetail.class);
                    intent.putExtra("idExercise", data.get(position).getIdExercise());
                    startActivity(intent);
                }
            });
            return view;
        }
    }
}
