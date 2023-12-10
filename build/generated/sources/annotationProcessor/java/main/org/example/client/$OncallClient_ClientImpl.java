package org.example.client;

import java.lang.Override;
import java.lang.String;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Objects;
import org.example.dto.UserRequest;
import ru.tinkoff.kora.common.Context;
import ru.tinkoff.kora.common.Tag;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.http.client.common.HttpClient;
import ru.tinkoff.kora.http.client.common.HttpClientEncoderException;
import ru.tinkoff.kora.http.client.common.HttpClientException;
import ru.tinkoff.kora.http.client.common.HttpClientResponseException;
import ru.tinkoff.kora.http.client.common.HttpClientUnknownException;
import ru.tinkoff.kora.http.client.common.request.HttpClientRequest;
import ru.tinkoff.kora.http.client.common.request.HttpClientRequestMapper;
import ru.tinkoff.kora.http.client.common.request.UriQueryBuilder;
import ru.tinkoff.kora.http.client.common.response.HttpClientResponseMapper;
import ru.tinkoff.kora.http.client.common.telemetry.HttpClientTelemetryFactory;
import ru.tinkoff.kora.http.common.HttpResponseEntity;
import ru.tinkoff.kora.http.common.body.HttpBody;
import ru.tinkoff.kora.http.common.body.HttpBodyOutput;
import ru.tinkoff.kora.http.common.header.HttpHeaders;

@Generated("ru.tinkoff.kora.http.client.annotation.processor.ClientClassGenerator")
public final class $OncallClient_ClientImpl implements OncallClient {
  private final HttpClientResponseMapper<HttpResponseEntity<String>> getTeamsResponseMapper;

  private final HttpClientRequestMapper<UserRequest> createUserRequestMapper;

  private final HttpClientResponseMapper<HttpResponseEntity<String>> createUserResponseMapper;

  private final HttpClientResponseMapper<HttpResponseEntity<String>> deleteUserResponseMapper;

  private final HttpClientResponseMapper<HttpResponseEntity<String>> getUserResponseMapper;

  private final String rootUrl;

  private final HttpClient getTeamsClient;

  private final Duration getTeamsRequestTimeout;

  private final String getTeamsUriTemplate;

  private final URI getTeamsUri;

  private final HttpClient createUserClient;

  private final Duration createUserRequestTimeout;

  private final String createUserUriTemplate;

  private final URI createUserUri;

  private final HttpClient deleteUserClient;

  private final Duration deleteUserRequestTimeout;

  private final String deleteUserUriTemplate;

  private final HttpClient getUserClient;

  private final Duration getUserRequestTimeout;

  private final String getUserUriTemplate;

  public $OncallClient_ClientImpl(HttpClient httpClient, $OncallClient_Config config,
      HttpClientTelemetryFactory telemetryFactory,
      HttpClientResponseMapper<HttpResponseEntity<String>> getTeamsResponseMapper,
      @Tag({ru.tinkoff.kora.json.common.annotation.Json.class}) HttpClientRequestMapper<UserRequest> createUserRequestMapper,
      HttpClientResponseMapper<HttpResponseEntity<String>> createUserResponseMapper,
      HttpClientResponseMapper<HttpResponseEntity<String>> deleteUserResponseMapper,
      HttpClientResponseMapper<HttpResponseEntity<String>> getUserResponseMapper) {
    this.rootUrl = Objects.requireNonNull(config.url());
    this.getTeamsResponseMapper = getTeamsResponseMapper;
    var getTeams = config.apply(httpClient, OncallClient.class, "getTeams", config.getTeams(), telemetryFactory, "/teams");
    this.getTeamsUriTemplate = getTeams.url();
    this.getTeamsUri = URI.create(getTeams.url());
    this.getTeamsClient = getTeams.client();
    this.getTeamsRequestTimeout = getTeams.requestTimeout();
    this.createUserRequestMapper = createUserRequestMapper;
    this.createUserResponseMapper = createUserResponseMapper;
    var createUser = config.apply(httpClient, OncallClient.class, "createUser", config.createUser(), telemetryFactory, "/users");
    this.createUserUriTemplate = createUser.url();
    this.createUserUri = URI.create(createUser.url());
    this.createUserClient = createUser.client();
    this.createUserRequestTimeout = createUser.requestTimeout();
    this.deleteUserResponseMapper = deleteUserResponseMapper;
    var deleteUser = config.apply(httpClient, OncallClient.class, "deleteUser", config.deleteUser(), telemetryFactory, "/users/{username}");
    this.deleteUserUriTemplate = deleteUser.url();
    this.deleteUserClient = deleteUser.client();
    this.deleteUserRequestTimeout = deleteUser.requestTimeout();
    this.getUserResponseMapper = getUserResponseMapper;
    var getUser = config.apply(httpClient, OncallClient.class, "getUser", config.getUser(), telemetryFactory, "/users");
    this.getUserUriTemplate = getUser.url();
    this.getUserClient = getUser.client();
    this.getUserRequestTimeout = getUser.requestTimeout();
  }

