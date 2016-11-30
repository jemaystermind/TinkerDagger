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
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jemaystermind.tinkerdagger.R;
import com.jemaystermind.tinkerdagger.data.component.UserDetailComponent;
import com.jemaystermind.tinkerdagger.data.model.User;
import com.jemaystermind.tinkerdagger.data.module.UserDetailModule;
import javax.inject.Inject;

/**
 * TODO Jemay: What does this class do?
 *
 * @author Jeremy Tecson
 */
public class UserDetailActivity extends BaseActivity {

  @BindView(R.id.user_detail) TextView userDetail;

  @Inject User user;

  public static void start(Context context) {
    Intent starter = new Intent(context, UserDetailActivity.class);
    context.startActivity(starter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_detail);
    ButterKnife.bind(this);
    userDetail.setText(user.toString());
  }

  @Override protected void setupActivityComponent() {
    final UserDetailComponent component =
        ((TinkerDaggerApp) getApplication()).getUserComponent().userDetailComponent() //
            .userDetailModule(new UserDetailModule(this)) //
            .build();
    component.inject(this);
  }
}
