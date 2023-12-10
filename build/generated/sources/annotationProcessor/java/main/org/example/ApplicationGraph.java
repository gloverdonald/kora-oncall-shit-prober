package org.example;

import io.netty.channel.EventLoopGroup;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadFactory;
import java.util.function.Supplier;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.example.client.$$OncallAuthClient_Config_ConfigValueExtractor;
import org.example.client.$$OncallClient_Config_ConfigValueExtractor;
import org.example.client.$OncallAuthClient_ClientImpl;
import org.example.client.$OncallAuthClient_Config;
import org.example.client.$OncallClient_ClientImpl;
import org.example.client.$OncallClient_Config;
import org.example.config.$OncallUserConfig_ConfigValueExtractor;
import org.example.config.OncallUserConfig;
import org.example.controller.TestController;
import org.example.dto.$LoginResponse_JsonReader;
import org.example.dto.$UserRequest_JsonWriter;
import org.example.dto.LoginResponse;
import org.example.dto.UserRequest;
import org.example.scheduled.OncallProber;
import org.example.service.OncallService;
import org.xnio.XnioWorker;
import ru.tinkoff.kora.application.graph.All;
import ru.tinkoff.kora.application.graph.ApplicationGraphDraw;
import ru.tinkoff.kora.application.graph.LifecycleWrapper;
import ru.tinkoff.kora.application.graph.Node;
import ru.tinkoff.kora.application.graph.ValueOf;
import ru.tinkoff.kora.application.graph.Wrapped;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.common.readiness.ReadinessProbe;
import ru.tinkoff.kora.config.common.Config;
import ru.tinkoff.kora.config.common.ConfigWatcher;
import ru.tinkoff.kora.config.common.extractor.ConfigValueExtractor;
import ru.tinkoff.kora.config.common.origin.ConfigOrigin;
import ru.tinkoff.kora.http.client.common.$HttpClientConfig_ConfigValueExtractor;
import ru.tinkoff.kora.http.client.common.$HttpClientConfig_HttpClientProxyConfig_ConfigValueExtractor;
import ru.tinkoff.kora.http.client.common.HttpClientConfig;
import ru.tinkoff.kora.http.client.common.declarative.$HttpClientOperationConfig_ConfigValueExtractor;
import ru.tinkoff.kora.http.client.common.form.FormUrlEncodedClientRequestMapper;
import ru.tinkoff.kora.http.client.common.response.HttpClientResponseMapper;
import ru.tinkoff.kora.http.client.common.telemetry.DefaultHttpClientTelemetryFactory;
import ru.tinkoff.kora.http.client.common.telemetry.HttpClientTracerFactory;
import ru.tinkoff.kora.http.client.common.telemetry.Sl4fjHttpClientLoggerFactory;
import ru.tinkoff.kora.http.common.HttpResponseEntity;
import ru.tinkoff.kora.http.server.common.$HttpServerConfig_ConfigValueExtractor;
import ru.tinkoff.kora.http.server.common.HttpServerConfig;
import ru.tinkoff.kora.http.server.common.PrivateApiHandler;
import ru.tinkoff.kora.http.server.common.handler.BlockingRequestExecutor;
import ru.tinkoff.kora.http.server.common.handler.HttpServerRequestHandler;
import ru.tinkoff.kora.http.server.common.handler.HttpServerResponseMapper;
import ru.tinkoff.kora.http.server.common.router.PublicApiHandler;
import ru.tinkoff.kora.http.server.common.telemetry.$HttpServerLoggerConfig_ConfigValueExtractor;
import ru.tinkoff.kora.http.server.common.telemetry.$HttpServerTelemetryConfig_ConfigValueExtractor;
import ru.tinkoff.kora.http.server.common.telemetry.DefaultHttpServerTelemetryFactory;
import ru.tinkoff.kora.http.server.common.telemetry.HttpServerTracerFactory;
import ru.tinkoff.kora.http.server.common.telemetry.PrivateApiMetrics;
import ru.tinkoff.kora.http.server.common.telemetry.Slf4jHttpServerLoggerFactory;
import ru.tinkoff.kora.http.server.undertow.UndertowHttpServer;
import ru.tinkoff.kora.http.server.undertow.UndertowPrivateApiHandler;
import ru.tinkoff.kora.http.server.undertow.UndertowPrivateHttpServer;
import ru.tinkoff.kora.http.server.undertow.UndertowPublicApiHandler;
import ru.tinkoff.kora.json.module.http.client.JsonHttpClientRequestMapper;
import ru.tinkoff.kora.json.module.http.client.JsonReaderHttpClientResponseEntityMapper;
import ru.tinkoff.kora.micrometer.module.PrometheusMeterRegistryWrapper;
import ru.tinkoff.kora.micrometer.module.http.client.MicrometerHttpClientMetricsFactory;
import ru.tinkoff.kora.micrometer.module.http.server.MicrometerHttpServerMetricsFactory;
import ru.tinkoff.kora.micrometer.module.http.server.MicrometerPrivateApiMetrics;
import ru.tinkoff.kora.micrometer.module.http.server.tag.MicrometerHttpServerTagsProvider;
import ru.tinkoff.kora.micrometer.module.scheduling.MicrometerSchedulingMetricsFactory;
import ru.tinkoff.kora.scheduling.common.telemetry.DefaultSchedulingTelemetryFactory;
import ru.tinkoff.kora.scheduling.common.telemetry.SchedulingLoggerFactory;
import ru.tinkoff.kora.scheduling.common.telemetry.SchedulingTracerFactory;
import ru.tinkoff.kora.scheduling.jdk.$ScheduledExecutorServiceConfig_ConfigValueExtractor;
import ru.tinkoff.kora.scheduling.jdk.FixedRateJob;
import ru.tinkoff.kora.scheduling.jdk.JdkSchedulingExecutor;
import ru.tinkoff.kora.scheduling.jdk.ScheduledExecutorServiceConfig;
import ru.tinkoff.kora.telemetry.common.$TelemetryConfig_ConfigValueExtractor;
import ru.tinkoff.kora.telemetry.common.$TelemetryConfig_LogConfig_ConfigValueExtractor;
import ru.tinkoff.kora.telemetry.common.$TelemetryConfig_MetricsConfig_ConfigValueExtractor;
import ru.tinkoff.kora.telemetry.common.$TelemetryConfig_TracingConfig_ConfigValueExtractor;
import ru.tinkoff.kora.telemetry.common.TelemetryConfig;

