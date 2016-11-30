package com.jemaystermind.tinkerdagger.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupActivityComponent();
  }

  /***
   * NEVER forget to call the inject() method to satisfy the dependencies!
   */
  protected abstract void setupActivityComponent();
}
