package com.business.businessobjects.Product.DTO;

import com.business.common.BusBase;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "AST_PRODUCT"
)
public class Product extends BusBase {
  @Id
  private Integer Id;

  private String Productname;

  private Integer Supplierid;

  private String Unitprice;

  private String Package;

  private Integer Isdiscontinued;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer Id) {
    this.Id=Id;
  }

  public String getProductname() {
    return Productname;
  }

  public void setProductname(String Productname) {
    this.Productname=Productname;
  }

  public Integer getSupplierid() {
    return Supplierid;
  }

  public void setSupplierid(Integer Supplierid) {
    this.Supplierid=Supplierid;
  }

  public String getUnitprice() {
    return Unitprice;
  }

  public void setUnitprice(String Unitprice) {
    this.Unitprice=Unitprice;
  }

  public String getPackage() {
    return Package;
  }

  public void setPackage(String Package) {
    this.Package=Package;
  }

  public Integer getIsdiscontinued() {
    return Isdiscontinued;
  }

  public void setIsdiscontinued(Integer Isdiscontinued) {
    this.Isdiscontinued=Isdiscontinued;
  }
}
