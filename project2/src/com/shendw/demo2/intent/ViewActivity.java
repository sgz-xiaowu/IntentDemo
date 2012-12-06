package com.shendw.demo2.intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        TextView tv = new TextView(this);
        tv.setText("这是ViewActivity!");
        
        setContentView(tv);
    }
}
