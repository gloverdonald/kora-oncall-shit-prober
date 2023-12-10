package org.example.dto;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.SerializedString;
import jakarta.annotation.Nullable;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.json.common.JsonReader;

@Generated("ru.tinkoff.kora.json.annotation.processor.reader.JsonReaderGenerator")
public final class $LoginResponse_JsonReader implements JsonReader<LoginResponse> {
  private static final int ALL_FIELDS_RECEIVED = 0b1;

  private static final int NULLABLE_FIELDS_RECEIVED = 0b0;

  private static final SerializedString _csrfToken_optimized_field_name = new SerializedString("csrf_token");

  public $LoginResponse_JsonReader() {
  }

  private static String read_csrfToken(JsonParser _parser, int[] _receivedFields) throws
      IOException {
    var _token = _parser.nextToken();
    _receivedFields[0] = _receivedFields[0] | (1 << 0);
    if (_token == JsonToken.VALUE_STRING) {
      return  _parser.getText();
    }
    else {
      throw new JsonParseException(_parser, "Expecting [VALUE_STRING] token for field 'csrf_token', got " + _token);
    }
  }

  @Override
  @Nullable
  public final LoginResponse read(JsonParser _parser) throws IOException {
    var _token = _parser.currentToken();
    if (_token == JsonToken.VALUE_NULL) 
      return null;
    if (_token != JsonToken.START_OBJECT) 
      throw new JsonParseException(_parser, "Expecting START_OBJECT token, got " + _token);
    var _receivedFields = new int[]{NULLABLE_FIELDS_RECEIVED};

    String csrfToken = null;
    if (_parser.nextFieldName(_csrfToken_optimized_field_name)) {
      csrfToken = read_csrfToken(_parser, _receivedFields);
      _token = _parser.nextToken();
      while (_token != JsonToken.END_OBJECT) {
          _parser.nextToken();
          _parser.skipChildren();
          _token = _parser.nextToken();
      }
      return new LoginResponse(csrfToken);
    }
    _token = _parser.currentToken();
    while (_token != JsonToken.END_OBJECT) {
      if (_token != JsonToken.FIELD_NAME) 
        throw new JsonParseException(_parser, "Expecting FIELD_NAME token, got " + _token);
      var _fieldName = _parser.getCurrentName();
      switch (_fieldName) {
        case "csrf_token" -> {
          csrfToken = read_csrfToken(_parser, _receivedFields);
        }
        default -> {
          _parser.nextToken();
          _parser.skipChildren();
        }
      }
      _token = _parser.nextToken();
    }
    if (_receivedFields[0] != ALL_FIELDS_RECEIVED) {
      var _nonReceivedFields = (~_receivedFields[0]) & ALL_FIELDS_RECEIVED;
      var __error = new StringBuilder("Some of required json fields were not received:");
      for (int i = 0; i < 1; i++) {
        if ((_nonReceivedFields & (1 << i)) != 0) {
          __error.append(" ").append(switch (i) {
          case 0 -> "csrfToken(csrf_token)";
          default -> "";
        });
        }
      }
      throw new JsonParseException(_parser, __error.toString());
    }
    return new LoginResponse(csrfToken);
  }
}
