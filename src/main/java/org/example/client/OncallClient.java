package org.example.client;

import org.example.dto.UserRequest;
import ru.tinkoff.kora.common.Component;
import ru.tinkoff.kora.http.client.common.annotation.HttpClient;
import ru.tinkoff.kora.http.client.common.annotation.ResponseCodeMapper;
import ru.tinkoff.kora.http.common.HttpMethod;
import ru.tinkoff.kora.http.common.HttpResponseEntity;
import ru.tinkoff.kora.http.common.annotation.Header;
import ru.tinkoff.kora.http.common.annotation.HttpRoute;
import ru.tinkoff.kora.http.common.annotation.Path;
import ru.tinkoff.kora.http.common.annotation.Query;
import ru.tinkoff.kora.json.common.annotation.Json;

import java.util.List;

@Component
@HttpClient(configPath = "oncall.api")
public interface OncallClient {
    @HttpRoute(method = HttpMethod.GET, path = "/teams")
    HttpResponseEntity<String> getTeams(@Header("X-Csrf-Token") String csrf);

    @HttpRoute(method = HttpMethod.POST, path = "/users")
    HttpResponseEntity<String> createUser(@Header("X-Csrf-Token") String csrf, @Json UserRequest body);

    @HttpRoute(method = HttpMethod.DELETE, path = "/users/{username}")
    HttpResponseEntity<String> deleteUser(@Header("X-Csrf-Token") String csrf, @Path String username);

    @HttpRoute(method = HttpMethod.GET, path = "/users")
    HttpResponseEntity<String> getUser(@Header("X-Csrf-Token") String csrf, @Query("username") String username);
}
