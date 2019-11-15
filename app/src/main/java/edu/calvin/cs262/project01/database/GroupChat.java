package edu.calvin.cs262.project01.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * GroupChat class create the groupChat table chats with many people
 */
@Entity(tableName = "group_chat_table")
public class GroupChat {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "isPublic")
    private Boolean isPublic;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    // Optional
    @ColumnInfo(name = "description")
    private String description;

    public GroupChat(@NonNull Integer id, @NonNull Boolean isPublic, @NonNull String name, @NonNull String description) {
        this.id = id;
        this.isPublic = isPublic;
        this.name = name;
        this.description = description;
    }

    // Getters
    public Integer getId(){return this.id;}
    public Boolean getIsPublic(){return this.isPublic;}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
}

