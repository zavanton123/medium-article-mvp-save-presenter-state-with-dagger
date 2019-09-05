package ru.zavanton.demomvpdagger.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.demomvpdagger.R
import ru.zavanton.demomvpdagger.di.ComponentManager
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.IView {

    @Inject
    lateinit var presenter: MainContract.IPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.getMainActivityComponent()
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)
        presenter.doSomeWork()
    }

    override fun updateView(data: String) {
        Log.d("activity", "view is updated: $data")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()

        if (isFinishing) {
            presenter.onCleared()
            ComponentManager.clearMainActivityComponent()
        }
    }
}
