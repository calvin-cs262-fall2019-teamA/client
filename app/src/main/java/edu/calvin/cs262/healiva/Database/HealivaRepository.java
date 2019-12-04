package edu.calvin.cs262.healiva.Database;

import android.app.Application;
import android.os.AsyncTask;

import java.sql.Date;
import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * Single source of truth for app data that UI can interact with
 */
public class HealivaRepository {
    // Person declarations
    private PersonDao personDao;
    private LiveData<List<Person>> allCounselors;
    private LiveData<List<Person>> allListeners;
    private LiveData<List<Person>> allPeople;

    // GroupChat declarations
    private GroupChatDao groupChatDao;
    private LiveData<List<GroupChat>> allGroupChats;

    // PersonGroupChatLink declarations
    private PersonGroupChatLinkDao personGroupChatLinkDao;
    private LiveData<List<Person>> allPeopleInChat;
    private LiveData<List<GroupChat>> allChatsForPerson;
    private LiveData<List<PersonGroupChatLink>> allPersonGroupChatLinks;

    // Appointment declarations
    private AppointmentDao appointmentDao;
    LiveData<List<Appointment>> allAppointments;
    LiveData<List<Appointment>> allAppointmentsByDate;

    // GroupEvent declarations
    private GroupEventDao groupEventDao;
    LiveData<List<GroupEvent>> allGroupEvents;

    // Repo of tables
    HealivaRepository(Application application) {
        HealivaRoomDatabase db = HealivaRoomDatabase.getDatabase(application);
        // Person
        personDao = db.personDao();
        allCounselors = personDao.getAllCounselors();
        allListeners = personDao.getAllListeners();
        allPeople = personDao.getAllPeople();

        // GroupChat
        groupChatDao = db.groupChatDao();
        allGroupChats = groupChatDao.getAllGroupChats();

        // PersonGroupChatLink
        personGroupChatLinkDao = db.personGroupChatLinkDao();
        allPersonGroupChatLinks = personGroupChatLinkDao.getAllPersonGroupChatLinks();

        // Appointment
        appointmentDao = db.appointmentDao();
        allAppointments = appointmentDao.getAllAppointments();

        // GroupEvent
        groupEventDao = db.groupEventDao();
        allGroupEvents = groupEventDao.getAllGroupEvents();
    }

    ////////////////// CONFIRM LOGIN ////////////////
    LiveData<List<Person>> findUser(final String email, final String password) {
        return personDao.findUser(email, password);
    }

    LiveData<List<Person>> findPerson(final String email) {
        return personDao.findPerson(email);
    }

    ////////////////// GET methods //////////////////
    LiveData<List<Person>> getAllCounselors() {
        return allCounselors;
    }

    String getNameFromId(Integer id) { return personDao.getNameFromId(id); }

    String getEmailFromId(Integer id) { return personDao.getEmailFromId(id); }

    LiveData<List<Person>> getAllListeners() {
        return allListeners;
    }

    LiveData<List<Person>> getAllPeople() {
        return allPeople;
    }

    LiveData<List<GroupChat>> getAllGroupChats() {
        return allGroupChats;
    }

    LiveData<List<Person>> getPeopleInChat(final int groupChatId) {
        allPeopleInChat = personGroupChatLinkDao.getPeopleInChat(groupChatId);
        return allPeopleInChat;
    }

    LiveData<List<GroupChat>> getGroupChatsForPerson(final int personId) {
        allChatsForPerson = personGroupChatLinkDao.getGroupChatsForPerson(personId);
        return allChatsForPerson;
    }

    LiveData<List<PersonGroupChatLink>> getAllPersonGroupChatLinks() {
        return allPersonGroupChatLinks;
    }

    LiveData<List<Appointment>> getAppointmentByDate(final Date date, final Integer patientId, final Integer listenerId) {
        allAppointmentsByDate = appointmentDao.getAppointmentByDate(date, patientId, listenerId);
        return allAppointmentsByDate;
    }

    LiveData<List<Appointment>> getAppointmnets() {
        return allAppointments;
    }

    LiveData<List<GroupEvent>> getAllGroupEvents() {
        return allGroupEvents;
    }

    ////////////////// INSERT PERSON //////////////////
    public void insert (Person person) {
        new insertPersonAsyncTask(personDao).execute(person);
    }

    /**
     * Use AsyncTask to insert a single player and maintain performance
     */
    private static class insertPersonAsyncTask extends AsyncTask<Person, Void, Void> {

        private PersonDao personAsyncTaskDao;

