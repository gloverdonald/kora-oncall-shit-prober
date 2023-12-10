package ru.tinkoff.kora.scheduling.jdk;

import java.lang.Override;
import java.util.Map;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.config.common.ConfigValue;
import ru.tinkoff.kora.config.common.PathElement;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractionException;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractor;

@Generated("ru.tinkoff.kora.config.annotation.processor.ConfigParserGenerator")
public final class $ScheduledExecutorServiceConfig_ConfigValueExtractor implements ConfigValueExtractor<ScheduledExecutorServiceConfig> {
  private static final PathElement.Key _threads_path = PathElement.get("threads");

  public $ScheduledExecutorServiceConfig_ConfigValueExtractor() {
  }

  @Override
  public ScheduledExecutorServiceConfig extract(ConfigValue<?> _sourceValue) {
    if (_sourceValue instanceof ConfigValue.NullValue _nullValue) {
      _sourceValue = new ConfigValue.ObjectValue(_sourceValue.origin(), Map.of());
    }
    var _config = _sourceValue.asObject();
    var threads = this.parse_threads(_config);
    return new ScheduledExecutorServiceConfig(
      threads
    );
  }

  private int parse_threads(ConfigValue.ObjectValue config) {
    var value = config.get(_threads_path);
    if (value instanceof ConfigValue.NullValue nullValue) {
      throw ConfigValueExtractionException.missingValue(nullValue);
    }
    return value.asNumber().intValue();
  }
}
