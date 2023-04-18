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

import com.example.smartwallpapers.adapter.CosplayAdapter;
import com.example.smartwallpapers.db.DatabaseHelper;
import com.example.smartwallpapers.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PopularFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PopularFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context context;

    private List<String> imageUrlList;
    private RecyclerView recycler_view_dark;
    private CosplayAdapter darkwallpaperAdapter;

    public PopularFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DarkwallpaperFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PopularFragment newInstance(String param1, String param2) {
        PopularFragment fragment = new PopularFragment();
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
        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        recycler_view_dark = (RecyclerView) view.findViewById(R.id.recycler_view_dark);

        GridLayoutManager layoutManager = new GridLayoutManager(requireActivity(),2,RecyclerView.VERTICAL,false);
        recycler_view_dark.setLayoutManager(layoutManager);
        recycler_view_dark.setPadding(0,0,15,0);
        initData();
        darkwallpaperAdapter = new CosplayAdapter(imageUrlList,context);
        recycler_view_dark.setAdapter(darkwallpaperAdapter);
        return view;
    }


    private void initData() {
        imageUrlList = new ArrayList<>();
        DatabaseHelper dbHelper  = new DatabaseHelper(requireContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT url FROM picture WHERE them='Popular'", null);
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