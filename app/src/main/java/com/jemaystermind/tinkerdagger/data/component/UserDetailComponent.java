/*
 * Copyright (C) 2016 Jeremy O. Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerdagger.data.component;

import com.jemaystermind.tinkerdagger.data.ActivityScope;
import com.jemaystermind.tinkerdagger.data.SubcomponentBuilder;
import com.jemaystermind.tinkerdagger.data.module.UserDetailModule;
import com.jemaystermind.tinkerdagger.ui.UserDetailActivity;
import dagger.Subcomponent;

/**
 * TODO Jemay: What does this class do?
 *
 * @author Jeremy Tecson
 */
@ActivityScope
@Subcomponent(modules = UserDetailModule.class)
public interface UserDetailComponent {

  void inject(UserDetailActivity activity);

  @Subcomponent.Builder
  interface Builder extends SubcomponentBuilder<UserDetailComponent> {
    Builder userDetailModule(UserDetailModule userDetailModule);
  }
}
