package edu.calvin.cs262.healiva.Database;

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
    private Integer patientId;

    @NonNull
    @ColumnInfo(name = "listenerId")
    private Integer listenerId;

    @ColumnInfo(name = "listenerName")
    private String listenerName;

    @NonNull
    @ColumnInfo(name = "location")
    private String location;

    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    @NonNull
    @ColumnInfo(name = "time")
    private String time;

    public Appointment(@NonNull Integer id, @NonNull Integer patientId, @NonNull Integer listenerId,
                       String listenerName, @NonNull String location, @NonNull String date, @NonNull String time) {
        this.id = id;
        this.patientId = patientId;
        this.listenerId = listenerId;
        this.listenerName = listenerName;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    // Getters
    public Integer getId(){return this.id;}
    public Integer getPatientId(){return this.patientId;}
    public Integer getListenerId(){return this.listenerId;}
    public String getListenerName() {return this.listenerName; }
    public String getLocation(){return this.location;}
    public String getDate(){return this.date;}
    public String getTime(){return this.time;}
}