  @Override
  public HttpResponseEntity<String> getTeams(String csrf) throws HttpClientException {
    var _client = this.getTeamsClient;
    var _headers = HttpHeaders.of();
    var _uriTemplate = this.getTeamsUriTemplate;
    var _requestTimeout = this.getTeamsRequestTimeout;
    var _uri = this.getTeamsUri;

    _headers.add("X-Csrf-Token", Objects.toString(csrf));
    var _body = HttpBody.empty();
    var _request = HttpClientRequest.of("GET", _uri, _uriTemplate, _headers, _body, _requestTimeout);
    try (var _response = _client.execute(_request).toCompletableFuture().get()) {
      var _code = _response.code();
      if (_code >= 200 && _code < 300) {
        return this.getTeamsResponseMapper.apply(_response);
      } else {
        throw HttpClientResponseException.fromResponseFuture(_response).get();
      }
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

  @Override
  public HttpResponseEntity<String> createUser(String csrf, UserRequest body) throws
      HttpClientException {
    var _client = this.createUserClient;
    var _headers = HttpHeaders.of();
    var _uriTemplate = this.createUserUriTemplate;
    var _requestTimeout = this.createUserRequestTimeout;
    var _uri = this.createUserUri;

    _headers.add("X-Csrf-Token", Objects.toString(csrf));
    final HttpBodyOutput _body;
    try {
      _body = this.createUserRequestMapper.apply(Context.current(), body);
    } catch (Exception _e) {
      throw new HttpClientEncoderException(_e);
    }
    var _request = HttpClientRequest.of("POST", _uri, _uriTemplate, _headers, _body, _requestTimeout);
    try (var _response = _client.execute(_request).toCompletableFuture().get()) {
      var _code = _response.code();
      if (_code >= 200 && _code < 300) {
        return this.createUserResponseMapper.apply(_response);
      } else {
        throw HttpClientResponseException.fromResponseFuture(_response).get();
      }
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

  @Override
  public HttpResponseEntity<String> deleteUser(String csrf, String username) throws
      HttpClientException {
    var _client = this.deleteUserClient;
    var _headers = HttpHeaders.of();
    var _uriTemplate = this.deleteUserUriTemplate;
    var _requestTimeout = this.deleteUserRequestTimeout;
    var _uriNoQuery = this.rootUrl
      + "/users/"
      + URLEncoder.encode(Objects.toString(username), StandardCharsets.UTF_8)
    ;
    var _uri = URI.create(_uriNoQuery);

    _headers.add("X-Csrf-Token", Objects.toString(csrf));
    var _body = HttpBody.empty();
    var _request = HttpClientRequest.of("DELETE", _uri, _uriTemplate, _headers, _body, _requestTimeout);
    try (var _response = _client.execute(_request).toCompletableFuture().get()) {
      var _code = _response.code();
      if (_code >= 200 && _code < 300) {
        return this.deleteUserResponseMapper.apply(_response);
      } else {
        throw HttpClientResponseException.fromResponseFuture(_response).get();
      }
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

  @Override
  public HttpResponseEntity<String> getUser(String csrf, String username) throws
      HttpClientException {
    var _client = this.getUserClient;
    var _headers = HttpHeaders.of();
    var _uriTemplate = this.getUserUriTemplate;
    var _requestTimeout = this.getUserRequestTimeout;
    var _uriNoQuery = this.rootUrl + "/users";
    var _query = new UriQueryBuilder(true, false);
    _query.unsafeAdd("username", URLEncoder.encode(Objects.toString(username), StandardCharsets.UTF_8));
    var _uri = URI.create(_uriNoQuery + _query.build());

    _headers.add("X-Csrf-Token", Objects.toString(csrf));
    var _body = HttpBody.empty();
    var _request = HttpClientRequest.of("GET", _uri, _uriTemplate, _headers, _body, _requestTimeout);
    try (var _response = _client.execute(_request).toCompletableFuture().get()) {
      var _code = _response.code();
      if (_code >= 200 && _code < 300) {
        return this.getUserResponseMapper.apply(_response);
      } else {
        throw HttpClientResponseException.fromResponseFuture(_response).get();
      }
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
