package org.example.service;

import org.example.client.OncallAuthClient;
import org.example.client.OncallClient;
import org.example.config.OncallUserConfig;
import org.example.dto.LoginResponse;
import org.example.dto.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tinkoff.kora.common.Component;
import ru.tinkoff.kora.http.common.HttpResponseEntity;
import ru.tinkoff.kora.http.common.form.FormUrlEncoded;

@Component
public class OncallService {

    private final OncallAuthClient oncallAuthClient;

    private final OncallClient oncallClient;

    private final OncallUserConfig oncallUserConfig;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Csrf csrf;

    public OncallService(OncallAuthClient oncallAuthClient,
                         OncallClient oncallClient,
                         OncallUserConfig oncallUserConfig) {
        this.oncallAuthClient = oncallAuthClient;
        this.oncallClient = oncallClient;
        this.oncallUserConfig = oncallUserConfig;
    }

    public String login() {
        if (csrf == null) {
            FormUrlEncoded body = new FormUrlEncoded(
                new FormUrlEncoded.FormPart("username", oncallUserConfig.username()),
                new FormUrlEncoded.FormPart("password", oncallUserConfig.password())
            );
            logger.info("login with body {}", body.get("username"));
            logger.info("login with body {}", body.get("password"));
            HttpResponseEntity<LoginResponse> loginResp = oncallAuthClient.login(body);
            if (loginResp.code() != 200) {
                logger.error("error to login {}", loginResp);
            } else {
                logger.error("success login {}", loginResp);
                csrf = new Csrf(loginResp.body().csrfToken());
            }
        }
        return csrf.body();
    }

    public HttpResponseEntity<String> getTeams() {
        String token = login();
        HttpResponseEntity<String> response = oncallClient.getTeams(token);
        if (response.code() > 300) {
            logger.error("teams not found {}", response);
            throw new RuntimeException("teams not found {}");
        }
        return response;
    }

    public HttpResponseEntity<String> createUser(String username) {
        String token = login();
        UserRequest userRequest = new UserRequest(username);
        HttpResponseEntity<String> response = oncallClient.createUser(token, userRequest);
        if (response.code() > 300) {
            throw new RuntimeException("user " + username + " not created");
        }
        return response;
    }

    public HttpResponseEntity<String> deleteUser(String username) {
        String token = login();
        HttpResponseEntity<String> response = oncallClient.deleteUser(token, username);
        if (response.code() > 300) {
            throw new RuntimeException("user " + username + " not deleted");
        }
        return response;
    }

    public HttpResponseEntity<String> getUser(String username) {
        String token = login();
        HttpResponseEntity<String> response = oncallClient.getUser(token, username);
        if (response.code() > 300) {
            throw new RuntimeException("user " + username + " not found");
        }
        return response;
    }
}
