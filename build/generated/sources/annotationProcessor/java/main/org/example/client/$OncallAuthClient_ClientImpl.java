package org.example.client;

import java.lang.Override;
import java.lang.String;
import java.net.URI;
import java.time.Duration;
import java.util.Objects;
import org.example.dto.LoginResponse;
import ru.tinkoff.kora.common.Context;
import ru.tinkoff.kora.common.Tag;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.http.client.common.HttpClient;
import ru.tinkoff.kora.http.client.common.HttpClientEncoderException;
import ru.tinkoff.kora.http.client.common.HttpClientException;
import ru.tinkoff.kora.http.client.common.HttpClientUnknownException;
import ru.tinkoff.kora.http.client.common.request.HttpClientRequest;
import ru.tinkoff.kora.http.client.common.request.HttpClientRequestMapper;
import ru.tinkoff.kora.http.client.common.response.HttpClientResponseMapper;
import ru.tinkoff.kora.http.client.common.telemetry.HttpClientTelemetryFactory;
import ru.tinkoff.kora.http.common.HttpResponseEntity;
import ru.tinkoff.kora.http.common.body.HttpBodyOutput;
import ru.tinkoff.kora.http.common.form.FormUrlEncoded;
import ru.tinkoff.kora.http.common.header.HttpHeaders;

@Generated("ru.tinkoff.kora.http.client.annotation.processor.ClientClassGenerator")
public final class $OncallAuthClient_ClientImpl implements OncallAuthClient {
  private final HttpClientRequestMapper<FormUrlEncoded> loginRequestMapper;

  private final HttpClientResponseMapper<HttpResponseEntity<LoginResponse>> loginResponseMapper;

  private final String rootUrl;

  private final HttpClient loginClient;

  private final Duration loginRequestTimeout;

  private final String loginUriTemplate;

  private final URI loginUri;

  public $OncallAuthClient_ClientImpl(HttpClient httpClient, $OncallAuthClient_Config config,
      HttpClientTelemetryFactory telemetryFactory,
      HttpClientRequestMapper<FormUrlEncoded> loginRequestMapper,
      @Tag({ru.tinkoff.kora.json.common.annotation.Json.class}) HttpClientResponseMapper<HttpResponseEntity<LoginResponse>> loginResponseMapper) {
    this.rootUrl = Objects.requireNonNull(config.url());
    this.loginRequestMapper = loginRequestMapper;
    this.loginResponseMapper = loginResponseMapper;
    var login = config.apply(httpClient, OncallAuthClient.class, "login", config.login(), telemetryFactory, "/login");
    this.loginUriTemplate = login.url();
    this.loginUri = URI.create(login.url());
    this.loginClient = login.client();
    this.loginRequestTimeout = login.requestTimeout();
  }

  @Override
  public HttpResponseEntity<LoginResponse> login(FormUrlEncoded body) throws HttpClientException {
    var _client = this.loginClient;
    var _headers = HttpHeaders.of();
    var _uriTemplate = this.loginUriTemplate;
    var _requestTimeout = this.loginRequestTimeout;
    var _uri = this.loginUri;

    final HttpBodyOutput _body;
    try {
      _body = this.loginRequestMapper.apply(Context.current(), body);
    } catch (Exception _e) {
      throw new HttpClientEncoderException(_e);
    }
    var _request = HttpClientRequest.of("POST", _uri, _uriTemplate, _headers, _body, _requestTimeout);
    try (var _response = _client.execute(_request).toCompletableFuture().get()) {
      return this.loginResponseMapper.apply(_response);
    } catch (java.util.concurrent.ExecutionException e) {
      if (e.getCause() instanceof RuntimeException re) throw re;
      if (e.getCause() instanceof Error er) throw er;
      throw new HttpClientUnknownException(e.getCause());
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new HttpClientUnknownException(e);
    }
  }
}
