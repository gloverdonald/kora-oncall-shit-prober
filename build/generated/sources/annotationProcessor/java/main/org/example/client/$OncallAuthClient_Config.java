package org.example.client;

import ru.tinkoff.kora.config.common.annotation.ConfigValueExtractor;
import ru.tinkoff.kora.http.client.common.declarative.DeclarativeHttpClientConfig;
import ru.tinkoff.kora.http.client.common.declarative.HttpClientOperationConfig;

@ConfigValueExtractor
public interface $OncallAuthClient_Config extends DeclarativeHttpClientConfig {
  HttpClientOperationConfig login();
}