@Generated("ru.tinkoff.kora.kora.app.annotation.processor.KoraAppProcessor")
public class ApplicationGraph implements Supplier<ApplicationGraphDraw> {
  private static final ApplicationGraphDraw graphDraw;

  private static final ComponentHolder0 holder0;

  static {
    var impl = new ApplicationImpl();
    graphDraw = new ApplicationGraphDraw(Application.class);
    holder0 = new ComponentHolder0(graphDraw, impl);
  }

  @Override
  public ApplicationGraphDraw get() {
    return graphDraw;
  }

  public static ApplicationGraphDraw graph() {
    return graphDraw;
  }

  public static final class ComponentHolder0 {
    private final Node<ConfigOrigin> component0;

    private final Node<Optional<ValueOf<ConfigOrigin>>> component1;

    private final Node<ConfigWatcher> component2;

    private final Node<Config> component3;

    private final Node<Config> component4;

    private final Node<com.typesafe.config.Config> component5;

    private final Node<com.typesafe.config.Config> component6;

    private final Node<Config> component7;

    private final Node<Config> component8;

    private final Node<ConfigValueExtractor<Boolean>> component9;

    private final Node<ConfigValueExtractor<Duration>> component10;

    private final Node<$HttpServerLoggerConfig_ConfigValueExtractor> component11;

    private final Node<$TelemetryConfig_TracingConfig_ConfigValueExtractor> component12;

    private final Node<ConfigValueExtractor<Double>> component13;

    private final Node<ConfigValueExtractor<double[]>> component14;

    private final Node<$TelemetryConfig_MetricsConfig_ConfigValueExtractor> component15;

    private final Node<$HttpServerTelemetryConfig_ConfigValueExtractor> component16;

    private final Node<$HttpServerConfig_ConfigValueExtractor> component17;

    private final Node<HttpServerConfig> component18;

    private final Node<LifecycleWrapper<EventLoopGroup>> component19;

    private final Node<ConfigValueExtractor<String>> component20;

    private final Node<ConfigValueExtractor<List<String>>> component21;

    private final Node<$HttpClientConfig_HttpClientProxyConfig_ConfigValueExtractor> component22;

    private final Node<$HttpClientConfig_ConfigValueExtractor> component23;

    private final Node<HttpClientConfig> component24;

    private final Node<AsyncHttpClientConfig> component25;

    private final Node<AsyncHttpClient> component26;

    private final Node<ru.tinkoff.kora.http.client.async.AsyncHttpClient> component27;

    private final Node<$TelemetryConfig_LogConfig_ConfigValueExtractor> component28;

    private final Node<$TelemetryConfig_ConfigValueExtractor> component29;

    private final Node<$HttpClientOperationConfig_ConfigValueExtractor> component30;

    private final Node<$$OncallAuthClient_Config_ConfigValueExtractor> component31;

