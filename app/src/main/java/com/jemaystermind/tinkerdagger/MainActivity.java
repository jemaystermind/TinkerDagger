package com.jemaystermind.tinkerdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import javax.inject.Inject;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

  @Inject User user;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ((TinkerDaggerApp) getApplication()).getAppComponent().inject(this);

    Timber.i("User=%s", user);
  }
}
