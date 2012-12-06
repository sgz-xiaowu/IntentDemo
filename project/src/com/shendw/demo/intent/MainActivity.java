/**
 * Copyright 1.0 for individual.
 * 
 * 2012.11
 */
package com.shendw.demo.intent;

import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    private String[] mFileLists;

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
        // 进程间、进程内都可以应用intent隐式跳转和显示跳转。依赖于我们是否知晓Activity or Component Name。
//        Intent intent = new Intent(IntentConstant.ACTION_TEST01/*this, Activity01.class*/);  // Comment component, Implicit done.
        Intent intent = new Intent(Intent.ACTION_MAIN/*this, Activity01.class*/);  // Comment component, Implicit done.
        intent.addCategory(Intent.CATEGORY_LAUNCHER);         //进程间：Intent2Demo.MainActivity action=Main. category=launcher&default
                                                              //进程内：IntentDemo.Activity01 action=Main. category=default.
                                                              //addCategory(launcher)后，可以启动Intent2Demo.MainActivity，不能启动IntentDemo.Activity01
        //        intent.setAction(IntentConstant.ACTION_TEST);
        startActivity(intent);
        
        // Test file list order.
        testFileListOrder();
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
//        intent.addCategory(IntentConstant.PACKAGE_CATEGORY_SAMPLE);
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
    

    private void testFileListOrder()
    {
//        String linuxSysPreinstallNotifyPath = "/system/media/audio/notifications";
        String linuxSysPreinstallNotifyPath = "/system/app";
//      File sourceDir = new File(winPath);
      File sourceDir = new File(linuxSysPreinstallNotifyPath);
      
      if (sourceDir.exists())
      {
          if (sourceDir.isDirectory())
          {
              mFileLists = sourceDir.list();
          }
      }
      
      if (null != mFileLists)
      {
          int count = 0;
          System.out.println("Before sort:");
          for (String childName : mFileLists)
          {
              System.out.println("Find file " + count++ + " : " + childName);
          }
          
            // sort.
          sortByFileName();
          
          System.out.println("After sort:");
          count = 0;
          for (String childName : mFileLists)
          {
              System.out.println("Find file " + count++ + " : " + childName);
          }
      }
    }

    private void sortByFileName()
    {
        ArrayList<String> mList = ToArrayList.toArrayList(mFileLists);
        Collections.sort(mList, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                if (null == o1 && null != o2)
                {
                    return -1;
                }
                if (null != o1 && null == o2)
                {
                    return 1;
                }
                if (null == o1 && null == o2)
                {
                    return 0;
                }
                return Collator.getInstance().compare(o1, o2);
            }
        });
        
        mFileLists = mList.toArray(new String[mList.size()]);
    }

    
}
