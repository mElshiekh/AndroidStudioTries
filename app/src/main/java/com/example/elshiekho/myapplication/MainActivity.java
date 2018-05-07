package com.example.elshiekho.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.elshiekho.myapplication.Interfaces.DynFragStaticFragInterface;
import com.example.elshiekho.myapplication.Presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements DynFragStaticFragInterface, staticFrag.OnFragmentInteractionListener,DynamicFragOne.OnFragmentInteractionListener, DynamicFragTwo.OnFragmentInteractionListener{

    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        staticFrag fragment = (staticFrag) getFragmentManager().findFragmentById(R.id.stFrag);
        Log.i("fragXXX",fragment.isAdded()+"");
        presenter = new MainPresenter();
        presenter.setMainFrag(this);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void changeFrag() {
        presenter.changeFrag(this);
    }

    @Override
    public void changeText() {

    }
}
