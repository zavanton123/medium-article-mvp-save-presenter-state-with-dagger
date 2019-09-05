package ru.zavanton.demomvpdagger.di

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import ru.zavanton.demomvpdagger.ui.MainActivity
import ru.zavanton.demomvpdagger.ui.MainContract
import ru.zavanton.demomvpdagger.ui.MainPresenter
import javax.inject.Scope

@Scope
@Retention
annotation class ActivityScope

@ActivityScope
@Subcomponent(
    modules = [
        MainActivityModule::class,
        BindsPresenterModule::class
    ]
)
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}

@Module
class MainActivityModule {

}

@Module
interface BindsPresenterModule {

    @Binds
    fun providePresenter(impl: MainPresenter): MainContract.IPresenter
}
