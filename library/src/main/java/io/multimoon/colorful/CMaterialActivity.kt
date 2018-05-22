package io.multimoon.colorful

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class CMaterialActivity : AppCompatActivity(), CThemeInterface {

    override var themeString: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleOnCreate(this, savedInstanceState, BaseTheme.THEME_MATERIAL_COMPONETS)
    }

    override fun onResume() {
        super.onResume()
        handleOnResume(this)
    }
}
