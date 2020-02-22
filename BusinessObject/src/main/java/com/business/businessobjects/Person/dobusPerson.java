package com.business.businessobjects.Person;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;

public class dobusPerson {
    public Integer PERSON_ID;

    public String LastName;

    public String FirstName;

    public String Address;

    public Date DOB;

    public Integer getPERSON_ID() {
        return PERSON_ID;
    }

    public void setPERSON_ID(Integer PERSON_ID) {
        this.PERSON_ID = PERSON_ID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
}
