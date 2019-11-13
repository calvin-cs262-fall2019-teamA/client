package edu.calvin.cs262.project01.database;

import java.sql.Date;
import java.sql.Time;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * GroupEvent class create the group_event table to handle info for group event listings
 */
@Entity(tableName = "group_event_table")
public class GroupEvent {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    // Optional
    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "location")
    private String location;

    @NonNull
    @ColumnInfo(name = "date")
    private Date date;

    @NonNull
    @ColumnInfo(name = "time")
    private Time time;

    public GroupEvent(@NonNull Integer id, @NonNull String name, String description,
                      @NonNull String location, @NonNull Date date, @NonNull Time time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    // Getters
    public Integer getId(){return this.id;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public String getLocation(){return this.location;}
    public Date getDate(){return this.date;}
    public Time getTime(){return this.time;}

}
