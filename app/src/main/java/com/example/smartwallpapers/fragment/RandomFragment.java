package com.example.smartwallpapers.fragment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartwallpapers.R;
import com.example.smartwallpapers.adapter.CosplayAdapter;
import com.example.smartwallpapers.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RandomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RandomFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Context context;
    private RecyclerView recycler_random;
    private List<String> imageUrlList;
    private CosplayAdapter cosplayAdapter;

    public RandomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterFragment.
     */
    public static RandomFragment newInstance(String param1, String param2) {
        RandomFragment fragment = new RandomFragment();
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
        View view = inflater.inflate(R.layout.fragment_random, container, false);
        recycler_random = (RecyclerView) view.findViewById(R.id.recycler_random);
        GridLayoutManager layoutManager = new GridLayoutManager(requireActivity(),2,RecyclerView.VERTICAL,false);
        recycler_random.setLayoutManager(layoutManager);
        recycler_random.setPadding(0,0,15,0);
        initData();
        cosplayAdapter = new CosplayAdapter(imageUrlList, context);
        recycler_random.setAdapter(cosplayAdapter);
        return view;
    }

    private void initData() {
        imageUrlList = new ArrayList<>();
        DatabaseHelper dbHelper  = new DatabaseHelper(requireContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT url FROM picture WHERE them='Random'", null);
        if (cursor.moveToFirst()) {
            do {
                String url = cursor.getString(0);
                imageUrlList.add(url);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

    }
}