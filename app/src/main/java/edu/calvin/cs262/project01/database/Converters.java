package edu.calvin.cs262.project01.database;

import java.sql.Date;
import androidx.room.TypeConverter;

/**
 * This files converts values so that they can be stored in the db correctly while being usable in the app
 */
public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}