        insertPersonAsyncTask(PersonDao dao) {
            personAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Person... params) {
            personAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    ////////////////// INSERT GROUP CHAT //////////////////
    public void insert (GroupChat groupChat) {
        new insertGroupChatAsyncTask(groupChatDao).execute(groupChat);
    }

    /**
     * Use AsyncTask to insert a single group chat and maintain performance
     */
    private static class insertGroupChatAsyncTask extends AsyncTask<GroupChat, Void, Void> {

        private GroupChatDao groupChatAsyncTaskDao;

        insertGroupChatAsyncTask(GroupChatDao dao) {
            groupChatAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GroupChat... params) {
            groupChatAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    ////////////////// INSERT PERSON GROUP CHAT LINK //////////////////
    public void insert (PersonGroupChatLink personGroupChatLink) {
        new insertPersonGroupChatLinkAsyncTask(personGroupChatLinkDao).execute(personGroupChatLink);
    }

    /**
     * Use AsyncTask to insert a single group chat and maintain performance
     */
    private static class insertPersonGroupChatLinkAsyncTask extends AsyncTask<PersonGroupChatLink, Void, Void> {

        private PersonGroupChatLinkDao personGroupChatLinkAsyncTaskDao;

        insertPersonGroupChatLinkAsyncTask(PersonGroupChatLinkDao dao) {
            personGroupChatLinkAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final PersonGroupChatLink... params) {
            personGroupChatLinkAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    ////////////////// INSERT APPOINTMENT //////////////////
    public void insert (Appointment appointment) {
        new insertAppointmentAsyncTask(appointmentDao).execute(appointment);
    }

    /**
     * Use AsyncTask to insert a single group chat and maintain performance
     */
    private static class insertAppointmentAsyncTask extends AsyncTask<Appointment, Void, Void> {

        private AppointmentDao appointmentAsyncTaskDao;

        insertAppointmentAsyncTask(AppointmentDao dao) {
            appointmentAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Appointment... params) {
            appointmentAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    ////////////////// INSERT GROUP EVENT //////////////////
    public void insert (GroupEvent groupEvent) {
        new insertGroupEventAsyncTask(groupEventDao).execute(groupEvent);
    }

    /**
     * Use AsyncTask to insert a single group chat and maintain performance
     */
    private static class insertGroupEventAsyncTask extends AsyncTask<GroupEvent, Void, Void> {

        private GroupEventDao groupEventAsyncTaskDao;

        insertGroupEventAsyncTask(GroupEventDao dao) {
            groupEventAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GroupEvent... params) {
            groupEventAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


    ////////////////// DELETE PERSON //////////////////
    public void deletePerson(Person person)  {
        new deletePersonAsyncTask(personDao).execute(person);
    }

    /**
     * Use AsyncTask to delete a single group chat and maintain performance
     */
    private static class deletePersonAsyncTask extends AsyncTask<Person, Void, Void> {
        private PersonDao mAsyncTaskDao;

        deletePersonAsyncTask(PersonDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Person... params) {
            mAsyncTaskDao.deletePerson(params[0]);
            return null;
        }
    }

    ////////////// DELETE GROUP CHAT LINKS BY PERSON ID /////////////////
    void deleteGroupChatLinkByPerson(Integer personId) {
        new deleteGroupChatLinkAsyncTask(personGroupChatLinkDao).execute(personId);
    }

    /**
     * Use AsyncTask to delete player from join and person tables
     */
    private static class deleteGroupChatLinkAsyncTask extends AsyncTask<Integer, Void, Void> {
        private PersonGroupChatLinkDao personGroupChatLinkDao;

        deleteGroupChatLinkAsyncTask(PersonGroupChatLinkDao dao) {
            personGroupChatLinkDao = dao;
        }

        @Override
        protected Void doInBackground(final Integer... params) {
            personGroupChatLinkDao.deleteGroupChatLinkByPerson(params[0]);
            return null;
        }
    }

    ////////////////// DELETE GROUP CHAT //////////////////
    public void deleteGroupChat(GroupChat groupChat)  {
        new deleteGroupChatAsyncTask(groupChatDao).execute(groupChat);
    }

    /**
     * Use AsyncTask to delete a single group chat and maintain performance
     */
    private static class deleteGroupChatAsyncTask extends AsyncTask<GroupChat, Void, Void> {
        private GroupChatDao mAsyncTaskDao;

        deleteGroupChatAsyncTask(GroupChatDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GroupChat... params) {
            mAsyncTaskDao.deleteGroupChat(params[0]);
            return null;
        }
    }

    ////////////////// DELETE PERSON GROUP CHAT LINK //////////////////
    public void deletePersonGroupChatLink(PersonGroupChatLink personGroupChatLink)  {
        new deletePersonGroupChatLinkAsyncTask(personGroupChatLinkDao).execute(personGroupChatLink);
    }

    /**
     * Use AsyncTask to delete a single group chat and maintain performance
     */
    private static class deletePersonGroupChatLinkAsyncTask extends AsyncTask<PersonGroupChatLink, Void, Void> {
        private PersonGroupChatLinkDao mAsyncTaskDao;

        deletePersonGroupChatLinkAsyncTask(PersonGroupChatLinkDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final PersonGroupChatLink... params) {
            mAsyncTaskDao.deletePersonGroupChatLink(params[0]);
            return null;
        }
    }

    ////////////////// DELETE APPOINTMENT //////////////////
    public void deleteAppointment(Appointment appointment)  {
        new deleteAppointmentAsyncTask(appointmentDao).execute(appointment);
    }

    /**
     * Use AsyncTask to delete a single group chat and maintain performance
     */
    private static class deleteAppointmentAsyncTask extends AsyncTask<Appointment, Void, Void> {
        private AppointmentDao mAsyncTaskDao;

        deleteAppointmentAsyncTask(AppointmentDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Appointment... params) {
            mAsyncTaskDao.deleteAppointment(params[0]);
            return null;
        }
    }

    ////////////////// DELETE GROUP EVENT //////////////////
    public void deleteGroupEvent(GroupEvent groupEvent)  {
        new deleteGroupEventAsyncTask(groupEventDao).execute(groupEvent);
    }

    /**
     * Use AsyncTask to delete a single group chat and maintain performance
     */
    private static class deleteGroupEventAsyncTask extends AsyncTask<GroupEvent, Void, Void> {
        private GroupEventDao mAsyncTaskDao;

        deleteGroupEventAsyncTask(GroupEventDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GroupEvent... params) {
            mAsyncTaskDao.deleteGroupEvent(params[0]);
            return null;
        }
    }
}
