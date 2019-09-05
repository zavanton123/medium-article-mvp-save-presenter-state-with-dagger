package ru.zavanton.demomvpdagger.ui

import android.util.Log
import ru.zavanton.demomvpdagger.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class MainPresenter @Inject constructor() : MainContract.IPresenter {

    private var view: MainContract.IView? = null

    init {
        Log.d("presenter", "presenter is init")
    }

    override fun attachView(view: MainContract.IView) {
        Log.d("presenter", "view attached")
        this.view = view
    }

    override fun detachView() {
        Log.d("presenter", "view detached")
        view = null
    }

    override fun doSomeWork() {
        Log.d("presenter", "doSomeWork")
        view?.updateView("123")
    }

    override fun onCleared() {
        Log.d("presenter", "onCleared")
    }
}