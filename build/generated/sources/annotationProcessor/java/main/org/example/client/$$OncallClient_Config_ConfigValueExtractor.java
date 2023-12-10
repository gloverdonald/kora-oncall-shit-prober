package org.example.client;

import jakarta.annotation.Nullable;
import java.lang.Override;
import java.lang.String;
import java.time.Duration;
import java.util.Map;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.config.common.ConfigValue;
import ru.tinkoff.kora.config.common.PathElement;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractionException;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractor;
import ru.tinkoff.kora.http.client.common.declarative.HttpClientOperationConfig;
import ru.tinkoff.kora.telemetry.common.TelemetryConfig;

@Generated("ru.tinkoff.kora.config.annotation.processor.ConfigParserGenerator")
public final class $$OncallClient_Config_ConfigValueExtractor implements ConfigValueExtractor<$OncallClient_Config> {
  private static final PathElement.Key _getTeams_path = PathElement.get("getTeams");

  private static final PathElement.Key _url_path = PathElement.get("url");

  private static final PathElement.Key _telemetry_path = PathElement.get("telemetry");

  private static final PathElement.Key _requestTimeout_path = PathElement.get("requestTimeout");

  private static final PathElement.Key _createUser_path = PathElement.get("createUser");

  private static final PathElement.Key _deleteUser_path = PathElement.get("deleteUser");

  private static final PathElement.Key _getUser_path = PathElement.get("getUser");

  private final ConfigValueExtractor<HttpClientOperationConfig> extractor1;

  private final ConfigValueExtractor<HttpClientOperationConfig> getTeams_parser;

  private final ConfigValueExtractor<TelemetryConfig> extractor2;

  private final ConfigValueExtractor<TelemetryConfig> telemetry_parser;

  private final ConfigValueExtractor<Duration> extractor3;

  private final ConfigValueExtractor<Duration> requestTimeout_parser;

  private final ConfigValueExtractor<HttpClientOperationConfig> createUser_parser;

  private final ConfigValueExtractor<HttpClientOperationConfig> deleteUser_parser;

  private final ConfigValueExtractor<HttpClientOperationConfig> getUser_parser;

  public $$OncallClient_Config_ConfigValueExtractor(
      ConfigValueExtractor<HttpClientOperationConfig> extractor1,
      ConfigValueExtractor<TelemetryConfig> extractor2, ConfigValueExtractor<Duration> extractor3) {
    this.extractor1 = extractor1;
    this.getTeams_parser = extractor1;
    this.extractor2 = extractor2;
    this.telemetry_parser = extractor2;
    this.extractor3 = extractor3;
    this.requestTimeout_parser = extractor3;
    this.createUser_parser = extractor1;
    this.deleteUser_parser = extractor1;
    this.getUser_parser = extractor1;
  }

  @Override
  public $OncallClient_Config extract(ConfigValue<?> _sourceValue) {
    if (_sourceValue instanceof ConfigValue.NullValue _nullValue) {
      _sourceValue = new ConfigValue.ObjectValue(_sourceValue.origin(), Map.of());
    }
    var _config = _sourceValue.asObject();
    var getTeams = this.parse_getTeams(_config);
    var url = this.parse_url(_config);
    var telemetry = this.parse_telemetry(_config);
    var requestTimeout = this.parse_requestTimeout(_config);
    var createUser = this.parse_createUser(_config);
    var deleteUser = this.parse_deleteUser(_config);
    var getUser = this.parse_getUser(_config);
    return new $$OncallClient_Config_ConfigValueExtractor.$OncallClient_Config_Impl(
      getTeams,
      url,
      telemetry,
      requestTimeout,
      createUser,
      deleteUser,
      getUser
    );
  }

  private HttpClientOperationConfig parse_getTeams(ConfigValue.ObjectValue config) {
    var value = config.get(_getTeams_path);
    var parsed = getTeams_parser.extract(value);
    if (parsed == null) {
      throw ConfigValueExtractionException.missingValueAfterParse(value);
    }
    return parsed;
  }

  private String parse_url(ConfigValue.ObjectValue config) {
    var value = config.get(_url_path);
    if (value instanceof ConfigValue.NullValue nullValue) {
      throw ConfigValueExtractionException.missingValue(nullValue);
    }
    return value.asString();
  }

  private TelemetryConfig parse_telemetry(ConfigValue.ObjectValue config) {
    var value = config.get(_telemetry_path);
    var parsed = telemetry_parser.extract(value);
    if (parsed == null) {
      throw ConfigValueExtractionException.missingValueAfterParse(value);
    }
    return parsed;
  }

  @Nullable
  private Duration parse_requestTimeout(ConfigValue.ObjectValue config) {
    var value = config.get(_requestTimeout_path);
    if (value instanceof ConfigValue.NullValue nullValue) {
      return null;
    }
    return requestTimeout_parser.extract(value);
  }

  private HttpClientOperationConfig parse_createUser(ConfigValue.ObjectValue config) {
    var value = config.get(_createUser_path);
    var parsed = createUser_parser.extract(value);
    if (parsed == null) {
      throw ConfigValueExtractionException.missingValueAfterParse(value);
    }
    return parsed;
  }

  private HttpClientOperationConfig parse_deleteUser(ConfigValue.ObjectValue config) {
    var value = config.get(_deleteUser_path);
    var parsed = deleteUser_parser.extract(value);
    if (parsed == null) {
      throw ConfigValueExtractionException.missingValueAfterParse(value);
    }
    return parsed;
  }

  private HttpClientOperationConfig parse_getUser(ConfigValue.ObjectValue config) {
    var value = config.get(_getUser_path);
    var parsed = getUser_parser.extract(value);
    if (parsed == null) {
      throw ConfigValueExtractionException.missingValueAfterParse(value);
    }
    return parsed;
  }

  public record $OncallClient_Config_Impl (
    ru.tinkoff.kora.http.client.common.declarative.HttpClientOperationConfig getTeams,
    java.lang.String url,
    ru.tinkoff.kora.telemetry.common.TelemetryConfig telemetry,
    java.time.Duration requestTimeout,
    ru.tinkoff.kora.http.client.common.declarative.HttpClientOperationConfig createUser,
    ru.tinkoff.kora.http.client.common.declarative.HttpClientOperationConfig deleteUser,
    ru.tinkoff.kora.http.client.common.declarative.HttpClientOperationConfig getUser
  )  implements org.example.client.$OncallClient_Config {
    public $OncallClient_Config_Impl {
      java.util.Objects.requireNonNull(getTeams);
      java.util.Objects.requireNonNull(url);
      java.util.Objects.requireNonNull(telemetry);
      java.util.Objects.requireNonNull(createUser);
      java.util.Objects.requireNonNull(deleteUser);
      java.util.Objects.requireNonNull(getUser);
    }
  }

}
