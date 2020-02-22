package com.business.businesstire;

import com.business.businessobjects.BusBase;
import com.business.utils.models.Entity.IColumn;
import com.business.utils.models.Entity.IEntity;
import com.business.utils.models.Entity.IProperty;
import com.business.utils.models.UI.IForm;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;

public class ViewModel {
    IForm view;
    @JsonSerialize(using = JsonObjectSerializer.class)
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

    public static ViewModel getViewModel(IEntity entity, BusBase busBase, IForm form) {
        ViewModel viewModel = new ViewModel();
        viewModel.setView(form);
        JSONObject jsonObject = new JSONObject();
        if (entity.getColumns() != null) {
            Field field = null;
            try {
                field = busBase.getClass().getDeclaredField(entity.getDatabaseObjectField());
                Object o = field.get(busBase);
                for (IColumn column : entity.getColumns()) {
                    try {
                        Field col = o.getClass().getField(column.getName());
                        Object value = col.get(o);
                        jsonObject.put(column.getName(), value);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        //e.printStackTrace();
                    }

                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            for (IProperty property : entity.getProperties()) {
                try {
                    Field prop = busBase.getClass().getDeclaredField(property.getName());
                    Object o = field.get(busBase);
                    jsonObject.put(property.getName(), o);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    //e.printStackTrace();
                }

            }
        }
        viewModel.setModel(jsonObject);
        return viewModel;
    }
}
