package edu.calvin.cs262.healiva.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Manage source data from Person table
 */
@Database(entities = { Person.class, GroupChat.class, PersonGroupChatLink.class, GroupEvent.class, Appointment.class }, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class HealivaRoomDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
    public abstract GroupChatDao groupChatDao();
    public abstract PersonGroupChatLinkDao personGroupChatLinkDao();
    public abstract GroupEventDao groupEventDao();
    public abstract AppointmentDao appointmentDao();

    private static HealivaRoomDatabase INSTANCE;

    static HealivaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HealivaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HealivaRoomDatabase.class, "healiva_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    /**
     * Populate the database in the background.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PersonDao personDao;
        private final GroupChatDao groupChatDao;
        private final PersonGroupChatLinkDao personGroupChatLinkDao;
        private final GroupEventDao groupEventDao;
        private final AppointmentDao appointmentDao;
        PopulateDbAsync(HealivaRoomDatabase db) {
            personDao = db.personDao();
            groupChatDao = db.groupChatDao();
            personGroupChatLinkDao = db.personGroupChatLinkDao();
            groupEventDao = db.groupEventDao();
            appointmentDao = db.appointmentDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            // If we have no persons, then create the initial list of persons
            if (personDao.getAnyPerson().length < 1) {
                Log.d("DO IN BACKGROOUND DB", "doInBackground: NO PEOPLE YET. Adding default.");

                // Add hardcoded for listeners and patients
                personDao.insert(new Person(1, "nrs32@students.calvin.edu", "12345678", "Nikita", false, "", false, null, false, "", false, false, false));
                personDao.insert(new Person(2, "stz4@students.calvin.edu", "12345678", "Sebrina", false, "", false, null, false, "", false, false, false));
                personDao.insert(new Person(3, "sa35@students.calvin.edu", "12345678", "Sam", false, "", false, null, false, "", false, false, false));
                personDao.insert(new Person(4, "ham8@students.calvin.edu", "12345678", "Hellen", false, "", false, null, false, "", false, false, false));
                personDao.insert(new Person(5, "yp27@students.calvin.edu", "12345678", "YK", false, "", false, null, false, "", false, false, false));
                personDao.insert(new Person(6, "ibk2@calvin.edu", "12345678", "Irene", true, "", false, null, false, "", false, true, true));
                personDao.insert(new Person(7, "oah4@calvin.edu", "12345678", "Olja", true, "", false, null, false, "", false, true, true));
                personDao.insert(new Person(8, "kal34@calvin.edu", "12345678", "Keith", true, "", false, null, false, "", false, true, true));
                personDao.insert(new Person(9, "sdm23@calvin.edu", "12345678", "Shayne", true, "", false, null, false, "", false, true, true));

            } else {
                Log.d("DO IN BACKGROOUND DB", "doInBackground: ALREADY HAVE PERSON");
            }

            return null;
        }
    }
}

