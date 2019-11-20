package edu.calvin.cs262.healiva.Database;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * GroupChatDao (data access object) allows easy interaction with db GroupChat table
 */
@Dao
public interface GroupChatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(GroupChat groupChat);

    @Delete
    void deleteGroupChat(GroupChat groupChat);

    @Query("SELECT * from group_chat_table")
    LiveData<List<GroupChat>> getAllGroupChats();
}
