package org.example.client;

import java.util.Optional;
import ru.tinkoff.kora.common.Module;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.config.common.Config;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractionException;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractor;

@Generated("ru.tinkoff.kora.http.client.annotation.processor.ConfigModuleGenerator")
@Module
public interface $OncallAuthClient_Module {
  default $OncallAuthClient_Config oncallAuthClientConfig(Config config,
      ConfigValueExtractor<$OncallAuthClient_Config> extractor) {
    var value = config.get("oncall");
    return Optional.ofNullable(extractor.extract(value)).orElseThrow(() -> ConfigValueExtractionException.missingValueAfterParse(value));
  }
}
