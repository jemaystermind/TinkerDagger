package com.jemaystermind.tinkerdagger;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class BasicModule {
  @Provides Timber.Tree providesTimberTree() {
    return new Timber.DebugTree();
  }
}
