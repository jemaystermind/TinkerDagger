/*
 * Copyright (C) 2016 Jeremy O. Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerdagger.data;

import dagger.Subcomponent;

/**
 * TODO Jemay: What does this class do?
 *
 * @author Jeremy Tecson
 */
@UserScope
@Subcomponent(modules = { UserModule.class })
public interface UserComponent {
  UserActivityComponent plus(UserActivityModule module);
}
