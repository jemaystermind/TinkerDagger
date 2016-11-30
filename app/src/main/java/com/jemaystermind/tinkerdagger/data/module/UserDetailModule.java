/*
 * Copyright (C) 2016 Jeremy O. Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerdagger.data.module;

import com.jemaystermind.tinkerdagger.data.ActivityScope;
import com.jemaystermind.tinkerdagger.ui.UserDetailActivity;
import dagger.Module;
import dagger.Provides;

/**
 * TODO Jemay: What does this class do?
 *
 * @author Jeremy Tecson
 */
@Module
public class UserDetailModule {
  private final UserDetailActivity activity;

  public UserDetailModule(UserDetailActivity activity) {
    this.activity = activity;
  }

  @Provides @ActivityScope UserDetailActivity providesActivity() {
    return activity;
  }
}
