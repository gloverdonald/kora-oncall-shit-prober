package org.example.client;

import java.util.Optional;
import ru.tinkoff.kora.common.Module;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.config.common.Config;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractionException;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractor;

@Generated("ru.tinkoff.kora.http.client.annotation.processor.ConfigModuleGenerator")
@Module
public interface $OncallClient_Module {
  default $OncallClient_Config oncallClientConfig(Config config,
      ConfigValueExtractor<$OncallClient_Config> extractor) {
    var value = config.get("oncall.api");
    return Optional.ofNullable(extractor.extract(value)).orElseThrow(() -> ConfigValueExtractionException.missingValueAfterParse(value));
  }
}
