package com.jemaystermind.tinkerdagger.data.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.jemaystermind.tinkerdagger.data.UserToken;
import com.jemaystermind.tinkerdagger.data.component.MainActivityComponent;
import com.jemaystermind.tinkerdagger.data.component.UserComponent;
import com.jemaystermind.tinkerdagger.ui.TinkerDaggerApp;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(subcomponents = { MainActivityComponent.class, UserComponent.class })
public final class AppModule {
  private TinkerDaggerApp application;

  public AppModule(TinkerDaggerApp application) {
    this.application = application;
  }

  @Provides TinkerDaggerApp providesCustomApplication() {
    return application;
  }

  @Provides Application providesApplication() {
    return application;
  }

  @Provides @Singleton Resources providesResources() {
    return application.getResources();
  }

  @Provides @Singleton @UserToken String providesUserToken() {
    return "user_cache";
  }

  @Provides @Singleton SharedPreferences providesSharedPreferences(Application application) {
    return PreferenceManager.getDefaultSharedPreferences(application);
  }
}
