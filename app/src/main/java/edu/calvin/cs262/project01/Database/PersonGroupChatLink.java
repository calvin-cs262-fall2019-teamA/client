package edu.calvin.cs262.project01.Database;

import androidx.room.Entity;
import androidx.room.ForeignKey;

/**
 * PersonGroupChatLink joins Person table/class with GroupChat table/class
 */
@Entity(tableName = "person_group_chat_link",
        // establish two primary keys which must be a unique combo
        primaryKeys = { "personId", "groupChatId" },

        // derive foreign keys from Game and Player primary keys
        foreignKeys = {
                @ForeignKey(entity = Person.class,
                        parentColumns = "id",
                        childColumns = "personId"),
                @ForeignKey(entity = GroupChat.class,
                        parentColumns = "id",
                        childColumns = "groupChatId")
        })
public class PersonGroupChatLink {

    public final int personId;
    public final int groupChatId;

    public PersonGroupChatLink(final int personId, final int groupChatId) {
        this.personId = personId;
        this.groupChatId = groupChatId;
    }

}
