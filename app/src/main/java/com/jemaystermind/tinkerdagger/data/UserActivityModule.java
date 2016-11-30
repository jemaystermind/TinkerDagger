/*
 * Copyright (C) 2016 Jeremy O. Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerdagger.data;

import android.app.Activity;
import com.jemaystermind.tinkerdagger.ui.UserActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Provides presenter, interactor and repository for {@link UserActivity}.
 *
 * @author Jeremy Tecson
 */
@Module
public class UserActivityModule {
  private final Activity activity;

  public UserActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides @ActivityScope Activity providesActivity() {
    return activity;
  }
}
