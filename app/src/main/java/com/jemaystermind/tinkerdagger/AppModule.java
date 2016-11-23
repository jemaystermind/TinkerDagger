package com.jemaystermind.tinkerdagger;

import android.app.Application;
import dagger.Module;
import dagger.Provides;

@Module public class AppModule {
  private Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides Application providesApplication() {
    return application;
  }

  @Provides User providesUser() {
    return new User("Jeremy Tecson");
  }
}
