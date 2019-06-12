package com.example.buzzerbets;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AccountFragment extends Fragment {
    int[] images = {
            R.drawable.cash,
            R.drawable.trans_log
    };
    String[] accountItems =
        {
                                "Add Payment",
                                "Logout"
        };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_account, null);
        ListView listView = (ListView) view.findViewById(R.id.account);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent myIntent = new Intent(view.getContext(), balanceActivity.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
//        String[] accountItems = {"Do something!",
//                                "Do something else!",
//                                "Do yet another thing!",
//                "Do something!",
//                "Do something else!",
//                "Do something!",
//                "Do something else!",
//                "Do something!",
//                "Do something else!",
//                "Do something else!",
//                "Do something!",
//                "Do something else!",
//                "Do something!",
//                "Do something else!",
//                "Do something!",
//                "Do something else!"};
//        ListView listView = (ListView) view.findViewById(R.id.account);
//        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
//            getActivity(),
//            android.R.layout.simple_list_item_1,
//            accountItems
//            );
//        listView.setAdapter(listViewAdapter);
//        //return inflater.inflate(R.layout.fragment_account, null);
        return view;
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.custom2layout, null);
            ImageView mImageView = view.findViewById(R.id.imageView);
            TextView mTextView = view.findViewById(R.id.textview);
            mImageView.setImageResource(images[position]);
            mTextView.setText(accountItems[position]);
            return view;
        }
    }
}