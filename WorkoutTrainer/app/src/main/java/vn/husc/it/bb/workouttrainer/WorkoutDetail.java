package vn.husc.it.bb.workouttrainer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Entities.Exercise;

public class WorkoutDetail extends AppCompatActivity {
    private TextView tvTenBai,tvBaiTiep;
    private TextView tvTimeDown;
    private Button  btnPrev,btnNext,btnStart;
    private ProgressBar pbTime;
    private ImageView ivImage;
    private List<Exercise> lst = new ArrayList<Exercise>();
    private int Current;
    private long CurrentTime;
    private CountDownTimer countDownTimer=null;
    private boolean isPause=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutdetail);

        int id=getIntent().getIntExtra("Option",0);
        lst = Exercise.getListOfOption(this, id);

        tvTenBai = (TextView) findViewById(R.id.txtNameWorkout);
        tvBaiTiep = (TextView) findViewById(R.id.txtNextWorkout);
        tvTimeDown = (TextView) findViewById(R.id.txtTime);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextBaiTap();
            }
        });
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevBaiTap();
            }
        });
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPause) startTime();
                else pauseTime();
            }
        });
        pbTime = (ProgressBar) findViewById(R.id.pbTime);
        ivImage = (ImageView)findViewById(R.id.imgWorkout);
        Current=0;
        showBaiTap();
    }
    private void showBaiTap(){
        btnStart.setText("START");
        isPause=true;
        Exercise bt=lst.get(Current);
        if(Current+1<lst.size()) tvBaiTiep.setText("Next: "+lst.get(Current+1).getName());
        else tvBaiTiep.setText("Last one!");
        tvTenBai.setText(bt.getName());
        CurrentTime=lst.get(Current).getTime();
        tvTimeDown.setText(convertTime(bt.getTime()));
        ivImage.setImageResource(bt.getImage());
        pbTime.setProgress(0);
        if(countDownTimer!=null) countDownTimer.cancel();
    }
    private String convertTime(long time){
        String ctime="";
        ctime+=String.valueOf(time/60);
        ctime+=":";
        if(time%60==0) ctime+="00";
        else {
            if(time%60<10) ctime+="0";
            ctime+=String.valueOf(time%60);
        }
        return ctime;
    }

    private void startTime(){
        isPause=false;
        btnStart.setText("PAUSE");
        countDownTimer=new CountDownTimer((CurrentTime+1)*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimeDown.setText(convertTime(millisUntilFinished/1000-1));
                CurrentTime=millisUntilFinished/1000;
                tienTrinh();
            }
            @Override
            public void onFinish() {
                nextBaiTap();
            }
        };
        countDownTimer.start();
    }
    private void pauseTime(){
        isPause=true;
        btnStart.setText("RESUME");
        if(countDownTimer!=null) countDownTimer.cancel();
    }
    private void nextBaiTap(){
        if(Current+1>=lst.size()) {
            Intent intent = new Intent(WorkoutDetail.this, WorkoutFinish.class);
            startActivity(intent);
            return;
        }
        Current++;
        showBaiTap();
    }
    private void prevBaiTap(){
        if(Current-1<0) return;
        Current--;
        showBaiTap();
    }
    private void tienTrinh(){
        long pro= (lst.get(Current).getTime()-CurrentTime+1)*100/lst.get(Current).getTime();
        pbTime.setProgress((int) pro);
    }
}
