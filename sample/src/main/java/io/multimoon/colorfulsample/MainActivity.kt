package io.multimoon.colorfulsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.multimoon.colorful.CActivity
import io.multimoon.colorful.CAppCompatActivity
import io.multimoon.colorful.Colorful
import io.multimoon.colorful.ThemeColor

class MainActivity : CActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
