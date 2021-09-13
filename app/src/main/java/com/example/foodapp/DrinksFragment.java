package com.example.foodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrinksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrinksFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<DrinksDataModel> DataHolder;


    public DrinksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrinksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrinksFragment newInstance(String param1, String param2) {
        DrinksFragment fragment = new DrinksFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drinks, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DataHolder = new ArrayList<>();

        DrinksDataModel ob1 = new DrinksDataModel(R.drawable.gojo, "Pizza", "Nrs. 1500");
        DataHolder.add(ob1);

        DrinksDataModel ob2= new DrinksDataModel(R.drawable.gojo,  "Pizza", "Nrs. 1500");
        DataHolder.add(ob2);

        DrinksDataModel ob3 = new DrinksDataModel(R.drawable.gojo, "Pizza", "Nrs. 1500");
        DataHolder.add(ob3);

        DrinksDataModel ob4 = new DrinksDataModel(R.drawable.gojo, "Pizza", "Nrs. 1500");
        DataHolder.add(ob4);

        DrinksDataModel ob5 = new DrinksDataModel(R.drawable.gojo,  "Pizza", "Nrs. 1500");
        DataHolder.add(ob5);

        recyclerView.setAdapter(new DrinksAdapter(DataHolder));

        return view;

    }
}