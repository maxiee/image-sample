package com.example.maxiee.image_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private static final String[] IMAGE_URLS = new String[] {
            "http://llss.qiniudn.com/forum/image/525d1960c008906923000001_1397820588.jpg",
            "http://llss.qiniudn.com/forum/image/e8275adbeedc48fe9c13cd0efacbabdd_1397877461243.jpg",
            "http://llss.qiniudn.com/uploads/forum/topic/attached_img/5350db2ffcfff258b500dcb2/_____2014-04-18___3.52.33.png"
    };

    private LinearLayout mMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMainLayout = (LinearLayout) findViewById(R.id.main_layout);

        showImages(IMAGE_URLS);
    }

    private void showImages(String[] urls) {
        int margin = (int) getResources().getDimension(R.dimen.image_margin);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(margin, margin, margin, margin);
        for (String url: urls) {
            ImageView imageView = new ImageView(this);
            mMainLayout.addView(imageView, layoutParams);
            Glide.with(this).load(url).into(imageView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
