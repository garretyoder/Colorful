package io.multimoon.colorful

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open class CAppCompatActivity : AppCompatActivity(), CBaseActivity {

    override var themeString: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleOnCreate(this, savedInstanceState, true)
    }

    override fun onResume() {
        super.onResume()
        handleOnResume(this)
    }
}