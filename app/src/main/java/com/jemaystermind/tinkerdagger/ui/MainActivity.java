package com.jemaystermind.tinkerdagger.ui;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jemaystermind.tinkerdagger.R;
import com.jemaystermind.tinkerdagger.data.component.MainActivityComponent;
import com.jemaystermind.tinkerdagger.data.model.User;
import com.jemaystermind.tinkerdagger.data.module.MainActivityModule;
import javax.inject.Inject;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

  @BindView(R.id.greetings) TextView greetings;

  @Inject TinkerDaggerApp application;
  @Inject SharedPreferences preferences;
  @Inject Resources resources;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    Timber.i("preference=%s", preferences.toString());
    greetings.setBackground(ResourcesCompat.getDrawable(resources, R.mipmap.ic_launcher, null));
  }

  @Override protected void setupActivityComponent() {
    final MainActivityComponent component =
        ((TinkerDaggerApp) getApplication()).getAppComponent() //
            .mainActivityComponent() //
            .activityModule(new MainActivityModule(this)) //
            .build();
    component.inject(this);
  }

  @OnClick(R.id.start) void startUser() {
    application.createUserComponent(new User("Anonymous Otter"));
    UserActivity.start(this);
  }
}
