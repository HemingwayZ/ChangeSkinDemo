package com.hemingway.changeskindemo

import android.app.Application
import skin.support.SkinCompatManager



/**
 * Created by Hemingway on 2018/12/6
 * Desc:
 */
class BaseApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        SkinCompatManager.withoutActivity(this)
//            .addInflater(SkinAppCompatViewInflater())           // 基础控件换肤初始化
//            .addInflater(SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
//            .addInflater(SkinConstraintViewInflater())          // ConstraintLayout 控件换肤初始化[可选]
//            .addInflater(SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
            .setSkinStatusBarColorEnable(false)                     // 关闭状态栏换肤，默认打开[可选]
            .setSkinWindowBackgroundEnable(false)                   // 关闭windowBackground换肤，默认打开[可选]
            .loadSkin()
    }
}