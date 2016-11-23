package com.jemaystermind.tinkerdagger;

import android.app.Application;
import javax.inject.Inject;
import timber.log.Timber;

public class TinkerDaggerApp extends Application {

  private AppComponent appComponent;
  @Inject Timber.Tree tree;

  @Override public void onCreate() {
    super.onCreate();

    appComponent = DaggerAppComponent.builder() //
        .appModule(new AppModule(this)) //
        .build();
    appComponent.inject(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(tree);
    }
  }

  AppComponent getAppComponent() {
    return appComponent;
  }
}
