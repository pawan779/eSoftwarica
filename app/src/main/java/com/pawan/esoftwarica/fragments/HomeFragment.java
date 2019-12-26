package com.pawan.esoftwarica.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.lifecycle.Observer;


import androidx.annotation.NonNull;

import android.widget.TextView;
import android.widget.Toast;


import com.pawan.esoftwarica.MainActivity;
import com.pawan.esoftwarica.Model.HomeModel;
import com.pawan.esoftwarica.R;
import com.pawan.esoftwarica.RecycleView.Softwarica;
import com.pawan.esoftwarica.RecycleView.SoftwaricaActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private HomeModel homeModel;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeModel = ViewModelProviders.of(this).get(HomeModel.class);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textView = view.findViewById(R.id.tvhome);
        homeModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        recyclerView = view.findViewById(R.id.recyclerview);
        List<Softwarica> softwaricaList = new ArrayList<>();

        if (MainActivity.softwaricas.isEmpty()) {
            Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
        }

        else {


            SoftwaricaActivity softwaricaActivity = new SoftwaricaActivity(getContext(), MainActivity.softwaricas);
            recyclerView.setAdapter(softwaricaActivity);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        }

        return view;
    }

}
