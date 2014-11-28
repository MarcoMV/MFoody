package com.myfoody.contador.myfoody;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by CONTADOR on 26/11/2014.
 */
public class ProfileFragment extends Fragment{
    public ProfileFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.profile,container,false);
        return rootView;
    }
}
