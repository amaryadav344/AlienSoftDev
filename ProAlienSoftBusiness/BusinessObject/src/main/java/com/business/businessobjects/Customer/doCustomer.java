package com.business.businessobjects.Customer;

import com.business.businessobjects.DoBase;
import java.lang.Integer;
import java.lang.String;

public class doCustomer extends DoBase {
  public Integer Id;

  public String FirstName;

  public String LastName;

  public String City;

  public String Country;

  public String Phone;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer Id) {
    this.Id=Id;
  }

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String FirstName) {
    this.FirstName=FirstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String LastName) {
    this.LastName=LastName;
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
}
