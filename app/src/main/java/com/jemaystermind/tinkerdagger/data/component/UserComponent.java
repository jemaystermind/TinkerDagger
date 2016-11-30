/*
 * Copyright (C) 2016 Jeremy O. Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerdagger.data.component;

import com.jemaystermind.tinkerdagger.data.SubcomponentBuilder;
import com.jemaystermind.tinkerdagger.data.module.UserModule;
import com.jemaystermind.tinkerdagger.data.UserScope;
import dagger.Subcomponent;

/**
 * TODO Jemay: What does this class do?
 *
 * @author Jeremy Tecson
 */
@UserScope
@Subcomponent(modules = { UserModule.class })
public interface UserComponent {

  UserActivityComponent.Builder userActivityComponent();

  UserDetailComponent.Builder userDetailComponent();

  @Subcomponent.Builder
  interface Builder extends SubcomponentBuilder<UserComponent> {
    Builder userModule(UserModule userModule);
  }
}
