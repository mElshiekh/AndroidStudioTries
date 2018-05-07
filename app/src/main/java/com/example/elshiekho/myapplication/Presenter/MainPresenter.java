package com.example.elshiekho.myapplication.Presenter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.Log;

import com.example.elshiekho.myapplication.DynamicFragOne;
import com.example.elshiekho.myapplication.DynamicFragTwo;
import com.example.elshiekho.myapplication.R;

/**
 * Created by Elshiekho on 5/6/2018.
 */

public class MainPresenter {
    public void changeFrag(Context context){
        Fragment frag = ((Activity)context).getFragmentManager().findFragmentByTag("dynFrag");
        Log.i("changefrag","main");
        if(frag instanceof DynamicFragOne) {
            Log.i("changefrag","if");
            DynamicFragTwo dynFrag = new DynamicFragTwo();
            FragmentManager mgr = ((Activity)context).getFragmentManager();
            FragmentTransaction trns = mgr.beginTransaction();
            trns.replace(R.id.dynFrag, dynFrag, "dynFrag");
            trns.commit();
        }
        else{
            Log.i("changefrag","else");
            DynamicFragOne dynFrag = new DynamicFragOne();
            FragmentManager mgr = ((Activity)context).getFragmentManager();
            FragmentTransaction trns = mgr.beginTransaction();
            trns.replace(R.id.dynFrag,dynFrag,"dynFrag");
            trns.commit();
        }
    }
    public void setMainFrag(Context context){
        DynamicFragOne dynFrag = new DynamicFragOne();
        FragmentManager mgr = ((Activity)context).getFragmentManager();
        FragmentTransaction trns = mgr.beginTransaction();
        trns.add(R.id.dynFrag,dynFrag,"dynFrag");
        trns.commit();
    }
}
