package com.ttth.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttth.adapter.ListImageAdapter;
import com.ttth.model.MyImage;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 05/01/17.
 */

public class ListImageFragment extends Fragment {
    private static final String EXTRA_KEY_LIST = "extra_key_list";
    private RecyclerView rvList;
    private ArrayList<MyImage> arrImages;
    private ListImageAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
    }

    private void initData(Bundle instate) {
        if (instate == null)return;
        arrImages = instate.getParcelableArrayList(EXTRA_KEY_LIST);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(EXTRA_KEY_LIST,arrImages);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvList = (RecyclerView) view.findViewById(R.id.rvList);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        getData();
        rvList.setLayoutManager(layoutManager);
        adapter = new ListImageAdapter(arrImages, getActivity());
        rvList.setAdapter(adapter);

    }

    private void getData(){
        arrImages = new ArrayList<>();
        arrImages.add(new MyImage(R.drawable.ic_earth,"h"));
        arrImages.add(new MyImage(R.drawable.ic_earth1,"h1"));
        arrImages.add(new MyImage(R.drawable.ic_earth2,"h2"));
        arrImages.add(new MyImage(R.drawable.ic_earth3,"h3"));
        arrImages.add(new MyImage(R.drawable.ic_earth4,"h4"));
        arrImages.add(new MyImage(R.drawable.ic_earth5,"h5"));
        arrImages.add(new MyImage(R.drawable.ic_earth6,"h6"));
        arrImages.add(new MyImage(R.drawable.ic_earth7,"h7"));
        arrImages.add(new MyImage(R.drawable.ic_earth8,"h8"));
        arrImages.add(new MyImage(R.drawable.ic_earth9,"h9"));
    }
}
