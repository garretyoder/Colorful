package io.multimoon.colorful

import android.app.Activity
import android.os.Bundle

open class CActivity : Activity(), CBaseActivity {

    override var themeString: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleOnCreate(this, savedInstanceState, false)
    }

    override fun onResume() {
        super.onResume()
        handleOnResume(this)
    }
}