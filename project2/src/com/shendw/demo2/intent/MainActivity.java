package com.shendw.demo2.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                // 显示启动View Activity。
                /*Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);*/
                
                // 隐式启动View Activity。 PS:在同一个App下，当然可以使用隐式Intent startActivity.
                Intent intent = new Intent();
                intent.setAction("com.custom.action.view");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
