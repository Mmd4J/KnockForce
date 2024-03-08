package me.gameisntover.knockforce.database;


import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public interface DatabaseObject {
    default Map<Field, Object> getMap() {
        Map<Field, Object> map = new HashMap<>();
        Stream<Field> s = Arrays.stream(getClass().getDeclaredFields()).filter(f -> !f.getAnnotatedType().isAnnotationPresent(DataTag.class));
        s.forEach(f -> {
            try {
                boolean a = f.canAccess(this);
                f.setAccessible(true);
                map.put(f, f.get(this));
                f.setAccessible(a);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return map;

}
