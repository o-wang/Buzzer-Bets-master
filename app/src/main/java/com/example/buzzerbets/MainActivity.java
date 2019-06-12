package com.example.buzzerbets;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
//    private TextView mTextMessage;
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_account:
//                    mTextMessage.setText(R.string.title_account);
//                    return true;
//                case R.id.navigation_history:
//                    mTextMessage.setText(R.string.title_history);
//                    return true;
//            }
//            return false;
//        }
//    };

//    static {
//        System.loadLibrary("native-lib");
//        System.loadLibrary("node");
//    }
//
//    public static boolean _startedNodeAlready = false;
//
//    String test = "";
//
//    public native String startNodeWithArguments(String[] arguments);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());

//        if (!_startedNodeAlready) {
//            _startedNodeAlready = true;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    String nodeDir = getApplicationContext().getFilesDir().getAbsolutePath() + "/nodejs-project";
//                    if (wasAPKUpdated()) {
//                        File nodeDirReference = new File(nodeDir);
//                        if (nodeDirReference.exists()) {
//                            deleteFolderRecursively(new File(nodeDir));
//                        }
//                        copyAssetFolder(getApplicationContext().getAssets(), "nodejs-project", nodeDir);
//
//                        saveLastUpdateTime();
//                    }
//                    test = startNodeWithArguments(new String[]{"node", nodeDir + "/main.js"});
//                }
//            }).start();
//        }
    }

    @Override
    protected void onResume(){
        super.onResume();
//        Toast toast = Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT);
//        toast.show();
    }

//    private boolean wasAPKUpdated() {
//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("NODEJS_MOBILE_PREFS", Context.MODE_PRIVATE);
//        long previousLastUpdateTime = prefs.getLong("NODEJS_MOBILE_APK_LastUpdateTime", 0);
//        long lastUpdateTime = 1;
//        try {
//            PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
//            lastUpdateTime = packageInfo.lastUpdateTime;
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return (lastUpdateTime != previousLastUpdateTime);
//    }
//
//    private void saveLastUpdateTime() {
//        long lastUpdateTime = 1;
//        try {
//            PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
//            lastUpdateTime = packageInfo.lastUpdateTime;
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        SharedPreferences prefs = getApplicationContext().getSharedPreferences("NODEJS_MOBILE_PREFS", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putLong("NODEJS_MOBILE_APK_LastUpdateTime", lastUpdateTime);
//        editor.commit();
//    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch(menuItem.getItemId()){
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_history:
                fragment = new HistoryFragment();
                break;
            case R.id.navigation_account:
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);
    }

//    private static boolean deleteFolderRecursively(File file) {
//        try {
//            boolean res=true;
//            for (File childFile : file.listFiles()) {
//                if (childFile.isDirectory()) {
//                    res &= deleteFolderRecursively(childFile);
//                } else {
//                    res &= childFile.delete();
//                }
//            }
//            res &= file.delete();
//            return res;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    private static boolean copyAssetFolder(AssetManager assetManager, String fromAssetPath, String toPath) {
//        try {
//            String[] files = assetManager.list(fromAssetPath);
//            boolean res = true;
//
//            if (files.length==0) {
//                //If it's a file, it won't have any assets "inside" it.
//                res &= copyAsset(assetManager,
//                        fromAssetPath,
//                        toPath);
//            } else {
//                new File(toPath).mkdirs();
//                for (String file : files)
//                    res &= copyAssetFolder(assetManager,
//                            fromAssetPath + "/" + file,
//                            toPath + "/" + file);
//            }
//            return res;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    private static boolean copyAsset(AssetManager assetManager, String fromAssetPath, String toPath) {
//        InputStream in = null;
//        OutputStream out = null;
//        try {
//            in = assetManager.open(fromAssetPath);
//            new File(toPath).createNewFile();
//            out = new FileOutputStream(toPath);
//            copyFile(in, out);
//            in.close();
//            in = null;
//            out.flush();
//            out.close();
//            out = null;
//            return true;
//        } catch(Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    private static void copyFile(InputStream in, OutputStream out) throws IOException {
//        byte[] buffer = new byte[1024];
//        int read;
//        while ((read = in.read(buffer)) != -1) {
//            out.write(buffer, 0, read);
//        }
//    }
}
