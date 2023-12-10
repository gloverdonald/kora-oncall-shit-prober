package org.example.controller;

import org.example.service.OncallService;
import ru.tinkoff.kora.common.Component;
import ru.tinkoff.kora.common.Context;
import ru.tinkoff.kora.http.common.annotation.HttpRoute;
import ru.tinkoff.kora.http.server.common.annotation.HttpController;
import ru.tinkoff.kora.json.common.annotation.Json;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletionStage;

import static ru.tinkoff.kora.http.common.HttpMethod.GET;
import static ru.tinkoff.kora.http.common.HttpMethod.POST;

@Component
@HttpController
public class TestController {

    private final OncallService oncallService;

    public TestController(OncallService oncallService) {
        this.oncallService = oncallService;
    }

    @HttpRoute(path = "/test", method = GET)
    public String getTest() {
        return oncallService.createUser("test").toString();
    }
}
