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

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    //API stuff
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("node");
    }

    public static boolean _startedNodeAlready = false;

    String test = "";

    public native String startNodeWithArguments(String[] arguments);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, null);
        ListView listView = (ListView) view.findViewById(R.id.home);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        if (!_startedNodeAlready) {
            _startedNodeAlready = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String nodeDir = getContext().getFilesDir().getAbsolutePath() + "/nodejs-project";
                    if (wasAPKUpdated()) {
                        File nodeDirReference = new File(nodeDir);
                        if (nodeDirReference.exists()) {
                            deleteFolderRecursively(new File(nodeDir));
                        }
                        copyAssetFolder(getContext().getAssets(), "nodejs-project", nodeDir);

                        saveLastUpdateTime();
                    }
                    test = startNodeWithArguments(new String[]{"node", nodeDir + "/main.js"});
                }
            }).start();
        }
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

    @Override
    public void onResume(){
        super.onResume();

        String[] gc_separated = test.split(":");
        for (int i = 0; i < gc_separated.length; i++){
            Log.d("HOME", gc_separated[i] + "=====");
        }

        Toast toast = Toast.makeText(getContext(), "WTF", Toast.LENGTH_SHORT);
        toast.show();
    }

    private boolean wasAPKUpdated() {
        SharedPreferences prefs = getContext().getSharedPreferences("NODEJS_MOBILE_PREFS", Context.MODE_PRIVATE);
        long previousLastUpdateTime = prefs.getLong("NODEJS_MOBILE_APK_LastUpdateTime", 0);
        long lastUpdateTime = 1;
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            lastUpdateTime = packageInfo.lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return (lastUpdateTime != previousLastUpdateTime);
    }

    private void saveLastUpdateTime() {
        long lastUpdateTime = 1;
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            lastUpdateTime = packageInfo.lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        SharedPreferences prefs = getContext().getSharedPreferences("NODEJS_MOBILE_PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("NODEJS_MOBILE_APK_LastUpdateTime", lastUpdateTime);
        editor.commit();
    }

    private static boolean deleteFolderRecursively(File file) {
        try {
            boolean res=true;
            for (File childFile : file.listFiles()) {
                if (childFile.isDirectory()) {
                    res &= deleteFolderRecursively(childFile);
                } else {
                    res &= childFile.delete();
                }
            }
            res &= file.delete();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean copyAssetFolder(AssetManager assetManager, String fromAssetPath, String toPath) {
        try {
            String[] files = assetManager.list(fromAssetPath);
            boolean res = true;

            if (files.length==0) {
                //If it's a file, it won't have any assets "inside" it.
                res &= copyAsset(assetManager,
                        fromAssetPath,
                        toPath);
            } else {
                new File(toPath).mkdirs();
                for (String file : files)
                    res &= copyAssetFolder(assetManager,
                            fromAssetPath + "/" + file,
                            toPath + "/" + file);
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean copyAsset(AssetManager assetManager, String fromAssetPath, String toPath) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(fromAssetPath);
            new File(toPath).createNewFile();
            out = new FileOutputStream(toPath);
            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
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
            View view = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView mImageView = view.findViewById(R.id.imageView);
            TextView mTextView = view.findViewById(R.id.textview);
            mImageView.setImageResource(images[position]);
            mTextView.setText(homeItems[position]);
            return view;
        }
    }
}
