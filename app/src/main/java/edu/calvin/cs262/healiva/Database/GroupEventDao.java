package edu.calvin.cs262.healiva.Database;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * GroupEventDao (data access object) allows easy interaction with db GroupEvent table
 */
@Dao
public interface GroupEventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(GroupEvent groupEvent);

    @Delete
    void deleteGroupEvent(GroupEvent groupEvent);

    @Query("SELECT * from group_event_table")
    LiveData<List<GroupEvent>> getAllGroupEvents();
}