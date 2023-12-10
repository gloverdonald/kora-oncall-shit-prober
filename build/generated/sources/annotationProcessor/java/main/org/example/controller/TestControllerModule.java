package org.example.controller;

import java.lang.String;
import ru.tinkoff.kora.common.Module;
import ru.tinkoff.kora.http.server.common.handler.BlockingRequestExecutor;
import ru.tinkoff.kora.http.server.common.handler.HttpServerRequestHandler;
import ru.tinkoff.kora.http.server.common.handler.HttpServerRequestHandlerImpl;
import ru.tinkoff.kora.http.server.common.handler.HttpServerResponseMapper;

@Module
public interface TestControllerModule {
  default HttpServerRequestHandler get_test(TestController _controller,
      HttpServerResponseMapper<String> _responseMapper, BlockingRequestExecutor _executor) {
    return HttpServerRequestHandlerImpl.of("GET", "/test", (_ctx, _request) -> {

      return _executor.execute(_ctx, () -> {
        var _result = _controller.getTest();
        return _responseMapper.apply(_ctx, _request, _result);
      });
    });
  }
}
