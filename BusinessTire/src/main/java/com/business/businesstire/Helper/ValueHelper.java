package com.business.businesstire.Helper;

import com.business.businessobjects.BusBase;
import com.business.businessobjects.DoBase;
import com.business.businesstire.Cache.MetaDataCache;
import com.business.utils.models.Entity.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ValueHelper {


    public static Object GetColumnValue(IColumn iColumn, DoBase doBase) throws NoSuchFieldException, IllegalAccessException {
        return doBase.getClass().getField(iColumn.getObjectField()).get(doBase);
    }

    public static Object GetPropertyValue(IProperty property, BusBase busBase) throws NoSuchFieldException, IllegalAccessException {
        String[] spit = property.getObjectField().split("\\.");
        Object value = new Object();
        for (String prop : spit) {
            Object fvalue = busBase.getClass().getDeclaredField(prop).get(busBase);
            if (fvalue instanceof BusBase) {
                busBase = (BusBase) fvalue;
            } else {
                value = fvalue;
            }
        }
        return value;
    }

    public static JSONObject GetObjectValue(IObject iObject, BusBase busBase) throws NoSuchFieldException, IllegalAccessException {
        String[] spit = iObject.getObjectField().split("\\.");
        for (String prop : spit) {
            Object fvalue = busBase.getClass().getDeclaredField(prop).get(busBase);
            if (fvalue instanceof BusBase) {
                busBase = (BusBase) fvalue;
            }

        }
        IEntity entity = (IEntity) MetaDataCache.getInstance().getXmlCache().Get(iObject.getEntity());
        return GetEntityValue(entity, busBase);
    }

    public static JSONArray GetCollectionValue(ICollection collection, BusBase busBase) throws NoSuchFieldException, IllegalAccessException {
        JSONArray jsonArray = new JSONArray();
        String[] spit = collection.getObjectField().split("\\.");
        JSONObject value = new JSONObject();
        List<BusBase> Collection = new ArrayList<>();
        for (String prop : spit) {
            Object fvalue = busBase.getClass().getDeclaredField(prop).get(busBase);
            if (fvalue instanceof BusBase) {
                busBase = (BusBase) fvalue;
            } else if (fvalue instanceof List) {
                Collection = (List<BusBase>) fvalue;
            }
        }
        IEntity entity = (IEntity) MetaDataCache.getInstance().getXmlCache().Get(collection.getEntity());
        for (BusBase busBase1 : Collection) {
            JSONObject object = GetEntityValue(entity, busBase1);
            jsonArray.put(object);
        }
        return jsonArray;
    }

    public static JSONObject GetEntityValue(IEntity entity, BusBase busBase) {
        JSONObject jsonObject = new JSONObject();
        if (entity.getColumns() != null) {
            for (IColumn column : entity.getColumns()) {
                try {
                    DoBase doBase = (DoBase) busBase.getClass().getDeclaredField(entity.getDatabaseObjectField()).get(busBase);
                    if (doBase != null) {
                        jsonObject.put(column.getName(), GetColumnValue(column, doBase));
                    }

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if (entity.getProperties() != null) {
            for (IProperty property : entity.getProperties()) {
                try {
                    jsonObject.put(property.getName(), GetPropertyValue(property, busBase));
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if (entity.getObjects() != null) {
            for (IObject object : entity.getObjects()) {
                try {
                    jsonObject.put(object.getName(), GetObjectValue(object, busBase));
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonObject;
    }
}
