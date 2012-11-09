/**
 * Copyright 1.0 for individual.
 * 
 * 2012.11
 */
package com.shendw.demo.intent;

import android.os.Bundle;
import android.view.Menu;

/**
 * This demo is test intent.
 * 
 * <p {@link Action test} * {@link Category test} * {@link Data test}/>
 */
public class MainActivity extends BaseActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
