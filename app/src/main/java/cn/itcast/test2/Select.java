package cn.itcast.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Select extends AppCompatActivity {
    private  Button btn_return;
    private  Button btn_bianji;
    private TextView shouru_zhichu;
    private TextView money;
    private TextView type;
    private List<CostBean> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        btn_return = findViewById(R.id.btn_return);
        btn_bianji = findViewById(R.id.btn_bianji);
        shouru_zhichu=findViewById(R.id.shouru_zhichu);
        money=findViewById(R.id.money);
        type=findViewById(R.id.type);
        Intent intent=getIntent();
        final String title=intent.getStringExtra("costTile");
        final String Money=intent.getStringExtra("costMoney");
        final String Inout=intent.getStringExtra("costInOut");
        final int pos=intent.getIntExtra("position",0);
        shouru_zhichu.setText("收支类别："+Inout);
        money.setText("金额："+Money);
        type.setText("类型："+title);
        //按键监听
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select.this, home_page.class);
                startActivity(intent);
            }
        });
        btn_bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select.this, Account.class);
               // CostBean bean = mList.get(pos);
                intent.putExtra("costTile",title);
                intent.putExtra("costMoney",Money);
                intent.putExtra("costInOut",Inout);
                intent.putExtra("position",pos);
                intent.putExtra("chart",3);
                startActivity(intent);
            }
        });

    }
}
