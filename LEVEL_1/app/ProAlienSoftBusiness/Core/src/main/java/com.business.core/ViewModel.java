package com.business.core;

import com.business.businessobjects.BusBase;
import com.business.core.Helper.ValueHelper;
import com.business.utils.models.Entity.IEntity;
import com.business.utils.models.UI.IForm;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.json.JSONObject;

import java.io.IOException;

public class ViewModel {
    IForm view;
    @JsonSerialize(using = JsonObjectSerializer.class)
    @JsonDeserialize(using = JsonObjectDeserializer.class)
    @JsonProperty("model")
    JSONObject model;

    private ViewModel() {
    }

    public IForm getView() {
        return view;
    }

    public void setView(IForm view) {
        this.view = view;
    }

    public JSONObject getModel() {
        return model;
    }

    public void setModel(JSONObject model) {
        this.model = model;
    }

    public static class JsonObjectSerializer extends JsonSerializer<JSONObject> {

        @Override
        public void serialize(JSONObject jsonObject, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, IOException {
            jsonGenerator.writeRawValue(jsonObject.toString());
        }

    }

    public static class JsonObjectDeserializer extends JsonDeserializer<JSONObject> {
        @Override
        public JSONObject deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return new JSONObject(jsonParser.readValueAsTree().toString());
        }
    }

    public static ViewModel getViewModel(IEntity entity, BusBase busBase, IForm form) {
        ViewModel viewModel = new ViewModel();
        viewModel.setView(form);
        JSONObject jsonObject = ValueHelper.GetFormData(entity,form, busBase);
        viewModel.setModel(jsonObject);
        return viewModel;
    }
}
