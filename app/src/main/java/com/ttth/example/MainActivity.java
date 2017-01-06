package com.ttth.example;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Fragment fragmentCurrent = getSupportFragmentManager().findFragmentById(R.id.flFragmnet);
        if (fragmentCurrent == null){
            addFragment(new ListImageFragment(), R.id.flFragmnet);
        }
    }
    public void addFragment(Fragment fragment,int fragmentId){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(fragmentId, fragment);
        transaction.commit();
    }
    public void replaceFragment(Fragment fragment,int fragmentId){
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(fragmentId, fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }
}
