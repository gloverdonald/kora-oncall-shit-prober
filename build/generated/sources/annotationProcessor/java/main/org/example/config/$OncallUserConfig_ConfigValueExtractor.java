package org.example.config;

import java.lang.Override;
import java.lang.String;
import java.util.Map;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.config.common.ConfigValue;
import ru.tinkoff.kora.config.common.PathElement;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractionException;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractor;

@Generated("ru.tinkoff.kora.config.annotation.processor.ConfigParserGenerator")
public final class $OncallUserConfig_ConfigValueExtractor implements ConfigValueExtractor<OncallUserConfig> {
  private static final PathElement.Key _username_path = PathElement.get("username");

  private static final PathElement.Key _password_path = PathElement.get("password");

  public $OncallUserConfig_ConfigValueExtractor() {
  }

  @Override
  public OncallUserConfig extract(ConfigValue<?> _sourceValue) {
    if (_sourceValue instanceof ConfigValue.NullValue _nullValue) {
      _sourceValue = new ConfigValue.ObjectValue(_sourceValue.origin(), Map.of());
    }
    var _config = _sourceValue.asObject();
    var username = this.parse_username(_config);
    var password = this.parse_password(_config);
    return new OncallUserConfig(
      username,
      password
    );
  }

  private String parse_username(ConfigValue.ObjectValue config) {
    var value = config.get(_username_path);
    if (value instanceof ConfigValue.NullValue nullValue) {
      throw ConfigValueExtractionException.missingValue(nullValue);
    }
    return value.asString();
  }

  private String parse_password(ConfigValue.ObjectValue config) {
    var value = config.get(_password_path);
    if (value instanceof ConfigValue.NullValue nullValue) {
      throw ConfigValueExtractionException.missingValue(nullValue);
    }
    return value.asString();
  }
}
