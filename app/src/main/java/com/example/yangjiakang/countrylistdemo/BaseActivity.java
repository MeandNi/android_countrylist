package com.example.yangjiakang.countrylistdemo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


/**
 * Created by yangjiakang on 2018/7/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private boolean mNeedDefaultAni = true;
    private Toolbar mToolBar;
    protected int mTitleBarColor = -1;
//    private GestureDetector mGestureDetector;
//    protected View mPanelTopView;

    public Toolbar getToolBar()
    {
        return this.mToolBar;
    }

//    public View getTopView()
//    {
//        return this.mPanelTopView;
//    }

    protected Rect getVisibleRect()
    {
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        return localRect;
    }

    protected void hideIMM()
    {
        if (getCurrentFocus() != null) {
            ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在界面未初始化之前调用的初始化窗口
        initWidows();

        if (initArgs(getIntent().getExtras())) {
            // 得到界面Id并设置到Activity界面中
            int layId = getContentLayoutId();
            setContentView(layId);
            initBefore();
            initData();
            initWidget();
        } else {
            finish();
        }

    }

    /**
     * 初始化控件调用之前
     */
    protected void initBefore() {

    }

    /**
     * 初始化窗口
     */
    protected void initWidows() {

    }

    /**
     * 初始化相关参数
     *
     * @param bundle 参数Bundle
     * @return 如果参数正确返回True，错误返回False
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 得到当前界面的资源文件Id
     *
     * @return 资源文件Id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化控件
     */
    protected void initWidget() {
    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    public void finishActivity()
    {
        onBackPressed();
    }

    /**
     * 手势监听事件
     * @param paramMotionEvent
     * @return
     */
//    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
//    {
//        if (this.mGestureDetector != null) {
//            this.mGestureDetector.onTouchEvent(paramMotionEvent);
//        }
//        return super.dispatchTouchEvent(paramMotionEvent);
//    }
//
//    protected GestureDetector.OnGestureListener obtainGestureListener()
//    {
//        return null;
//    }

    /**
     * 组件适配
     * @return
     */
    protected DisplayMetrics getDisplayMetrics()
    {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics;
    }

    public abstract String getPageName();

    public Resources getResources()
    {
        Resources localResources = super.getResources();
        Configuration localConfiguration = new Configuration();
        localConfiguration.setToDefaults();
        localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
        return localResources;
    }

    public static void setViewGone(View paramView)
    {
        if (paramView.getVisibility() != View.GONE){
            paramView.setVisibility(View.GONE);
        }
    }

    public static void setViewVisible(View paramView)
    {
        if (paramView.getVisibility() != View.VISIBLE){
            paramView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 是否包含Fragment，默认为false
     * @return
     */
    public boolean isContainFragment()
    {
        return false;
    }

    public void closeDefaultAni()
    {
        this.mNeedDefaultAni = false;
    }

    @TargetApi(19)
    protected void setTranslucentStatus(boolean paramBoolean)
    {
        Window localWindow = getWindow();
        WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
        if (paramBoolean) {}
        for (localLayoutParams.flags |= 0x4000000;; localLayoutParams.flags &= 0xFBFFFFFF)
        {
            localWindow.setAttributes(localLayoutParams);
            return;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        // 当点击界面导航返回时，Finish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

//    @Override
//    public void onBackPressed() {
//        // 得到当前Activity下的所有Fragment
//        @SuppressLint("RestrictedApi")
//        List<Fragment> fragments = getSupportFragmentManager().getFragments();
//        // 判断是否为空
//        if (fragments != null && fragments.size() > 0) {
//            for (Fragment fragment : fragments) {
//                // 判断是否为我们能够处理的Fragment类型
//                if (fragment instanceof com.example.common.app.BaseFragment) {
//                    // 判断是否拦截了返回按钮
//                    if (((com.example.common.app.BaseFragment) fragment).onBackPressed()) {
//                        // 如果有直接Return
//                        return;
//                    }
//                }
//            }
//        }
//
//        super.onBackPressed();
//        finish();
//    }

    /**
     * 设置占位布局
     *
     * @param placeHolderView 继承了占位布局规范的View
     */
//    public void setPlaceHolderView(PlaceHolderView placeHolderView) {
//        this.mPlaceHolderView = placeHolderView;
//    }
}
