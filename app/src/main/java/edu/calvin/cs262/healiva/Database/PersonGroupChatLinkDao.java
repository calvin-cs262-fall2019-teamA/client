package edu.calvin.cs262.healiva.Database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * PersonGroupChatLinkDao (data access object) allows easy interaction with db PersonGroupChatLink table
 */
@Dao
public interface PersonGroupChatLinkDao {
    @Insert
    void insert(PersonGroupChatLink personGroupChatLink);

    // Get people from chatId
    @Query("SELECT * FROM person_table " +
            "INNER JOIN person_group_chat_link " +
            "ON person_table.id=person_group_chat_link.personId " +
            "WHERE person_group_chat_link.groupChatId=:groupChatId")
    LiveData<List<Person>> getPeopleInChat(final int groupChatId);

    // Get group chats from personId
    @Query("SELECT * FROM group_chat_table " +
            "INNER JOIN person_group_chat_link " +
            "ON group_chat_table.id=person_group_chat_link.groupChatId " +
            "WHERE person_group_chat_link.personId=:personId")
    LiveData<List<GroupChat>> getGroupChatsForPerson(final int personId);

    // Delete Group Chat Links by personId
    @Query("DELETE FROM person_group_chat_link " +
           "WHERE person_group_chat_link.personId=:personId")
    void deleteGroupChatLinkByPerson(final int personId);

    @Query("DELETE FROM person_group_chat_link")
    void deleteAll();

    @Delete
    void deletePersonGroupChatLink(PersonGroupChatLink personGroupChatLink);

    @Query("SELECT * from person_group_chat_link")
    LiveData<List<PersonGroupChatLink>> getAllPersonGroupChatLinks();
}