    private final Node<$OncallAuthClient_Config> component32;

    private final Node<Sl4fjHttpClientLoggerFactory> component33;

    private final Node<PrometheusMeterRegistryWrapper> component34;

    private final Node<MicrometerHttpClientMetricsFactory> component35;

    private final Node<DefaultHttpClientTelemetryFactory> component36;

    private final Node<FormUrlEncodedClientRequestMapper> component37;

    private final Node<$LoginResponse_JsonReader> component38;

    private final Node<JsonReaderHttpClientResponseEntityMapper<LoginResponse>> component39;

    private final Node<$OncallAuthClient_ClientImpl> component40;

    private final Node<$$OncallClient_Config_ConfigValueExtractor> component41;

    private final Node<$OncallClient_Config> component42;

    private final Node<HttpClientResponseMapper<String>> component43;

    private final Node<HttpClientResponseMapper<HttpResponseEntity<String>>> component44;

    private final Node<$UserRequest_JsonWriter> component45;

    private final Node<JsonHttpClientRequestMapper<UserRequest>> component46;

    private final Node<$OncallClient_ClientImpl> component47;

    private final Node<$OncallUserConfig_ConfigValueExtractor> component48;

    private final Node<OncallUserConfig> component49;

    private final Node<OncallService> component50;

    private final Node<TestController> component51;

    private final Node<HttpServerResponseMapper<String>> component52;

    private final Node<Wrapped<XnioWorker>> component53;

    private final Node<BlockingRequestExecutor> component54;

    private final Node<HttpServerRequestHandler> component55;

    private final Node<Slf4jHttpServerLoggerFactory> component56;

    private final Node<MicrometerHttpServerTagsProvider> component57;

    private final Node<MicrometerHttpServerMetricsFactory> component58;

    private final Node<DefaultHttpServerTelemetryFactory> component59;

    private final Node<PublicApiHandler> component60;

    private final Node<UndertowPublicApiHandler> component61;

    private final Node<UndertowHttpServer> component62;

    private final Node<MicrometerPrivateApiMetrics> component63;

    private final Node<Optional<PrivateApiMetrics>> component64;

    private final Node<PrivateApiHandler> component65;

    private final Node<UndertowPrivateApiHandler> component66;

    private final Node<UndertowPrivateHttpServer> component67;

    private final Node<TelemetryConfig> component68;

    private final Node<MicrometerSchedulingMetricsFactory> component69;

    private final Node<DefaultSchedulingTelemetryFactory> component70;

    private final Node<$ScheduledExecutorServiceConfig_ConfigValueExtractor> component71;

    private final Node<ScheduledExecutorServiceConfig> component72;

    private final Node<JdkSchedulingExecutor> component73;

    private final Node<OncallProber> component74;

    private final Node<FixedRateJob> component75;

    private final Node<FixedRateJob> component76;

    private final Node<FixedRateJob> component77;

