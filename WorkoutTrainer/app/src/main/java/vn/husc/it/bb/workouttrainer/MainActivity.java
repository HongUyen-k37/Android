package vn.husc.it.bb.workouttrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMenu1, txtMenu2, txtMenu3, txtMenu4, txtMenu5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMenu1 = (TextView)findViewById(R.id.txtMenu1);
        txtMenu2 = (TextView)findViewById(R.id.txtMenu2);
        txtMenu3 = (TextView)findViewById(R.id.txtMenu3);
        txtMenu4 = (TextView)findViewById(R.id.txtMenu4);
        txtMenu5 = (TextView)findViewById(R.id.txtMenu5);
        txtMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExerciseTab.class);
                startActivity(intent);
            }
        });
        txtMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
                startActivity(intent);
            }
        });
        txtMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BMITab.class);
                startActivity(intent);
            }
        });
        txtMenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutUsTab.class);
                startActivity(intent);
            }
        });
        txtMenu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khởi tạo lại activity Main
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                //Kết thúc app
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
    }
}
