package com.business.businessobjects.Supplier;

import com.business.businessobjects.DoBase;
import java.lang.Integer;
import java.lang.String;

public class doSupplier extends DoBase {
  public Integer Id;

  public String CompanyName;

  public String ContactName;

  public String ContactTitle;

  public String City;

  public String Country;

  public String Phone;

  public String Fax;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer Id) {
    this.Id=Id;
  }

  public String getCompanyName() {
    return CompanyName;
  }

  public void setCompanyName(String CompanyName) {
    this.CompanyName=CompanyName;
  }

  public String getContactName() {
    return ContactName;
  }

  public void setContactName(String ContactName) {
    this.ContactName=ContactName;
  }

  public String getContactTitle() {
    return ContactTitle;
  }

  public void setContactTitle(String ContactTitle) {
    this.ContactTitle=ContactTitle;
  }

  public String getCity() {
    return City;
  }

  public void setCity(String City) {
    this.City=City;
  }

  public String getCountry() {
    return Country;
  }

  public void setCountry(String Country) {
    this.Country=Country;
  }

  public String getPhone() {
    return Phone;
  }

  public void setPhone(String Phone) {
    this.Phone=Phone;
  }

  public String getFax() {
    return Fax;
  }

  public void setFax(String Fax) {
    this.Fax=Fax;
  }
}
