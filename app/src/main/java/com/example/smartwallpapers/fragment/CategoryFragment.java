package com.example.smartwallpapers.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.smartwallpapers.R;
import com.example.smartwallpapers.activity.Image2Activity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView iv_1;
    private Context context;
    private ImageView iv_2;
    private ImageView iv_3;
    private ImageView iv_4;
    private ImageView iv_5;

    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SceneryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
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
        context = getContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        iv_1 = (ImageView) view.findViewById(R.id.iv_1);
        iv_2 = (ImageView) view.findViewById(R.id.iv_2);
        iv_3 = (ImageView) view.findViewById(R.id.iv_3);
        iv_4 = (ImageView) view.findViewById(R.id.iv_4);
        iv_5 = (ImageView) view.findViewById(R.id.iv_5);


        Glide.with(context).load("https://w.wallhaven.cc/full/57/wallhaven-57wqw5.jpg").into(iv_1);
        Glide.with(context).load("https://w.wallhaven.cc/full/rr/wallhaven-rr7xjq.jpg").into(iv_2);
        Glide.with(context).load("https://w.wallhaven.cc/full/0q/wallhaven-0qqyr5.jpg").into(iv_3);
        Glide.with(context).load("https://w.wallhaven.cc/full/pk/wallhaven-pkmqy9.jpg").into(iv_4);
        Glide.with(context).load("https://w.wallhaven.cc/full/3k/wallhaven-3kk6j9.jpg").into(iv_5);


        iv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        iv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        iv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        iv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        iv_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);}
        });
        return view;
    }

    private void onButtonClick(View view) {
        Intent intent = new Intent(context, Image2Activity.class);
        switch (view.getId()){
            case R.id.iv_1:
                intent.putExtra("them","Abstarct");
                break;
            case R.id.iv_2:
                intent.putExtra("them","Anime");
                break;
            case R.id.iv_3:
                intent.putExtra("them","Animal");
                break;
            case R.id.iv_4:
                intent.putExtra("them","Auto");
                break;
            case R.id.iv_5:
                intent.putExtra("them","Comics");
                break;

        }
        startActivity(intent);
    }
}