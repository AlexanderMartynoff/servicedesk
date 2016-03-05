package com.itsmtools.service.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;


public class JsonStrategy implements ExclusionStrategy {


    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    public JsonStrategy resolveRecursiveRelationShip() {
        return this;
    }
}
