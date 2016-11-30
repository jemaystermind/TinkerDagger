package com.jemaystermind.tinkerdagger.data.module;

import com.jemaystermind.tinkerdagger.data.component.MainActivityComponent;
import com.jemaystermind.tinkerdagger.data.component.UserComponent;
import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module(subcomponents = { MainActivityComponent.class, UserComponent.class })
public class LoggingModule {
  @Provides Timber.Tree providesTimberTree() {
    return new Timber.DebugTree();
  }
}
