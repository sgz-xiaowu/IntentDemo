/**
 * Copyright 1.0 for individual.
 * 
 * 2012.11
 */
package com.shendw.demo.intent;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/**
 * This activity is a common class. 
 * Every activity in this application should extend the base class to perform same behaviors.
 * 
 * @author Shen Dawei
 * 
 * @date 2012.11.09
 */
/**
 * @author Administrator
 *
 */
public class BaseActivity extends Activity
{
    private Activity m_TopActivity = null;
    
    private boolean m_bTopActivity = false;
    
    /*
     * @unused.
     */
    /*private*/ Service mService;
    
    /**
     * The receiver should be like global receiver,and use it carefully.
     */
    private BroadcastReceiver mReceiver;
    
    // The animation resource id for activity transform.
    // It should come from implementing animation class.
    static final int m_animationEntry = 0;
    static final int m_animationExit  = 0;
    
    /**
     * Set whether it is top activity.
     * 
     * @param isTop
     */
    public void setIsTopActivity(boolean isTop)
    {
        this.m_bTopActivity = isTop;
    }
    
    /**
     * Get whether it is top activity.
     * 
     * @return isTop
     */
    public boolean isTopActivity()
    {
        return this.m_bTopActivity;
    }
    
    /**
     * Get the top activity.
     * 
     * @return Top-activity
     */
    public Activity getTopActivity()
    {
        return (null == this.m_TopActivity) ? null : this.m_TopActivity;
    }
    
    /**
     * Register receiver to receiver some broadcast.
     */
    public void registerReceiver()
    {
        if (null != mReceiver)
        {
            this.registerReceiver(mReceiver, new IntentFilter());
        }
    }
    
    /**
     * Unregister the receiver.
     */
    public void unregisterReceiver()
    {
        if (null != mReceiver)
        {
            this.unregisterReceiver(mReceiver);
        }
    }
    
    /**
     * Called when the activity is created at first.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onResume()
     * 
     * We generally should register receiver or listener on this moment to promote performance.
     * @see {onPause}
     */
    @Override
    protected void onResume()
    {
        super.onResume();
    }
    
    
    /* (non-Javadoc)
     * @see android.app.Activity#onPause()
     * 
     * We generally should unregister the receiver or listener on this moment to promote performance
     * Or avoid exception.
     */
    @Override
    protected void onPause()
    {
        super.onPause();
    }
    
    /**
     * Called when this activity is destroyed.
     */
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
    
    /**
     * Do something when start a new activity.
     * 
     * Generally we add some certain animation for activity entry & exit.
     */
    @Override
    public void startActivity(Intent intent)
    {
        super.startActivity(intent);
        
        overridePendingTransition(m_animationEntry, m_animationExit);
    }
}
