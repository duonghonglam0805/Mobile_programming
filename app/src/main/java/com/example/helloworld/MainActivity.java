package com.example.helloworld;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //  Countimer
//    private int i = 15;
//    private TextView tvD ;

    // Cuộc đua kỳ thú
    TextView score;
    ImageButton imgbntPlay;
    CheckBox cbShin, cbRabbit, cbTurtle;
    SeekBar skShin, skRabbit, skTurtle;
    int totalScore = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // Hàm bắt buộc trong Android để chạy chương trình
        super.onCreate(savedInstanceState);
        //Cuộc đua kỳ thú
        setContentView(R.layout.running);
        Anhxa();

        // set không cho tương tác với seekbar
        skShin.setEnabled(false);
        skRabbit.setEnabled(false);
        skTurtle.setEnabled(false);

        //Tính điểm
        score.setText(totalScore + "");

        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 3;
                Random random = new Random();
                int shin = random.nextInt(number);
                int rabbit = random.nextInt(number);
                int turtle = random.nextInt(number);

                // Check who is  Winner
                if(skShin.getProgress() >= skShin.getMax()){
                    this.cancel();
                    imgbntPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Shin is winner", Toast.LENGTH_SHORT).show();
                    // Kiểm tra đặt cược
                    if(cbShin.isChecked()){
                        totalScore += 10;
                        Toast.makeText(MainActivity.this, "You win, +10 score to you", Toast.LENGTH_SHORT).show();
                    }else {
                        totalScore -= 10;
                        Toast.makeText(MainActivity.this, "You lost, -10 score", Toast.LENGTH_SHORT).show();
                    }
                    score.setText(totalScore + "");
                    EnableCheckBox();
                }
                if(skRabbit.getProgress() >= skRabbit.getMax()){
                    this.cancel();
                    imgbntPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Rabbit is winner", Toast.LENGTH_SHORT).show();
                    if(cbRabbit.isChecked()){
                        totalScore += 10;
                        Toast.makeText(MainActivity.this, "You win, +10 score to you", Toast.LENGTH_SHORT).show();
                    }else {
                        totalScore -= 10;
                        Toast.makeText(MainActivity.this, "You lost, -10 score", Toast.LENGTH_SHORT).show();
                    }
                    score.setText(totalScore + "");
                    EnableCheckBox();
                }
                if(skTurtle.getProgress() >= skTurtle.getMax()){
                    this.cancel();
                    imgbntPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Turtle is winner", Toast.LENGTH_SHORT).show();
                    if(cbTurtle.isChecked()){
                        totalScore += 10;
                        Toast.makeText(MainActivity.this, "You win, +10 score to you", Toast.LENGTH_SHORT).show();
                    }else {
                        totalScore -= 10;
                        Toast.makeText(MainActivity.this, "You lost, -10 score", Toast.LENGTH_SHORT).show();
                    }
                    score.setText(totalScore + "");
                    EnableCheckBox();
                }
                skShin.setProgress(skShin.getProgress() + shin);
                skRabbit.setProgress(skRabbit.getProgress() + rabbit);
                skTurtle.setProgress(skTurtle.getProgress() + turtle);
            }

            @Override
            public void onFinish() {

            }
        };
        imgbntPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalScore > 0){
                    if(cbShin.isChecked() || cbRabbit.isChecked() || cbTurtle.isChecked()){
                        skShin.setProgress(0);
                        skRabbit.setProgress(0);
                        skTurtle.setProgress(0);
                        imgbntPlay.setVisibility(View.INVISIBLE);
                        countDownTimer.start();
                        DisableCheckBox();
                    }else {
                        Toast.makeText(MainActivity.this, "Please choose the winner", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                }

            }
        });
        // CHECKBOX
        cbShin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // bỏ check 2 cai con lại
                    cbRabbit.setChecked(false);
                    cbTurtle.setChecked(false);
                }
            }
        });

        cbRabbit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbShin.setChecked(false);
                    cbTurtle.setChecked(false);
                }
            }
        });

        cbTurtle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cbShin.setChecked(false);
                    cbRabbit.setChecked(false);
                }
            }
        });
    }

    // Bắt lỗi checkbox khi đang chơi game
    private void EnableCheckBox(){
        cbShin.setEnabled(true);
        cbRabbit.setEnabled(true);
        cbTurtle.setEnabled(true);
    }
    private void DisableCheckBox(){
        cbShin.setEnabled(false);
        cbRabbit.setEnabled(false);
        cbTurtle.setEnabled(false);
    }

    private void Anhxa(){
        score           = (TextView) findViewById(R.id.score);
        imgbntPlay      = (ImageButton) findViewById(R.id.playButton);
        cbShin          = (CheckBox) findViewById(R.id.checkBoxShin);
        cbRabbit        = (CheckBox) findViewById(R.id.checkBoxrabbit);
        cbTurtle        = (CheckBox) findViewById(R.id.checkBoxTurtle);
        skShin          = (SeekBar) findViewById(R.id.seekBarShin);
        skRabbit        = (SeekBar) findViewById(R.id.seekBarRabbit);
        skTurtle        = (SeekBar) findViewById(R.id.seekBarTurtle);
    }
}


    // countdowntimer
//        setContentView(R.layout.countdowntime);
//        tvD = (TextView) findViewById(R.id.textView);

//    }
//}
// Countdowntimer
//        CountDownTimer dem = new CountDownTimer(15000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                tvD.setText(i + "");
//                i--;
//            }
//
//            @Override
//            public void onFinish() {
//                tvD.setText("Done!");
//            }
//        };
//        dem.start();
//    }
//}

    // bài tập cộng 2 số
// B1: KHai báo biến và button
//    private EditText editText_Number1;
//    private  EditText editText_Number2 ;
//    private Button btnAdd ;
// B2: Ánh xạ/ tham chiếu sang file activity_main
//        this.editText_Number1 = (EditText) this.findViewById(R.id.editTextNumber1);
//        this.editText_Number2 = (EditText) this.findViewById(R.id.editTextNumber2);
//        this.btnAdd = (Button) this.findViewById(R.id.buttonAdd);
//        this.btnAdd.setOnClickListener(new View.OnClickListener() { // Tạo sự kiện onClick
//            @Override
//            public void onClick(View view) {
////              add2Number(); // call add2number function
//                double a = Double.parseDouble(editText_Number1.getText().toString()); // Phải chuyển editText_Number1 thành chuổi vì nó chưa hiểu đó là chuyển để chuyển sang kiểu double
//                double b = Double.parseDouble(editText_Number2.getText().toString());
//                double result = a+b;
//                Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_LONG).show();
//            }
//
//        });
// Viết hàm add2number
//    private void add2Number() {
//        String str1 = this.editText_Number1.getText().toString();
//        String str2 = this.editText_Number2.getText().toString();
//        try {
//            double value1 = Double.parseDouble(str1);
//            double value2 = Double.parseDouble(str2);
//            double result = value1 + value2;
//            Toast.makeText(this, "Result: " + result, Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
//        }
//
//    }
//}