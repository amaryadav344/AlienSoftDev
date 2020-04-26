package com.business.businessobjects.Person;

import com.business.businessobjects.DoBase;
import java.lang.Integer;
import java.lang.String;

public class doProduct extends DoBase {
  public Integer Id;

  public String ProductName;

  public Integer SupplierId;

  public String UnitPrice;

  public String Package;

  public Integer IsDiscontinued;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer Id) {
    this.Id=Id;
  }

  public String getProductName() {
    return ProductName;
  }

  public void setProductName(String ProductName) {
    this.ProductName=ProductName;
  }

  public Integer getSupplierId() {
    return SupplierId;
  }

  public void setSupplierId(Integer SupplierId) {
    this.SupplierId=SupplierId;
  }

  public String getUnitPrice() {
    return UnitPrice;
  }

  public void setUnitPrice(String UnitPrice) {
    this.UnitPrice=UnitPrice;
  }

  public String getPackage() {
    return Package;
  }

  public void setPackage(String Package) {
    this.Package=Package;
  }

  public Integer getIsDiscontinued() {
    return IsDiscontinued;
  }

  public void setIsDiscontinued(Integer IsDiscontinued) {
    this.IsDiscontinued=IsDiscontinued;
  }
}
