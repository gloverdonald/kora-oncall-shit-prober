package org.example.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import jakarta.annotation.Nullable;
import java.io.IOException;
import java.lang.Override;
import ru.tinkoff.kora.common.annotation.Generated;
import ru.tinkoff.kora.json.common.JsonWriter;

@Generated("ru.tinkoff.kora.json.annotation.processor.writer.JsonWriterGenerator")
public final class $UserRequest_JsonWriter implements JsonWriter<UserRequest> {
  private static final SerializedString _name_optimized_field_name = new SerializedString("name");

  public $UserRequest_JsonWriter() {
  }

  @Override
  public final void write(JsonGenerator _gen, @Nullable UserRequest _object) throws IOException {
    if (_object == null) {
      _gen.writeNull();
      return;
    }
    _gen.writeStartObject(_object);
    if (_object.name() != null) {
      _gen.writeFieldName(_name_optimized_field_name);
      _gen.writeString(_object.name());
    }
    _gen.writeEndObject();
  }
}
