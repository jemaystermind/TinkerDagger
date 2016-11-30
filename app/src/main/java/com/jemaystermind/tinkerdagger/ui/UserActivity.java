/*
 * Copyright (C) 2016 Jeremy O. Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerdagger.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jemaystermind.tinkerdagger.R;
import com.jemaystermind.tinkerdagger.data.UserActivityModule;
import com.jemaystermind.tinkerdagger.data.model.User;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * TODO Jemay: What does this class do?
 *
 * @author Jeremy Tecson
 */
public class UserActivity extends BaseActivity {

  @Inject User user;
  @Inject TinkerDaggerApp application;

  public static void start(Context context) {
    Intent starter = new Intent(context, UserActivity.class);
    context.startActivity(starter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user);
    ButterKnife.bind(this);
    Timber.i("user=%s", user);
  }

  @Override protected void setupActivityComponent() {
    ((TinkerDaggerApp) getApplication()).getUserComponent() //
        .plus(new UserActivityModule(this)) //
        .inject(this);
  }

  @OnClick(R.id.logout) void logout() {
    application.releaseUserComponent();
    finish();
  }
}
