package edu.calvin.cs262.healiva.Database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * PersonDao (data access object) allows easy interaction with db Person table
 */
@Dao
public interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Person person);

//    ADMIN USE ONLY
//    @Query("DELETE FROM person_table")
//    void deleteAll();

    @Delete
    void deletePerson(Person person);

    @Query("SELECT * from person_table")
    LiveData<List<Person>> getAllPeople();

    @Query("SELECT * from person_table WHERE isCounselor")
    LiveData<List<Person>> getAllCounselors();

    @Query("SELECT * from person_table WHERE isListener")
    LiveData<List<Person>> getAllListeners();

    // Confirm log in credentials
    @Query("SELECT * from person_table WHERE email=:email AND password=:password")
    LiveData<List<Person>> findUser(final String email, final String password);

    // Used to add to empty db
    @Query("SELECT * from person_table LIMIT 1")
    Person[] getAnyPerson();


//    // Determine if person is fully anonymous
//    @Query("SELECT * FROM person_table " +
//           "WHERE id=:id " +
//           "AND NOT showName " +
//           "AND NOT showPic " +
//           "AND NOT showDescription " +
//           "AND NOT showPhoneNum ")
//    LiveData<List<Person>> getIsAnonymous(final int id);
}