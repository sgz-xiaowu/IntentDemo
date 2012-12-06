package com.shendw.demo.intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.R.integer;

public class ToArrayList
{
    String[] mStringArrays;
    integer[] mIntArrays;
    
    public static ArrayList<String> toArrayList(String[] arrays)
    {
        List<String> arrayList = Arrays.asList(arrays);
        
        return new ArrayList<String>(arrayList);
    }
    
    public static ArrayList<integer> toArrayList(integer[] arrays)
    {
        List<integer> arrayList = Arrays.asList(arrays);
        
        return new ArrayList<integer>(arrayList);
    }
}
