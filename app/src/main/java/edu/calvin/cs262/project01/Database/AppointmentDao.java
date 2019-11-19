package edu.calvin.cs262.project01.Database;

import java.sql.Date;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * AppointmentDao (data access object) allows easy interaction with db Appointment table
 */
@Dao
public interface AppointmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Appointment appointment);

    @Delete
    void deleteAppointment(Appointment appointment);

    @Query("SELECT * from appointment_table")
    LiveData<List<Appointment>> getAllAppointments();

    // Get appt. by date
    @Query("SELECT * FROM appointment_table, person_table as patient, person_table as listener " +
           "WHERE date=:date " +
           "AND patient.id=:patientId " +
           "AND listener.id=:listenerId ")
    LiveData<List<Appointment>> getAppointmentByDate(final Date date, final Integer patientId, final Integer listenerId);
}