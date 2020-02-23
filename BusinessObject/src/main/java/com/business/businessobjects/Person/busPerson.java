package com.business.businessobjects.Person;

import com.business.businessobjects.Account.busInformationschematables;
import com.business.businessobjects.Account.cdobusInformationschematables;
import com.business.businessobjects.BusBase;

import java.util.Date;

public class busPerson extends BusBase {
    public Date DOB;
    public String Name;
    public cdobusPerson icdoPerson;
    public busInformationschematables busInformationschematables;

    public cdobusPerson geticdobusPerson() {
        return icdoPerson;
    }

    public void seticdobusPerson(cdobusPerson icdobusPerson) {
        this.icdoPerson = icdobusPerson;
    }

    public void LoadPerson() {
        icdoPerson = new cdobusPerson();
        icdoPerson.FirstName = "Amardeep";
        icdoPerson.LastName = "Yadav";
        busInformationschematables = new busInformationschematables();
        busInformationschematables.Name = "Sample Name";
        busInformationschematables.icdoInformationschematables = new cdobusInformationschematables();
        busInformationschematables.icdoInformationschematables.table_name="gdgdg";
        busInformationschematables.icdoInformationschematables.id=123;
        busInformationschematables.person = new busPerson();
    }

}
