package com.jemaystermind.tinkerdagger;

import dagger.Component;

@Component(modules = {
    AppModule.class,
    BasicModule.class
})
public interface AppComponent {
  void inject(TinkerDaggerApp app);

  void inject(MainActivity activity);
}
