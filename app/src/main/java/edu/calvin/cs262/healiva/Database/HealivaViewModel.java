package edu.calvin.cs262.healiva.Database;

import android.app.Application;
import java.util.List;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * Way to safely interact with data from MainActivity
 * Holds data for UI
 */
public class HealivaViewModel extends AndroidViewModel {

    // Repo
    private HealivaRepository mRepository;

    // People
    private LiveData<List<Person>> allPeople;

    // ViewModel for tables
    public HealivaViewModel(Application application) {
        super(application);
        mRepository = new HealivaRepository(application);
        allPeople = mRepository.getAllPeople();
    }

    // Get all from a table
    public LiveData<List<Person>> getAllPeople() { return allPeople; }
    public LiveData<List<GroupChat>> getGroupChatsForPerson(final int personId) {
        return mRepository.getGroupChatsForPerson(personId);
    }

    public LiveData<List<Person>> getAllListeners() {return mRepository.getAllListeners(); }

    public String getNameFromId(Integer id) { return mRepository.getNameFromId(id); }

    public String getEmailFromId(Integer id) { return mRepository.getEmailFromId(id); }

    public LiveData<List<Person>> findPerson(String email) { return mRepository.findPerson(email);}

    // Get Appt by date
    public LiveData<List<Appointment>> getAppointmentByDate(String date, Integer currentUserId) { return mRepository.getAppointmentByDate(date, currentUserId); };

    // validate Login
    public LiveData<List<Person>> findUser(String email, String password) { return mRepository.findUser(email, password); }

    // Insert methods
    public void insert(Person person) { mRepository.insert(person); }

    // Insert Appointment
    public void insert(Appointment appointment) { mRepository.insert(appointment); }

    // Delete methods
    public void deletePerson(Person person) {
        mRepository.deleteGroupChatLinkByPerson(person.getId());
        mRepository.deletePerson(person);
    }
}

