package com.color.tools.database

import android.app.Application
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class App :Application(){
    override fun onCreate() {
        super.onCreate()
        ViewPump.init(ViewPump.builder()
            .addInterceptor( CalligraphyInterceptor(
                     CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/app_r.ttf")
                        .build())
            )
            .build())
    }
}