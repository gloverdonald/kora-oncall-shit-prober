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
public final class $$OncallAuthClient_Config_ConfigValueExtractor implements ConfigValueExtractor<$OncallAuthClient_Config> {
  private static final PathElement.Key _login_path = PathElement.get("login");

  private static final PathElement.Key _url_path = PathElement.get("url");

  private static final PathElement.Key _telemetry_path = PathElement.get("telemetry");

  private static final PathElement.Key _requestTimeout_path = PathElement.get("requestTimeout");

  private final ConfigValueExtractor<HttpClientOperationConfig> extractor1;

  private final ConfigValueExtractor<HttpClientOperationConfig> login_parser;

  private final ConfigValueExtractor<TelemetryConfig> extractor2;

  private final ConfigValueExtractor<TelemetryConfig> telemetry_parser;

  private final ConfigValueExtractor<Duration> extractor3;

  private final ConfigValueExtractor<Duration> requestTimeout_parser;

  public $$OncallAuthClient_Config_ConfigValueExtractor(
      ConfigValueExtractor<HttpClientOperationConfig> extractor1,
      ConfigValueExtractor<TelemetryConfig> extractor2, ConfigValueExtractor<Duration> extractor3) {
    this.extractor1 = extractor1;
    this.login_parser = extractor1;
    this.extractor2 = extractor2;
    this.telemetry_parser = extractor2;
    this.extractor3 = extractor3;
    this.requestTimeout_parser = extractor3;
  }

  @Override
  public $OncallAuthClient_Config extract(ConfigValue<?> _sourceValue) {
    if (_sourceValue instanceof ConfigValue.NullValue _nullValue) {
      _sourceValue = new ConfigValue.ObjectValue(_sourceValue.origin(), Map.of());
    }
    var _config = _sourceValue.asObject();
    var login = this.parse_login(_config);
    var url = this.parse_url(_config);
    var telemetry = this.parse_telemetry(_config);
    var requestTimeout = this.parse_requestTimeout(_config);
    return new $$OncallAuthClient_Config_ConfigValueExtractor.$OncallAuthClient_Config_Impl(
      login,
      url,
      telemetry,
      requestTimeout
    );
  }

  private HttpClientOperationConfig parse_login(ConfigValue.ObjectValue config) {
    var value = config.get(_login_path);
    var parsed = login_parser.extract(value);
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

  public record $OncallAuthClient_Config_Impl (
    ru.tinkoff.kora.http.client.common.declarative.HttpClientOperationConfig login,
    java.lang.String url,
    ru.tinkoff.kora.telemetry.common.TelemetryConfig telemetry,
    java.time.Duration requestTimeout
  )  implements org.example.client.$OncallAuthClient_Config {
    public $OncallAuthClient_Config_Impl {
      java.util.Objects.requireNonNull(login);
      java.util.Objects.requireNonNull(url);
      java.util.Objects.requireNonNull(telemetry);
    }
  }

}
