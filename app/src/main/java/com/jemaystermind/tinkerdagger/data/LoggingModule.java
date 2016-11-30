package com.jemaystermind.tinkerdagger.data;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class LoggingModule {
  @Provides Timber.Tree providesTimberTree() {
    return new Timber.DebugTree();
  }
}
