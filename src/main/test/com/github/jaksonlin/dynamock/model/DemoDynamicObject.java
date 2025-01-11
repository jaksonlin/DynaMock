package com.github.jaksonlin.dynamock.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DemoDynamicObject {

    private final Map<String, Object> fields = new HashMap<>();

    public void put(String fieldName, Object value) {
        System.out.println("DynamicObject: Setting field '" + fieldName + "' to value: " + value);
        fields.put(fieldName, value);
    }

    public Object get(String fieldName) {
        System.out.println("DynamicObject: Getting field '" + fieldName + "'");
        return fields.get(fieldName);
    }

    public String getString(String fieldName) {
        Object value = get(fieldName);
        if (value instanceof String) {
            return (String) value;
        }
        return null; // Or throw an exception
    }

    public Boolean getBoolean(String fieldName) {
        Object value = get(fieldName);
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return null; // Or throw an exception
    }

    public Integer getInteger(String fieldName) {
        Object value = get(fieldName);
        if (value instanceof Integer) {
            return (Integer) value;
        }
        return null; // Or throw an exception
    }

    public Long getLong(String fieldName) {
        Object value = get(fieldName);
        if (value instanceof Long) {
            return (Long) value;
        }
        return null; // Or throw an exception
    }

    @SuppressWarnings("unchecked")
    public <T> Collection<T> getCollection(String fieldName) {
        Object value = get(fieldName);
        if (value instanceof Collection) {
            return (Collection<T>) value;
        }
        return null; // Or throw an exception
    }

    public void remove(String fieldName) {
        System.out.println("DynamicObject: Removing field '" + fieldName + "'");
        fields.remove(fieldName);
    }

    public boolean containsKey(String fieldName) {
        return fields.containsKey(fieldName);
    }

    @Override
    public String toString() {
        return "DynamicObject{" +
               "fields=" + fields +
               '}';
    }

    public static void main(String[] args) {
        DemoDynamicObject dynamicObject = new DemoDynamicObject();

        dynamicObject.put("orderId", 12345);
        dynamicObject.put("isShipped", true);
        dynamicObject.put("customerName", "John Doe");
        dynamicObject.put("items", java.util.Arrays.asList("Product A", "Product B"));

        System.out.println("Order ID: " + dynamicObject.getInteger("orderId"));
        System.out.println("Is Shipped: " + dynamicObject.getBoolean("isShipped"));
        System.out.println("Customer Name: " + dynamicObject.getString("customerName"));
        System.out.println("Items: " + dynamicObject.getCollection("items"));

        dynamicObject.remove("isShipped");
        System.out.println("Is Shipped after removal: " + dynamicObject.containsKey("isShipped"));
    }
}
