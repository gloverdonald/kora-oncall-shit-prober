package org.example.client;

import org.example.dto.LoginResponse;
import org.example.dto.UserAuthRequest;
import org.example.dto.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tinkoff.kora.common.Component;
import ru.tinkoff.kora.http.client.common.HttpClientDecoderException;
import ru.tinkoff.kora.http.client.common.annotation.HttpClient;
import ru.tinkoff.kora.http.client.common.annotation.ResponseCodeMapper;
import ru.tinkoff.kora.http.client.common.response.HttpClientResponse;
import ru.tinkoff.kora.http.client.common.response.HttpClientResponseMapper;
import ru.tinkoff.kora.http.common.HttpMethod;
import ru.tinkoff.kora.http.common.HttpResponseEntity;
import ru.tinkoff.kora.http.common.annotation.Header;
import ru.tinkoff.kora.http.common.annotation.HttpRoute;
import ru.tinkoff.kora.http.common.annotation.Query;
import ru.tinkoff.kora.http.common.form.FormUrlEncoded;
import ru.tinkoff.kora.json.common.annotation.Json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@HttpClient(configPath = "oncall")
public interface OncallAuthClient {

    @Json
    @HttpRoute(method = HttpMethod.POST, path = "/login")
    HttpResponseEntity<LoginResponse> login(FormUrlEncoded body);
}
