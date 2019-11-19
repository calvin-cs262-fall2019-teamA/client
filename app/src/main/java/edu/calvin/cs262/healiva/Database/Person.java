package edu.calvin.cs262.healiva.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Person class create the person table to handle logins, patients, listeners, and counselors
 */
@Entity(tableName = "person_table")
public class Person {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    // Optional
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "showName")
    private Boolean showName;

    // Optional
    @ColumnInfo(name = "profileDescription")
    private String profileDescription;

    @NonNull
    @ColumnInfo(name = "showDescription")
    private Boolean showDescription;

    // Optional
    @ColumnInfo(name = "profilePic")
    private String profilePic;

    @NonNull
    @ColumnInfo(name = "showPic")
    private Boolean showPic;

    // Optional
    @ColumnInfo(name = "phoneNum")
    private String phoneNum;

    @NonNull
    @ColumnInfo(name = "showPhoneNum")
    private Boolean showPhoneNum;

    @NonNull
    @ColumnInfo(name = "isCounselor")
    private Boolean isCounselor;

    @NonNull
    @ColumnInfo(name = "isListener")
    private Boolean isListener;

    public Person(@NonNull Integer id, @NonNull String email, @NonNull String password,
                  String name, @NonNull Boolean showName, String profileDescription, @NonNull Boolean showDescription,
                  String profilePic, @NonNull Boolean showPic, String phoneNum, @NonNull Boolean showPhoneNum,
                  @NonNull Boolean isCounselor, @NonNull Boolean isListener) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.showName = showName;
        this.profileDescription = profileDescription;
        this.showDescription = showDescription;
        this.profilePic = profilePic;
        this.showPic = showPic;
        this.phoneNum = phoneNum;
        this.showPhoneNum = showPhoneNum;
        this.isCounselor = isCounselor;
        this.isListener = isListener;
    }

    // Getters
    public Integer getId(){return this.id;}
    public String  getEmail(){return this.email;}
    public String  getPassword(){return this.password;}
    public String  getName(){return this.name;}
    public Boolean getShowName(){return this.showName;}
    public String  getProfileDescription(){return this.profileDescription;}
    public Boolean getShowDescription(){return this.showDescription;}
    public String  getProfilePic(){return this.profilePic;}
    public Boolean getShowPic(){return this.showPic;}
    public String  getPhoneNum(){return this.phoneNum;}
    public Boolean getShowPhoneNum(){return this.showPhoneNum;}
    public Boolean getIsCounselor(){return this.isCounselor;}
    public Boolean getIsListener(){return this.isListener;}

}
