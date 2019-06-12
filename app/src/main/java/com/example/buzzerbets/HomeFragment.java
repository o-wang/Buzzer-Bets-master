//package com.example.buzzerbets;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//public class HomeFragment extends Fragment {
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //return super.onCreateView(inflater, container, savedInstanceState);
//        return inflater.inflate(R.layout.fragment_home, null);
//    }
//}
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

public class HomeFragment extends Fragment {
    int[] images = {R.drawable.steph_curry,
            R.drawable.steph_curry,
            R.drawable.steph_curry,
            R.drawable.steph_curry,
            R.drawable.steph_curry,
            R.drawable.steph_curry
    };
    String[] homeItems = {"Item1",
            "Item2", "Item3", "Item4", "Item5", "Item6"
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, null);
        ListView listView = (ListView) view.findViewById(R.id.home);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent myIntent = new Intent(view.getContext(), gameActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if(position==1){
                    Intent myIntent = new Intent(view.getContext(), gameActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if(position==2){
                    Intent myIntent = new Intent(view.getContext(), gameActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if(position==3){
                    Intent myIntent = new Intent(view.getContext(), gameActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if(position==4){
                    Intent myIntent = new Intent(view.getContext(), gameActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if(position==5){
                    Intent myIntent = new Intent(view.getContext(), gameActivity.class);
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
            View view = getLayoutInflater().inflate(R.layout.custom3layout, null);
            ImageView mImageView = view.findViewById(R.id.imageView);
            TextView mTextView = view.findViewById(R.id.textview);
            mImageView.setImageResource(images[position]);
            mTextView.setText(homeItems[position]);
            return view;
        }
    }
}