    public ComponentHolder0(ApplicationGraphDraw graphDraw, ApplicationImpl impl) {
      var map = new HashMap<String, Type>();
      for (var field : ComponentHolder0.class.getDeclaredFields()) {
        if (!field.getName().startsWith("component")) continue;
        map.put(field.getName(), ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
      }
      var _type_of_component0 = map.get("component0");
      component0 = graphDraw.addNode0(_type_of_component0, new Class<?>[]{ru.tinkoff.kora.config.common.annotation.ApplicationConfig.class, }, g -> impl.applicationConfigOrigin(), List.of());
      var _type_of_component1 = map.get("component1");
      component1 = graphDraw.addNode0(_type_of_component1, new Class<?>[]{ru.tinkoff.kora.config.common.annotation.ApplicationConfig.class, }, g -> Optional.<ValueOf<ConfigOrigin>>ofNullable(
            g.valueOf(ApplicationGraph.holder0.component0).map(v -> (ConfigOrigin) v)
          ), List.of(), component0.valueOf());
      var _type_of_component2 = map.get("component2");
      component2 = graphDraw.addNode0(_type_of_component2, new Class<?>[]{}, g -> impl.configRefresher(
            g.get(ApplicationGraph.holder0.component1)
          ), List.of(), component1);
      var _type_of_component3 = map.get("component3");
      component3 = graphDraw.addNode0(_type_of_component3, new Class<?>[]{ru.tinkoff.kora.config.common.annotation.Environment.class, }, g -> impl.environmentConfig(), List.of());
      var _type_of_component4 = map.get("component4");
      component4 = graphDraw.addNode0(_type_of_component4, new Class<?>[]{ru.tinkoff.kora.config.common.annotation.SystemProperties.class, }, g -> impl.systemProperties(), List.of());
      var _type_of_component5 = map.get("component5");
      component5 = graphDraw.addNode0(_type_of_component5, new Class<?>[]{ru.tinkoff.kora.config.common.annotation.ApplicationConfig.class, }, g -> impl.applicationUnresolved(
            g.get(ApplicationGraph.holder0.component0)
          ), List.of(), component0);
      var _type_of_component6 = map.get("component6");
      component6 = graphDraw.addNode0(_type_of_component6, new Class<?>[]{}, g -> impl.hoconConfig(
            g.get(ApplicationGraph.holder0.component5)
          ), List.of(), component5);
      var _type_of_component7 = map.get("component7");
      component7 = graphDraw.addNode0(_type_of_component7, new Class<?>[]{ru.tinkoff.kora.config.common.annotation.ApplicationConfig.class, }, g -> impl.config(
            g.get(ApplicationGraph.holder0.component0),
            g.get(ApplicationGraph.holder0.component6)
          ), List.of(), component0, component6);
      var _type_of_component8 = map.get("component8");
      component8 = graphDraw.addNode0(_type_of_component8, new Class<?>[]{}, g -> impl.config(
            g.get(ApplicationGraph.holder0.component3),
            g.get(ApplicationGraph.holder0.component4),
            g.get(ApplicationGraph.holder0.component7)
          ), List.of(), component3, component4, component7);
      var _type_of_component9 = map.get("component9");
      component9 = graphDraw.addNode0(_type_of_component9, new Class<?>[]{}, g -> impl.booleanConfigValueExtractor(), List.of());
      var _type_of_component10 = map.get("component10");
      component10 = graphDraw.addNode0(_type_of_component10, new Class<?>[]{}, g -> impl.durationConfigValueExtractor(), List.of());
      var _type_of_component11 = map.get("component11");
      component11 = graphDraw.addNode0(_type_of_component11, new Class<?>[]{}, g -> new $HttpServerLoggerConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component9)
          ), List.of(), component9);
      var _type_of_component12 = map.get("component12");
      component12 = graphDraw.addNode0(_type_of_component12, new Class<?>[]{}, g -> new $TelemetryConfig_TracingConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component9)
          ), List.of(), component9);
      var _type_of_component13 = map.get("component13");
      component13 = graphDraw.addNode0(_type_of_component13, new Class<?>[]{}, g -> impl.doubleConfigValueExtractor(), List.of());
      var _type_of_component14 = map.get("component14");
      component14 = graphDraw.addNode0(_type_of_component14, new Class<?>[]{}, g -> impl.doubleArrayConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component13)
          ), List.of(), component13);
      var _type_of_component15 = map.get("component15");
      component15 = graphDraw.addNode0(_type_of_component15, new Class<?>[]{}, g -> new $TelemetryConfig_MetricsConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component9),
            g.get(ApplicationGraph.holder0.component14)
          ), List.of(), component9, component14);
      var _type_of_component16 = map.get("component16");
      component16 = graphDraw.addNode0(_type_of_component16, new Class<?>[]{}, g -> new $HttpServerTelemetryConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component11),
            g.get(ApplicationGraph.holder0.component12),
            g.get(ApplicationGraph.holder0.component15)
          ), List.of(), component11, component12, component15);
      var _type_of_component17 = map.get("component17");
      component17 = graphDraw.addNode0(_type_of_component17, new Class<?>[]{}, g -> new $HttpServerConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component9),
            g.get(ApplicationGraph.holder0.component10),
            g.get(ApplicationGraph.holder0.component16)
          ), List.of(), component9, component10, component16);
      var _type_of_component18 = map.get("component18");
      component18 = graphDraw.addNode0(_type_of_component18, new Class<?>[]{}, g -> impl.httpServerConfig(
            g.get(ApplicationGraph.holder0.component8),
            g.get(ApplicationGraph.holder0.component17)
          ), List.of(), component8, component17);
      var _type_of_component19 = map.get("component19");
      component19 = graphDraw.addNode0(_type_of_component19, new Class<?>[]{ru.tinkoff.kora.netty.common.NettyCommonModule.WorkerLoopGroup.class, }, g -> impl.nettyEventLoopGroupLifecycle(
            (ThreadFactory) null,
            (Integer) null
          ), List.of());
      var _type_of_component20 = map.get("component20");
      component20 = graphDraw.addNode0(_type_of_component20, new Class<?>[]{}, g -> impl.stringConfigValueExtractor(), List.of());
      var _type_of_component21 = map.get("component21");
      component21 = graphDraw.addNode0(_type_of_component21, new Class<?>[]{}, g -> impl.<String>listConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component20)
          ), List.of(), component20);
      var _type_of_component22 = map.get("component22");
      component22 = graphDraw.addNode0(_type_of_component22, new Class<?>[]{}, g -> new $HttpClientConfig_HttpClientProxyConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component21)
          ), List.of(), component21);
      var _type_of_component23 = map.get("component23");
      component23 = graphDraw.addNode0(_type_of_component23, new Class<?>[]{}, g -> new $HttpClientConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component10),
            g.get(ApplicationGraph.holder0.component22),
            g.get(ApplicationGraph.holder0.component9)
          ), List.of(), component10, component22, component9);
      var _type_of_component24 = map.get("component24");
      component24 = graphDraw.addNode0(_type_of_component24, new Class<?>[]{}, g -> impl.httpClientConfig(
            g.get(ApplicationGraph.holder0.component8),
            g.get(ApplicationGraph.holder0.component23)
          ), List.of(), component8, component23);
      var _type_of_component25 = map.get("component25");
      component25 = graphDraw.addNode0(_type_of_component25, new Class<?>[]{}, g -> impl.nettyClientConfig(
            g.get(ApplicationGraph.holder0.component19).value(),
            g.get(ApplicationGraph.holder0.component24)
          ), List.of(), component19, component24);
      var _type_of_component26 = map.get("component26");
      component26 = graphDraw.addNode0(_type_of_component26, new Class<?>[]{}, g -> impl.nettyAsyncHttpClient(
            g.get(ApplicationGraph.holder0.component25)
          ), List.of(), component25);
      var _type_of_component27 = map.get("component27");
      component27 = graphDraw.addNode0(_type_of_component27, new Class<?>[]{}, g -> impl.asyncHttpClient(
            g.get(ApplicationGraph.holder0.component26)
          ), List.of(), component26);
      var _type_of_component28 = map.get("component28");
      component28 = graphDraw.addNode0(_type_of_component28, new Class<?>[]{}, g -> new $TelemetryConfig_LogConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component9)
          ), List.of(), component9);
      var _type_of_component29 = map.get("component29");
      component29 = graphDraw.addNode0(_type_of_component29, new Class<?>[]{}, g -> new $TelemetryConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component28),
            g.get(ApplicationGraph.holder0.component12),
            g.get(ApplicationGraph.holder0.component15)
          ), List.of(), component28, component12, component15);
      var _type_of_component30 = map.get("component30");
      component30 = graphDraw.addNode0(_type_of_component30, new Class<?>[]{}, g -> new $HttpClientOperationConfig_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component10),
            g.get(ApplicationGraph.holder0.component29)
          ), List.of(), component10, component29);
      var _type_of_component31 = map.get("component31");
      component31 = graphDraw.addNode0(_type_of_component31, new Class<?>[]{}, g -> new $$OncallAuthClient_Config_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component30),
            g.get(ApplicationGraph.holder0.component29),
            g.get(ApplicationGraph.holder0.component10)
          ), List.of(), component30, component29, component10);
      var _type_of_component32 = map.get("component32");
      component32 = graphDraw.addNode0(_type_of_component32, new Class<?>[]{}, g -> impl.module0.oncallAuthClientConfig(
            g.get(ApplicationGraph.holder0.component8),
            g.get(ApplicationGraph.holder0.component31)
          ), List.of(), component8, component31);
      var _type_of_component33 = map.get("component33");
      component33 = graphDraw.addNode0(_type_of_component33, new Class<?>[]{}, g -> impl.sl4fjHttpClientLoggerFactory(), List.of());
      var _type_of_component34 = map.get("component34");
      component34 = graphDraw.addNode0(_type_of_component34, new Class<?>[]{}, g -> impl.prometheusMeterRegistry(
            All.of(  )
          ), List.of());
      var _type_of_component35 = map.get("component35");
      component35 = graphDraw.addNode0(_type_of_component35, new Class<?>[]{}, g -> impl.micrometerHttpClientMetricsFactory(
            g.get(ApplicationGraph.holder0.component34).value()
          ), List.of(), component34);
      var _type_of_component36 = map.get("component36");
      component36 = graphDraw.addNode0(_type_of_component36, new Class<?>[]{}, g -> impl.defaultHttpClientTelemetryFactory(
            g.get(ApplicationGraph.holder0.component33),
            (HttpClientTracerFactory) null,
            g.get(ApplicationGraph.holder0.component35)
          ), List.of(), component33, component35);
      var _type_of_component37 = map.get("component37");
      component37 = graphDraw.addNode0(_type_of_component37, new Class<?>[]{}, g -> impl.formUrlEncodedClientRequestMapper(), List.of());
      var _type_of_component38 = map.get("component38");
      component38 = graphDraw.addNode0(_type_of_component38, new Class<?>[]{}, g -> new $LoginResponse_JsonReader(), List.of());
      var _type_of_component39 = map.get("component39");
      component39 = graphDraw.addNode0(_type_of_component39, new Class<?>[]{ru.tinkoff.kora.json.common.annotation.Json.class, }, g -> impl.<LoginResponse>jsonReaderHttpClientResponseEntityMapper(
            g.get(ApplicationGraph.holder0.component38)
          ), List.of(), component38);
      var _type_of_component40 = map.get("component40");
      component40 = graphDraw.addNode0(_type_of_component40, new Class<?>[]{}, g -> new $OncallAuthClient_ClientImpl(
            g.get(ApplicationGraph.holder0.component27),
            g.get(ApplicationGraph.holder0.component32),
            g.get(ApplicationGraph.holder0.component36),
            g.get(ApplicationGraph.holder0.component37),
            g.get(ApplicationGraph.holder0.component39)
          ), List.of(), component27, component32, component36, component37, component39);
      var _type_of_component41 = map.get("component41");
      component41 = graphDraw.addNode0(_type_of_component41, new Class<?>[]{}, g -> new $$OncallClient_Config_ConfigValueExtractor(
            g.get(ApplicationGraph.holder0.component30),
            g.get(ApplicationGraph.holder0.component29),
            g.get(ApplicationGraph.holder0.component10)
          ), List.of(), component30, component29, component10);
      var _type_of_component42 = map.get("component42");
      component42 = graphDraw.addNode0(_type_of_component42, new Class<?>[]{}, g -> impl.module1.oncallClientConfig(
            g.get(ApplicationGraph.holder0.component8),
            g.get(ApplicationGraph.holder0.component41)
          ), List.of(), component8, component41);
      var _type_of_component43 = map.get("component43");
      component43 = graphDraw.addNode0(_type_of_component43, new Class<?>[]{}, g -> impl.stringHttpClientResponseMapper(), List.of());
      var _type_of_component44 = map.get("component44");
      component44 = graphDraw.addNode0(_type_of_component44, new Class<?>[]{}, g -> impl.<String>entityResponseHttpClientResponseMapper(
            g.get(ApplicationGraph.holder0.component43)
          ), List.of(), component43);
      var _type_of_component45 = map.get("component45");
      component45 = graphDraw.addNode0(_type_of_component45, new Class<?>[]{}, g -> new $UserRequest_JsonWriter(), List.of());
      var _type_of_component46 = map.get("component46");
      component46 = graphDraw.addNode0(_type_of_component46, new Class<?>[]{ru.tinkoff.kora.json.common.annotation.Json.class, }, g -> impl.<UserRequest>jsonHttpClientRequestMapper(
            g.get(ApplicationGraph.holder0.component45)
          ), List.of(), component45);
      var _type_of_component47 = map.get("component47");
      component47 = graphDraw.addNode0(_type_of_component47, new Class<?>[]{}, g -> new $OncallClient_ClientImpl(
            g.get(ApplicationGraph.holder0.component27),
            g.get(ApplicationGraph.holder0.component42),
            g.get(ApplicationGraph.holder0.component36),
            g.get(ApplicationGraph.holder0.component44),
            g.get(ApplicationGraph.holder0.component46),
            g.get(ApplicationGraph.holder0.component44),
            g.get(ApplicationGraph.holder0.component44),
            g.get(ApplicationGraph.holder0.component44)
          ), List.of(), component27, component42, component36, component44, component46, component44, component44, component44);
      var _type_of_component48 = map.get("component48");
      component48 = graphDraw.addNode0(_type_of_component48, new Class<?>[]{}, g -> new $OncallUserConfig_ConfigValueExtractor(), List.of());
      var _type_of_component49 = map.get("component49");
      component49 = graphDraw.addNode0(_type_of_component49, new Class<?>[]{}, g -> impl.module2.oncallUserConfig(
            g.get(ApplicationGraph.holder0.component8),
            g.get(ApplicationGraph.holder0.component48)
          ), List.of(), component8, component48);
      var _type_of_component50 = map.get("component50");
      component50 = graphDraw.addNode0(_type_of_component50, new Class<?>[]{}, g -> new OncallService(
            g.get(ApplicationGraph.holder0.component40),
            g.get(ApplicationGraph.holder0.component47),
            g.get(ApplicationGraph.holder0.component49)
          ), List.of(), component40, component47, component49);
      var _type_of_component51 = map.get("component51");
      component51 = graphDraw.addNode0(_type_of_component51, new Class<?>[]{}, g -> new TestController(
            g.get(ApplicationGraph.holder0.component50)
          ), List.of(), component50);
      var _type_of_component52 = map.get("component52");
      component52 = graphDraw.addNode0(_type_of_component52, new Class<?>[]{}, g -> impl.stringResponseMapper(), List.of());
      var _type_of_component53 = map.get("component53");
      component53 = graphDraw.addNode0(_type_of_component53, new Class<?>[]{}, g -> impl.xnioWorker(
            g.valueOf(ApplicationGraph.holder0.component18).map(v -> (HttpServerConfig) v)
          ), List.of(), component18.valueOf());
      var _type_of_component54 = map.get("component54");
      component54 = graphDraw.addNode0(_type_of_component54, new Class<?>[]{}, g -> impl.undertowBlockingRequestExecutor(
            g.get(ApplicationGraph.holder0.component53).value()
          ), List.of(), component53);
      var _type_of_component55 = map.get("component55");
      component55 = graphDraw.addNode0(_type_of_component55, new Class<?>[]{}, g -> impl.module3.get_test(
            g.get(ApplicationGraph.holder0.component51),
            g.get(ApplicationGraph.holder0.component52),
            g.get(ApplicationGraph.holder0.component54)
          ), List.of(), component51, component52, component54);
      var _type_of_component56 = map.get("component56");
      component56 = graphDraw.addNode0(_type_of_component56, new Class<?>[]{}, g -> impl.slf4jHttpServerLoggerFactory(), List.of());
      var _type_of_component57 = map.get("component57");
      component57 = graphDraw.addNode0(_type_of_component57, new Class<?>[]{}, g -> impl.micrometerHttpServerTagsProvider(), List.of());
      var _type_of_component58 = map.get("component58");
      component58 = graphDraw.addNode0(_type_of_component58, new Class<?>[]{}, g -> impl.micrometerHttpServerMetricsFactory(
            g.get(ApplicationGraph.holder0.component34).value(),
            g.get(ApplicationGraph.holder0.component57)
          ), List.of(), component34, component57);
      var _type_of_component59 = map.get("component59");
      component59 = graphDraw.addNode0(_type_of_component59, new Class<?>[]{}, g -> impl.defaultHttpServerTelemetryFactory(
            g.get(ApplicationGraph.holder0.component56),
            g.get(ApplicationGraph.holder0.component58),
            (HttpServerTracerFactory) null
          ), List.of(), component56, component58);
      var _type_of_component60 = map.get("component60");
      component60 = graphDraw.addNode0(_type_of_component60, new Class<?>[]{}, g -> impl.publicApiHandler(
            All.of(
              g.get(ApplicationGraph.holder0.component55)
              ),
            All.of(  ),
            g.get(ApplicationGraph.holder0.component59),
            g.get(ApplicationGraph.holder0.component18)
          ), List.of(), component55, component59, component18);
      var _type_of_component61 = map.get("component61");
      component61 = graphDraw.addNode0(_type_of_component61, new Class<?>[]{}, g -> impl.undertowPublicApiHandler(
            g.get(ApplicationGraph.holder0.component60),
            (HttpServerTracerFactory) null,
            g.get(ApplicationGraph.holder0.component18)
          ), List.of(), component60, component18);
      var _type_of_component62 = map.get("component62");
      component62 = graphDraw.addNode0(_type_of_component62, new Class<?>[]{}, g -> impl.undertowHttpServer(
            g.valueOf(ApplicationGraph.holder0.component18).map(v -> (HttpServerConfig) v),
            g.valueOf(ApplicationGraph.holder0.component61).map(v -> (UndertowPublicApiHandler) v),
            g.get(ApplicationGraph.holder0.component53).value()
          ), List.of(), component18.valueOf(), component61.valueOf(), component53);
      var _type_of_component63 = map.get("component63");
      component63 = graphDraw.addNode0(_type_of_component63, new Class<?>[]{}, g -> impl.micrometerPrivateApiMetrics(
            g.get(ApplicationGraph.holder0.component34).value()
          ), List.of(), component34);
      var _type_of_component64 = map.get("component64");
      component64 = graphDraw.addNode0(_type_of_component64, new Class<?>[]{}, g -> Optional.<PrivateApiMetrics>ofNullable(
            g.get(ApplicationGraph.holder0.component63)
          ), List.of(), component63);
      var _type_of_component65 = map.get("component65");
      component65 = graphDraw.addNode0(_type_of_component65, new Class<?>[]{}, g -> impl.privateApiHandler(
            g.valueOf(ApplicationGraph.holder0.component18).map(v -> (HttpServerConfig) v),
            g.valueOf(ApplicationGraph.holder0.component64).map(v -> (Optional<PrivateApiMetrics>) v),
            All.of(
              g.promiseOf(ApplicationGraph.holder0.component62).map(v -> (ReadinessProbe) v)
              ),
            All.of(  )
          ), List.of(), component18.valueOf(), component64.valueOf());
      var _type_of_component66 = map.get("component66");
      component66 = graphDraw.addNode0(_type_of_component66, new Class<?>[]{}, g -> impl.undertowPrivateApiHandler(
            g.get(ApplicationGraph.holder0.component65)
          ), List.of(), component65);
      var _type_of_component67 = map.get("component67");
      component67 = graphDraw.addNode0(_type_of_component67, new Class<?>[]{}, g -> impl.undertowPrivateHttpServer(
            g.valueOf(ApplicationGraph.holder0.component18).map(v -> (HttpServerConfig) v),
            g.valueOf(ApplicationGraph.holder0.component66).map(v -> (UndertowPrivateApiHandler) v),
            g.get(ApplicationGraph.holder0.component53).value()
          ), List.of(), component18.valueOf(), component66.valueOf(), component53);
      var _type_of_component68 = map.get("component68");
      component68 = graphDraw.addNode0(_type_of_component68, new Class<?>[]{ru.tinkoff.kora.scheduling.common.SchedulingModule.class, }, g -> impl.defaultSchedulingConfig(
            g.get(ApplicationGraph.holder0.component8),
            g.get(ApplicationGraph.holder0.component29)
          ), List.of(), component8, component29);
      var _type_of_component69 = map.get("component69");
      component69 = graphDraw.addNode0(_type_of_component69, new Class<?>[]{}, g -> impl.micrometerSchedulingMetricsFactory(
            g.get(ApplicationGraph.holder0.component34).value()
          ), List.of(), component34);
      var _type_of_component70 = map.get("component70");
      component70 = graphDraw.addNode0(_type_of_component70, new Class<?>[]{}, g -> impl.defaultSchedulingTelemetryFactory(
            g.get(ApplicationGraph.holder0.component68),
            g.get(ApplicationGraph.holder0.component69),
            (SchedulingTracerFactory) null,
            (SchedulingLoggerFactory) null
          ), List.of(), component68, component69);
      var _type_of_component71 = map.get("component71");
      component71 = graphDraw.addNode0(_type_of_component71, new Class<?>[]{}, g -> new $ScheduledExecutorServiceConfig_ConfigValueExtractor(), List.of());
      var _type_of_component72 = map.get("component72");
      component72 = graphDraw.addNode0(_type_of_component72, new Class<?>[]{}, g -> impl.scheduledExecutorServiceConfig(
            g.get(ApplicationGraph.holder0.component8),
            g.get(ApplicationGraph.holder0.component71)
          ), List.of(), component8, component71);
      var _type_of_component73 = map.get("component73");
      component73 = graphDraw.addNode0(_type_of_component73, new Class<?>[]{}, g -> impl.scheduledExecutorServiceLifecycle(
            g.get(ApplicationGraph.holder0.component72)
          ), List.of(), component72);
      var _type_of_component74 = map.get("component74");
      component74 = graphDraw.addNode0(_type_of_component74, new Class<?>[]{}, g -> new OncallProber(
            g.get(ApplicationGraph.holder0.component34).value(),
            g.get(ApplicationGraph.holder0.component50)
          ), List.of(), component34, component50);
      var _type_of_component75 = map.get("component75");
      component75 = graphDraw.addNode0(_type_of_component75, new Class<?>[]{}, g -> impl.module4.$OncallProber_createUserProbe_Job(
            g.get(ApplicationGraph.holder0.component70),
            g.get(ApplicationGraph.holder0.component73),
            g.get(ApplicationGraph.holder0.component74)
          ), List.of(), component70, component73, component74);
      var _type_of_component76 = map.get("component76");
      component76 = graphDraw.addNode0(_type_of_component76, new Class<?>[]{}, g -> impl.module4.$OncallProber_deleteUserProbe_Job(
            g.get(ApplicationGraph.holder0.component70),
            g.get(ApplicationGraph.holder0.component73),
            g.get(ApplicationGraph.holder0.component74)
          ), List.of(), component70, component73, component74);
      var _type_of_component77 = map.get("component77");
      component77 = graphDraw.addNode0(_type_of_component77, new Class<?>[]{}, g -> impl.module4.$OncallProber_getTeamsProbe_Job(
            g.get(ApplicationGraph.holder0.component70),
            g.get(ApplicationGraph.holder0.component73),
            g.get(ApplicationGraph.holder0.component74)
          ), List.of(), component70, component73, component74);
    }
  }
}
