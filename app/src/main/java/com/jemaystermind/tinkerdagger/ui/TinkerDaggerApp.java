package com.jemaystermind.tinkerdagger.ui;

import android.app.Application;
import android.support.annotation.NonNull;
import com.jemaystermind.tinkerdagger.data.component.AppComponent;
import com.jemaystermind.tinkerdagger.data.component.DaggerAppComponent;
import com.jemaystermind.tinkerdagger.data.component.UserComponent;
import com.jemaystermind.tinkerdagger.data.model.User;
import com.jemaystermind.tinkerdagger.data.module.AppModule;
import com.jemaystermind.tinkerdagger.data.module.UserModule;
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
  UserComponent createUserComponent(@NonNull User user) {
    return userComponent = appComponent.userComponent() //
        .userModule(new UserModule(user)) //
        .build();
  }

  // Call this when a user "logs out" from the app
  void releaseUserComponent() {
    userComponent = null;
  }

  UserComponent getUserComponent() {
    return userComponent;
  }
}
