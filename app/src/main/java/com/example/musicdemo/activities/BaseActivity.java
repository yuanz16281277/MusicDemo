package com.example.musicdemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.musicdemo.R;

import java.util.Arrays;

public class BaseActivity extends Activity {

    private ImageView mIvBack, mIvme;
    private TextView mTvTitle;
    private ShortcutManager mShortcutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            mShortcutManager = getSystemService(ShortcutManager.class);
            getNewShortcutInfo();
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    private void getNewShortcutInfo() {
        ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "id1")
                .setShortLabel("Web site")
                .setLongLabel("第一个")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_launcher_background))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.baidu.com/")))
                .build();
        ShortcutInfo shortcut2 = new ShortcutInfo.Builder(this, "id2")
                .setShortLabel("Web site")
                .setLongLabel("第二个")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_launcher_background))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.csdn.com/")))
                .build();
        mShortcutManager.setDynamicShortcuts(Arrays.asList(shortcut, shortcut2));
    }

    /**
     * findViewById
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T fd(@IdRes int id) {
        return findViewById(id);
    }

    /**
     * 初始化NavigationBar
     *
     * @param isShowBack
     * @param title
     * @param isShowme
     */
    protected void initNavBar(boolean isShowBack, String title, boolean isShowme) {

        mIvBack = fd(R.id.iv_back);
        mTvTitle = fd(R.id.tv_title);
        mIvme = fd(R.id.iv_me);

        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mIvme.setVisibility(isShowme ? View.VISIBLE : View.GONE);
        mTvTitle.setText(title);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
