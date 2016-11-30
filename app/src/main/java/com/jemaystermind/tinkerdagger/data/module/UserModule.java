/*
 * Copyright (C) 2016 Jeremy O. Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerdagger.data.module;

import com.jemaystermind.tinkerdagger.data.UserScope;
import com.jemaystermind.tinkerdagger.data.component.UserActivityComponent;
import com.jemaystermind.tinkerdagger.data.component.UserDetailComponent;
import com.jemaystermind.tinkerdagger.data.model.User;
import dagger.Module;
import dagger.Provides;

/**
 * TODO Jemay: What does this class do?
 *
 * @author Jeremy Tecson
 */
@Module(subcomponents = { UserActivityComponent.class, UserDetailComponent.class })
public class UserModule {

  private final User user;

  public UserModule(User user) {
    this.user = user;
  }

  @Provides @UserScope User providesUser() {
    return user;
  }
}
