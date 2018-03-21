package io.multimoon.colorfulsample

import android.os.Bundle
import io.multimoon.colorful.CActivity

class MainActivity : CActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
