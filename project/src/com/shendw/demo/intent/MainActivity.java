/**
 * Copyright 1.0 for individual.
 * 
 * 2012.11
 */
package com.shendw.demo.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This demo is test intent.
 * 
 * <p {@link Action test} * {@link Category test} * {@link Data test}/>
 */
public class MainActivity extends BaseActivity implements OnClickListener
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn01 = (Button) findViewById(R.id.button1);
        Button btn02 = (Button) findViewById(R.id.button2);
        Button btn03 = (Button) findViewById(R.id.button3);
        Button btn04 = (Button) findViewById(R.id.button4);
        
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        
    }
    
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
        case R.id.button1:
            onBtn01Click();
            break;
            
        case R.id.button2:
            onBtn02Click();
            
            break;
            
        case R.id.button3:
            onBtn03Click();
            
            break;
            
        case R.id.button4:
            onBtn04Click();
            break;
            
        default:
            break;
        }
    }
    
    /*Explicit intents.*/
    
    private void onBtn01Click()
    {
        Intent intent = new Intent(IntentConstant.ACTION_TEST01/*this, Activity01.class*/);  // Comment component, Implicit done.
//        intent.setAction(IntentConstant.ACTION_TEST);
        startActivity(intent);
    }

    private void onBtn02Click()
    {
        Intent intent = new Intent(IntentConstant.ACTION_TEST02/*this, Activity02.class*/);  // Comment component, Implicit done.
//        intent.setAction(IntentConstant.ACTION_TEST);
        startActivity(intent);
    }

    private void onBtn03Click()
    {
        Intent intent = new Intent(IntentConstant.ACTION_TEST03/*this, Activity03.class*/);  // Comment component, Implicit done.
//        intent.setAction(IntentConstant.ACTION_TEST);
        intent.addCategory(IntentConstant.PACKAGE_CATEGORY_SAMPLE);
        startActivity(intent);
    }

    private void onBtn04Click()
    {
        Intent intent = new Intent(IntentConstant.ACTION_TEST04/*this, Activity04.class*/);  // Comment component, Implicit done.
//        intent.setAction(IntentConstant.ACTION_TEST);
        intent.addCategory(IntentConstant.PACKAGE_CATEGORY_SAMPLE);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
