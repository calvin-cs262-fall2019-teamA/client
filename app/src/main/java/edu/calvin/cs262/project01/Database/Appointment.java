package edu.calvin.cs262.project01.Database;

import java.sql.Date;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Appointment class create the appointment table for one on one in person appointments
 * between a patient and listener (peer or counselor)
 */
@Entity(tableName = "appointment_table")
public class Appointment {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "patientId")
    private String patientId;

    @NonNull
    @ColumnInfo(name = "listenerId")
    private String listenerId;

    @NonNull
    @ColumnInfo(name = "location")
    private String location;

    @NonNull
    @ColumnInfo(name = "date")
    private Date date;

    @NonNull
    @ColumnInfo(name = "time")
    private Date time;

    public Appointment(@NonNull Integer id, @NonNull String patientId, @NonNull String listenerId,
                       @NonNull String location, @NonNull Date date, @NonNull Date time) {
        this.id = id;
        this.patientId = patientId;
        this.listenerId = listenerId;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    // Getters
    public Integer getId(){return this.id;}
    public String getPatientId(){return this.patientId;}
    public String getListenerId(){return this.listenerId;}
    public String getLocation(){return this.location;}
    public Date getDate(){return this.date;}
    public Date getTime(){return this.time;}
}

