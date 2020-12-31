package cn.itcast.test2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = findViewById(R.id.btn_start);
        //按键监听
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss//获取当前时间
                Date date1 = new Date(System.currentTimeMillis());
                SharedPreferences.Editor editor=getSharedPreferences("time",MODE_PRIVATE).edit();
                SharedPreferences pref=getSharedPreferences("cishu",MODE_PRIVATE);
                int cishu=pref.getInt("cishu",0);
                cishu++;
                SharedPreferences.Editor editor2=getSharedPreferences("cishu",MODE_PRIVATE).edit();
                editor2.putInt("cishu",cishu);
                editor.putString("time",simpleDateFormat.format(date1));
                editor.apply();
                editor2.apply();
                Intent intent = new Intent(MainActivity.this, home_page.class);
                startActivity(intent);
            }
        });
    }
}
