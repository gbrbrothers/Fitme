package com.gbrbrothers.fitme2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by TK on 2016-12-18.
 */

public class TrainerDetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_detail);

        Intent userSelectTrainerIntent = getIntent();
        int userSelectTrainerID = userSelectTrainerIntent.getIntExtra("TRAINER_ID", 0);
        String userSelectTrainerName = userSelectTrainerIntent.getStringExtra("TRAINER_NAME");

        TextView detailTrainerName = (TextView) findViewById(R.id.Trainer_Detail_Name);
        TextView detailTrainerLocation = (TextView) findViewById(R.id.Trainer_Detail_Location);
        TextView userSelectMonth = (TextView) findViewById(R.id.user_selected_month);
        TextView userSelectDay = (TextView) findViewById(R.id.user_selected_day);
        TextView userSelectHour= (TextView) findViewById(R.id.user_selected_hour);

        // 아래 코드 대신 트레이더 정보 페이지가 떠야함

        detailTrainerName.setText("" + userSelectTrainerID);
        detailTrainerLocation.setText(userSelectTrainerName);

        // 아래 코드는 캘린더형 선택지를 주고 선택에 따라 자동으로 바뀌게 해야함

        userSelectMonth.setText("12월");
        userSelectDay.setText("20일");
        userSelectHour.setText("8시");

    }
}
