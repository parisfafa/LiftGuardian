package com.paris.backend.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class GsonHelper {

    private static Gson gson;
    public static String modelToJson(ArrayList<Object> modelList)
    {
        return getGson().toJson(modelList==null?null:modelList);
    }
    public static String modelToJson(Object model)
    {
        return getGson().toJson(model==null?null:model);
    }
    public static Gson getGson()
    {
        if(gson==null)
        {
            gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
        }
        return gson;
    }
}
