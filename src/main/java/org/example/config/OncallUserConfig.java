package org.example.config;

import ru.tinkoff.kora.config.common.annotation.ConfigSource;

@ConfigSource("oncall.user")
public record OncallUserConfig(
    String username,
    String password
) {
}
