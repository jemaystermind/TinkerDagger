package com.jemaystermind.tinkerdagger.data;

import com.jemaystermind.tinkerdagger.ui.TinkerDaggerApp;
import dagger.Component;
import javax.inject.Singleton;

@Singleton // @Singleton SHOULD be treated as the highest scope possible for scoped components
@Component(modules = {
    AppModule.class,
    LoggingModule.class,
})
public interface AppComponent {
  void inject(TinkerDaggerApp app);

  // Sub-components here
  UserComponent plus(UserModule module);

  MainActivityComponent plus(MainActivityModule module);
}
