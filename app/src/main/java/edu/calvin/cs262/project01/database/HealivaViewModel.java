package edu.calvin.cs262.project01.database;

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

    // validate Login
    public LiveData<List<Person>> findUser(String email, String password) { return mRepository.findUser(email, password); }

    // Insert methods
    public void insert(Person person) { mRepository.insert(person); }

    // Delete methods
    public void deletePerson(Person person) {mRepository.deletePerson(person);}
}

