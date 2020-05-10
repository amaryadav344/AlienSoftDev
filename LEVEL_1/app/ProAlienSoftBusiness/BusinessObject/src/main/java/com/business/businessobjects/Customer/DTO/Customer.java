package com.business.businessobjects.Customer.DTO;

import com.business.common.BusBase;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "AST_CUSTOMER"
)
public class Customer extends BusBase {
  @Id
  private Integer Id;

  private String FirstName;

  private String LastName;

  private String City;

  private String Country;

  private String Phone;

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
