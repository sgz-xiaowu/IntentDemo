package com.shendw.demo.intent;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AppPackageInfo extends BaseActivity
{
    public static final String TAG = "AppPackageInfo";
    PackageManager PM = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        TextView tv = new TextView(this);
        tv.setText("这是AppPackageInfo!");
        
        setContentView(tv);
        
        PM = fetchAppPackageManager();
//        fetchAppPackageInfo();
//        fetchApplicationInfo();
        fetchPackageInfo();
        queryAppActivities();
    }
    
    public PackageManager fetchAppPackageManager()
    {
        return this.getPackageManager();
    }
    
    public void fetchAppPackageInfo()
    {
        if (null != PM)
        {
            List<PackageInfo> packageInfos = PM.getInstalledPackages(PackageManager.GET_META_DATA);
            Log.i(TAG, "Installed Packages's size == " + packageInfos.size());
            
            String tag_packageInfo = "packageInfo";
            int i = 0;
            for (PackageInfo packageInfo : packageInfos)
            {
                if (null == packageInfo)
                {
                    return;
                }
                Log.d(tag_packageInfo, "tag_packageInfo[" + i++ + "]: info check...");
                String packageName = packageInfo.packageName;
                Log.i(tag_packageInfo, "packageName = " + packageName);
                String sharedUserId = packageInfo.sharedUserId;
                Log.i(tag_packageInfo, "sharedUserId = " + sharedUserId);
                
                ActivityInfo[] activities = packageInfo.activities;
                
                Log.i(tag_packageInfo, "activities = " + activities);
                if (null != activities)
                {
                    String tag_activityInfo = "activityInfo";
                    int a = 0;
                    for (ActivityInfo activityInfo : activities)
                    {
                        if (null == activityInfo)
                        {
                            return;
                        }
                        Log.d(tag_activityInfo, "tag_activityInfo[" + a++ + "]: info check...");
                        Log.i(tag_activityInfo, "targetActivity = " + activityInfo.targetActivity);
                        Log.i(tag_activityInfo, "nameActivity = " + activityInfo.name);
                    }
                }
                
                ActivityInfo[] receivers = packageInfo.receivers;
                Log.i(tag_packageInfo, "receivers = " + receivers);
                
                if (null != receivers)
                {
                    String tag_activityInfo2 = "receiverInfo";
                    int r = 0;
                    for (ActivityInfo activityInfo : receivers)
                    {
                        if (null == activityInfo)
                        {
                            return;
                        }
                        Log.d(tag_activityInfo2, "tag_activityInfo2[" + r++ + "]: info check...");
                        Log.i(tag_activityInfo2, "targetActivity = " + activityInfo.targetActivity);
                        Log.i(tag_activityInfo2, "nameActivity = " + activityInfo.name);
                    }
                }
                
                ServiceInfo[] services = packageInfo.services;
                Log.i(tag_packageInfo, "services = " + services);
                
                if (null != services)
                {
                    String tag_serviceInfo = "serviceInfo";
                    int s = 0;
                    for (ServiceInfo serviceInfo : services)
                    {
                        if (null == serviceInfo)
                        {
                            return;
                        }
                        Log.d(tag_serviceInfo, "tag_serviceInfo[" + s++ + "]: info check...");
                        Log.i(tag_serviceInfo, "targetActivity = " + serviceInfo.name);
                    }
                }
                
                Signature[] signatures = packageInfo.signatures;
                Log.i(tag_packageInfo, "signatures = " + signatures);
                
                if (null != signatures)
                {
                    String tag_signature = "signature";
                    int sign = 0;
                    for (Signature signature : signatures)
                    {
                        if (null == signature)
                        {
                            return;
                        }
                        Log.d(tag_signature, "tag_signature[" + sign++ + "]: info check...");
                        Log.i(tag_signature, "signature = " + signature.toString());
                    }
                }
            }
            
        }
    }
    
    public void fetchApplicationInfo()
    {
        List<ApplicationInfo> applicationInfos = PM.getInstalledApplications(PackageManager.GET_META_DATA);
        Log.i(TAG, "Installed Application's size == " + applicationInfos.size());
        
        if (null != applicationInfos)
        {
            String tag_applicationInfo = "applicationInfo";
            int i = 0;
            for (ApplicationInfo applicationInfo : applicationInfos)
            {
                if (null == applicationInfo)
                {
                    return;
                }
                Log.d(tag_applicationInfo, "tag_applicationInfo[" + i++ + "]: info check...");
                
                int uid = applicationInfo.uid;
                String itemName = applicationInfo.name;
                String className = applicationInfo.className;
                String packageName = applicationInfo.packageName;
                String dataDir = applicationInfo.dataDir;
                
                Log.i(tag_applicationInfo, "uid : " + uid);
                Log.i(tag_applicationInfo, "itemName : " + itemName);
                Log.i(tag_applicationInfo, "className : " + className);
                Log.i(tag_applicationInfo, "packageName : " + packageName);
                Log.i(tag_applicationInfo, "dataDir : " + dataDir);
            }
        }
        
    }
    
    public void fetchPackageInfo()
    {
        try
        {
            PackageInfo packageInfo = PM.getPackageInfo(this.getPackageName(), PackageManager.GET_ACTIVITIES);
            
            if (null == packageInfo)
            {
                return;
            }
            String tag_packageInfo = "packageInfo";
            Log.d(tag_packageInfo, "tag_packageInfo[" + 0 + "]: info check...");
            String packageName = packageInfo.packageName;
            Log.i(tag_packageInfo, "packageName = " + packageName);
            String sharedUserId = packageInfo.sharedUserId;
            Log.i(tag_packageInfo, "sharedUserId = " + sharedUserId);
            
        
        }
        catch (NameNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void queryAppActivities()
    {
        Intent intent = new Intent();
        intent.setClassName(this.getPackageName(), "com.shendw.demo.intent.Activity01");
        List<ResolveInfo> activities = PM.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        Log.i(TAG, "queryAppActivities' size == " + activities.size());
        
        String tag_action = "activity_action";
        String tag_category = "activity_category";
        for (ResolveInfo resolveInfo : activities)
        {
            if (null == resolveInfo)
            {
                return;
            }
            
            String resolvePackageName = resolveInfo.resolvePackageName;
            String itemName = resolveInfo.activityInfo.name;
            Log.i(TAG, "name= " + itemName);
            /*int action_counts = resolveInfo.filter.countActions();  // filter == null;
            for (int i = 0; i < action_counts; i++)
            {
                Log.i(tag_action, "action = " + resolveInfo.filter.getAction(i));
                
            }
            int category_counts = resolveInfo.filter.countActions();
            for (int j = 0; j < category_counts; j++)
            {
                Log.i(tag_action, "category = " + resolveInfo.filter.getCategory(j));
                
            }*/
            Log.i(TAG, "resolvePackageName= " + resolvePackageName);
        }
    }
}
