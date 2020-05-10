package com.business.businessobjects.Supplier.DTO;

import com.business.common.BusBase;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "AST_SUPPLIER"
)
public class Supplier extends BusBase {
  @Id
  private Integer Id;

  private String Companyname;

  private String Contactname;

  private String Contacttitle;

  private String City;

  private String Country;

  private String Phone;

  private String Fax;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer Id) {
    this.Id=Id;
  }

  public String getCompanyname() {
    return Companyname;
  }

  public void setCompanyname(String Companyname) {
    this.Companyname=Companyname;
  }

  public String getContactname() {
    return Contactname;
  }

  public void setContactname(String Contactname) {
    this.Contactname=Contactname;
  }

  public String getContacttitle() {
    return Contacttitle;
  }

  public void setContacttitle(String Contacttitle) {
    this.Contacttitle=Contacttitle;
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
