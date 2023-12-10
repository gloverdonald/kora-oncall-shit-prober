package org.example.client;

import ru.tinkoff.kora.config.common.annotation.ConfigValueExtractor;
import ru.tinkoff.kora.http.client.common.declarative.DeclarativeHttpClientConfig;
import ru.tinkoff.kora.http.client.common.declarative.HttpClientOperationConfig;

@ConfigValueExtractor
public interface $OncallClient_Config extends DeclarativeHttpClientConfig {
  HttpClientOperationConfig getTeams();

  HttpClientOperationConfig createUser();

  HttpClientOperationConfig deleteUser();

  HttpClientOperationConfig getUser();
}
