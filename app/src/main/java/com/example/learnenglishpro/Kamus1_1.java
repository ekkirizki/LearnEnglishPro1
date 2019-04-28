package com.example.learnenglishpro;


import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learnenglishpro.adapter.SearchAdapter;
import com.example.learnenglishpro.data.helper.KamusHelper;
import com.example.learnenglishpro.data.model.KamusModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Kamus1_1 extends Fragment implements MaterialSearchBar.OnSearchActionListener {


    private KamusHelper kamusHelper;
    private SearchAdapter adapter;

    private ArrayList<KamusModel> list = new ArrayList<>();
    private boolean isEnglish = false;

    FirebaseUser mUser;
    FirebaseAuth mAuth;

    public Kamus1_1() {
        // Required empty public constructor
    }

    MaterialSearchBar bar_cari;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_kamus, container, false);

        bar_cari = v.findViewById(R.id.cari);
        bar_cari.setOnSearchActionListener(this);

        kamusHelper = new KamusHelper(getActivity());
        setupList(v);
        loadData();

        return v;
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {

    }

    @Override
    public void onButtonClicked(int buttonCode) {

    }

    @Override
    public void onSearchConfirmed(CharSequence text) {
        loadData(String.valueOf(text));
    }

    private void setupList(View view) {
        adapter = new SearchAdapter();
        RecyclerView recycler_view = view.findViewById(R.id.recycler_view);

        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_view.setAdapter(adapter);
    }

    private void loadData(String search) {
        try {
            kamusHelper.open();
            if (search.isEmpty()) {
                list = kamusHelper.getAllData(isEnglish);
            } else {
                list = kamusHelper.getDataByName(search, isEnglish);
            }

//            if (isEnglish) {
//                ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(getResources().getString(R.string.english_indonesia));
//            } else {
//                ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(getResources().getString(R.string.indonesia_english));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            kamusHelper.close();
        }
        adapter.replaceAll(list);
    }

    private void loadData() {
        loadData("");
    }
}
