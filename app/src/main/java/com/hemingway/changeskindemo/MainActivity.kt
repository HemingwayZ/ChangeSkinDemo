package com.hemingway.changeskindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import skin.support.SkinCompatManager

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = change()
        sample_text.setOnClickListener {
            doChange()
        }
    }

    private var isNightTheme = false

    class SkinLoadListener : SkinCompatManager.SkinLoaderListener {
        val TAG:String = "MainActivity"
        override fun onSuccess() {
            Log.d(TAG, "OnSuccess")
        }

        override fun onFailed(errMsg: String?) {
            Log.d(TAG, errMsg)
        }

        override fun onStart() {
            Log.d(TAG, "OnStart")
        }

    }

    private fun doChange() {
        isNightTheme = !isNightTheme
        if (isNightTheme) {
            SkinCompatManager.getInstance().loadSkin("night", SkinLoadListener(), SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN)
        } else {
            SkinCompatManager.getInstance().restoreDefaultTheme()
        }
        Toast.makeText(this, if(isNightTheme)"Night" else "Normal", Toast.LENGTH_SHORT).show()
    }

    private fun change(): String {
        return "change"
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
