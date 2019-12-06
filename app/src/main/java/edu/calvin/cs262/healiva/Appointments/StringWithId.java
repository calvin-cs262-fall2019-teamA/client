package edu.calvin.cs262.healiva.Appointments;

public class StringWithId {
    public String string;
    public Integer id;

    public StringWithId(String stringPart, Integer idPart) {
        string = stringPart;
        id = idPart;
    }

    /**
     * toString method to use for dropdown display names
     * @return
     */
    @Override
    public String toString() {
        return string;
    }

    /**
     * getId get the string's id
     * @return
     */
    public Integer getId() {
        return id;
    }
}