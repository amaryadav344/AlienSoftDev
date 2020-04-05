package com.business.businessobjects.Order;

import com.business.businessobjects.DoBase;
import java.lang.Integer;
import java.lang.String;

public class doOrderitem extends DoBase {
  public Integer Id;

  public Integer OrderId;

  public Integer ProductId;

  public String UnitPrice;

  public Integer Quantity;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer Id) {
    this.Id=Id;
  }

  public Integer getOrderId() {
    return OrderId;
  }

  public void setOrderId(Integer OrderId) {
    this.OrderId=OrderId;
  }

  public Integer getProductId() {
    return ProductId;
  }

  public void setProductId(Integer ProductId) {
    this.ProductId=ProductId;
  }

  public String getUnitPrice() {
    return UnitPrice;
  }

  public void setUnitPrice(String UnitPrice) {
    this.UnitPrice=UnitPrice;
  }

  public Integer getQuantity() {
    return Quantity;
  }

  public void setQuantity(Integer Quantity) {
    this.Quantity=Quantity;
  }
}
