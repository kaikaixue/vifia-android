package com.vifia.module_mine;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MineApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
