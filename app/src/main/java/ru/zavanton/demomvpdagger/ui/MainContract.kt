package ru.zavanton.demomvpdagger.ui

interface MainContract {

    interface IView {

        fun updateView(data: String)
    }

    interface IPresenter {

        fun attachView(view: IView)
        fun detachView()

        fun doSomeWork()
        fun onCleared()
    }
}