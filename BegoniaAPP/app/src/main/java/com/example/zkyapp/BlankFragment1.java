package com.example.zkyapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String TAG="Blank Fragment1";
    private List<Fruit> fruitList=new ArrayList<Fruit>();

    public BlankFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        initFruits();
        Log.d(TAG,"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root= inflater.inflate(R.layout.fragment_blank1, container, false);
       FruitAdapter adapter=new FruitAdapter(getActivity(),R.layout.fruit_layout,fruitList);
       ListView listView=root.findViewById(R.id.list_view);
       //listView.setFooterDividersEnabled(false);
       listView.setAdapter(adapter);
      // Bundle bd=this.getArguments();
        return root;
    }
    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.user_avatar);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.ic_menu_camera);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.ic_menu_gallery);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.ic_menu_quit);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.user_avatar);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.ic_menu_slideshow);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.user_avatar);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.ic_menu_camera);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.ic_menu_quit);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.user_avatar);
            fruitList.add(mango);
        }
    }
    @Override
   public void onStart()
    {
        super.onStart();
        Log.d(TAG,"onStart");
    }
    @Override
   public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyView");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
    }
}