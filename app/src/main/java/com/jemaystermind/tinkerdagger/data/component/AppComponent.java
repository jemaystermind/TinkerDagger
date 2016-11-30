package com.jemaystermind.tinkerdagger.data.component;

import com.jemaystermind.tinkerdagger.data.ComponentBuilder;
import com.jemaystermind.tinkerdagger.data.module.AppModule;
import com.jemaystermind.tinkerdagger.data.module.LoggingModule;
import com.jemaystermind.tinkerdagger.ui.TinkerDaggerApp;
import dagger.Component;
import javax.inject.Singleton;

@Singleton // @Singleton SHOULD be treated as the highest scope possible for components
@Component(modules = {
    AppModule.class, LoggingModule.class,
})
public interface AppComponent {
  void inject(TinkerDaggerApp app);

  MainActivityComponent.Builder mainActivityComponent();

  UserComponent.Builder userComponent();

  @Component.Builder
  interface Builder extends ComponentBuilder<AppComponent> {
    Builder appModule(AppModule appModule);

    Builder loggingModule(LoggingModule loggingModule);
  }
}
