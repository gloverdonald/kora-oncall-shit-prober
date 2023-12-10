package org.example;

import org.example.client.$OncallAuthClient_Module;
import org.example.client.$OncallClient_Module;
import org.example.config.OncallUserConfigModule;
import org.example.controller.TestControllerModule;
import org.example.scheduled.$OncallProber_SchedulingModule;
import ru.tinkoff.kora.common.annotation.Generated;

@Generated("ru.tinkoff.kora.kora.app.annotation.processor.KoraAppProcessor")
public final class ApplicationImpl implements Application {
  public $OncallAuthClient_Module module0 = new $OncallAuthClient_Module(){};

  public $OncallClient_Module module1 = new $OncallClient_Module(){};

  public OncallUserConfigModule module2 = new OncallUserConfigModule(){};

  public TestControllerModule module3 = new TestControllerModule(){};

  public $OncallProber_SchedulingModule module4 = new $OncallProber_SchedulingModule(){};
}
