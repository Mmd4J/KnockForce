package me.gameisntover.knockforce.database;

import java.util.Dictionary;
import java.util.Hashtable;

public enum ObjectType {
    TEXT,
    VARCHAR,
    INT,
    LONG,
    FLOAT,
    DOUBLE,
    SET;

    private static String type(String type, String name) {
        return type + ":" + "name";
    }
    public static String type(ObjectType type, String name) {
        return type + ":" + "name";
    }

    public static String type(ObjectType type, int limit, String name) {
        return type(String.format("%s(%s)", type, limit), name);
    }


    public static Dictionary<String, String> extract(String text) {
        String[] args = text.split(":");
        Dictionary<String, String> dic = new Hashtable<>();
        dic.put("type", args[0]);
        dic.put("name", args[1]);
        return dic;
    }

}
