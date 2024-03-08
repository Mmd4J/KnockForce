package me.gameisntover.knockforce.database;

import java.util.Map;

public interface Database {
    void insertData(DatabaseObject obj);

    void selectData(DatabaseObject obj, Map.Entry... primaryArgs);

    void updateData(DatabaseObject obj);

    String getName();
}
