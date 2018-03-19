package io.multimoon.colorfulsample

import android.app.Application
import io.multimoon.colorful.Defaults
import io.multimoon.colorful.ThemeColor
import io.multimoon.colorful.initColorful

class SampleApp:Application() {
    override fun onCreate() {
        super.onCreate()
        initColorful(this, Defaults(ThemeColor.GREEN, ThemeColor.BLUE, false))

    }
}