package ru.zavanton.demomvpdagger

import android.app.Application
import ru.zavanton.demomvpdagger.di.ComponentManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        ComponentManager.init(this)
    }
}