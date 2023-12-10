package org.example;

import ru.tinkoff.kora.common.KoraApp;
import ru.tinkoff.kora.config.hocon.HoconConfigModule;
import ru.tinkoff.kora.http.client.async.AsyncHttpClientModule;
import ru.tinkoff.kora.http.server.undertow.UndertowHttpServerModule;
import ru.tinkoff.kora.json.module.JsonModule;
import ru.tinkoff.kora.micrometer.module.MetricsModule;
import ru.tinkoff.kora.scheduling.jdk.SchedulingJdkModule;

@KoraApp
public interface Application extends
    HoconConfigModule,
    AsyncHttpClientModule,
    UndertowHttpServerModule,
    JsonModule,
    SchedulingJdkModule,
    MetricsModule {

}
