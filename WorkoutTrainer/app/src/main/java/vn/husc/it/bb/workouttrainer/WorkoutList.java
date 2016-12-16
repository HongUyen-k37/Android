package vn.husc.it.bb.workouttrainer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Entities.*;

public class WorkoutList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlist);
        ListView lvWorkout = (ListView) findViewById(R.id.lvWorkout);
        final int id=getIntent().getIntExtra("Option",0);
        final List<Exercise> data = Exercise.getListOfOption(this,id);
        ExerciseAdapter adapter = new ExerciseAdapter(
                this,
                R.layout.list_items_workout,
                data);
        lvWorkout.setAdapter(adapter);

        Button btnGo = (Button)findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutList.this, WorkoutDetail.class);
                intent.putExtra("Option",id);
                startActivity(intent);
            }
        });
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
            View view = getLayoutInflater().inflate(R.layout.list_items_workout, null);
            ImageView imgItem = (ImageView) view.findViewById(R.id.imgItem);
            TextView txtName = (TextView) view.findViewById(R.id.txtNameItem);
            txtName.setText(data.get(position).getName());
            imgItem.setImageResource(data.get(position).getImage());
            final ImageView btnStar = (ImageView) view.findViewById(R.id.btnStar);
            btnStar.setTag(R.drawable.star);
            btnStar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Integer s = (Integer)btnStar.getTag();
                    if(s == R.drawable.star){
                        btnStar.setImageResource(R.drawable.star_clicked);
                        btnStar.setTag(R.drawable.star_clicked);
                    }
                    else {
                        btnStar.setImageResource(R.drawable.star);
                        btnStar.setTag(R.drawable.star);
                    }
                }
            });
            return view;
        }
    }
}
