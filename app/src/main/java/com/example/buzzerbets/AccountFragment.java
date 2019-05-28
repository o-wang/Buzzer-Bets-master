package com.example.buzzerbets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class AccountFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_account, null);
        String[] accountItems = {"Do something!",
                                "Do something else!",
                                "Do yet another thing!",
                "Do something!",
                "Do something else!",
                "Do something!",
                "Do something else!",
                "Do something!",
                "Do something else!",
                "Do something!",
                "Do something else!",
                "Do something!",
                "Do something else!",
                "Do something!",
                "Do something else!"};
        ListView listView = (ListView) view.findViewById(R.id.account);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
            getActivity(),
            android.R.layout.simple_list_item_1,
            accountItems
            );
        listView.setAdapter(listViewAdapter);
        //return inflater.inflate(R.layout.fragment_account, null);
        return view;
    }
}