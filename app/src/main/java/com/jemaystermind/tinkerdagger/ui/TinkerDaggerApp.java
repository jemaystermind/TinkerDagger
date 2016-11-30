package com.jemaystermind.tinkerdagger.ui;

import android.app.Application;
import com.jemaystermind.tinkerdagger.data.AppComponent;
import com.jemaystermind.tinkerdagger.data.AppModule;
import com.jemaystermind.tinkerdagger.data.DaggerAppComponent;
import com.jemaystermind.tinkerdagger.data.UserComponent;
import com.jemaystermind.tinkerdagger.data.UserModule;
import com.jemaystermind.tinkerdagger.data.model.User;
import javax.inject.Inject;
import timber.log.Timber;

public class TinkerDaggerApp extends Application {

  @Inject Timber.Tree tree;

  private AppComponent appComponent;
  private UserComponent userComponent;

  @Override public void onCreate() {
    super.onCreate();
    initAppComponent();
    Timber.plant(tree);
  }

  // MUST be called before using the injected dependencies
  void initAppComponent() {
    appComponent = DaggerAppComponent.builder() //
        .appModule(new AppModule(this)) //
        .build();
    appComponent.inject(this);
  }

  AppComponent getAppComponent() {
    return appComponent;
  }

  // Call this when a user "logs in" to the app
  UserComponent createUserComponent(User user) {
    return userComponent = appComponent.plus(new UserModule(user));
  }

  // Call this when a user "logs out" from the app
  void releaseUserComponent() {
    userComponent = null;
  }

  UserComponent getUserComponent() {
    return userComponent;
  }
}
