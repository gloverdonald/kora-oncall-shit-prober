package org.example.dto;

import ru.tinkoff.kora.json.common.annotation.Json;
import ru.tinkoff.kora.json.common.annotation.JsonField;

public record LoginResponse(
    @JsonField("csrf_token") String csrfToken
) {
}
