package com.example.musicdemo.activities;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;

import com.example.musicdemo.R;

public class BaseActivity extends Activity {

    private ImageView mIvBack, mIvme;
    private TextView mTvTitle;

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
