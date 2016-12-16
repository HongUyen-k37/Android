package vn.husc.it.bb.workouttrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMITab extends AppCompatActivity {

    EditText edtHeight, edtWeight;
    Button btnResult;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmitab);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.logo);
//        getActionBar().setHomeButtonEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setIcon(R.drawable.back);

        edtHeight = (EditText)findViewById(R.id.edttHeight);
        edtWeight = (EditText)findViewById(R.id.edttWeight);
        btnResult = (Button)findViewById(R.id.btnResult);
        txtResult = (TextView)findViewById(R.id.txtResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strh = edtHeight.getText().toString();
                String strw = edtWeight.getText().toString();
                double bmi = 0, h = 0, w = 0;
                    try {
                        h = Double.parseDouble(strh);
                        w = Double.parseDouble(strw);
                    }catch (Exception e){
                        Toast t = Toast.makeText(BMITab.this, "Lỗi nhập vào chiều cao và cân nặng!", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    }
                    if(h==0 || w==0){
                        Toast t = Toast.makeText(BMITab.this, "Lỗi nhập vào chiều cao và cân nặng!", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    }
                    bmi = w/Math.pow(h, 2);
                    bmi=Math.round(bmi*10)/10.0;
                    if(bmi < 18.5)
                        txtResult.setText("BMI = " + String.valueOf(bmi) + "\nBạn hơi gầy!");
                    else if(bmi < 25)
                        txtResult.setText("BMI = " + String.valueOf(bmi) + "\nBạn cân đối!");
                    else if(bmi < 30)
                        txtResult.setText("BMI = " + String.valueOf(bmi) + "\nBạn thừa cân!");
                    else
                        txtResult.setText("BMI = " + String.valueOf(bmi) + "\nBạn béo phì!");

            }
        });
    }
}
