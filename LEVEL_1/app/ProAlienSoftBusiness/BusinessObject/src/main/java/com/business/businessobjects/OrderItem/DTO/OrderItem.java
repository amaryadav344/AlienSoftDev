package com.business.businessobjects.OrderItem.DTO;

import com.business.common.BusBase;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "AST_ORDER_ITEM"
)
public class OrderItem extends BusBase {
  @Id
  private Integer Id;

  private Integer Orderid;

  private Integer Productid;

  private String Unitprice;

  private Integer Quantity;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer Id) {
    this.Id=Id;
  }

  public Integer getOrderid() {
    return Orderid;
  }

  public void setOrderid(Integer Orderid) {
    this.Orderid=Orderid;
  }

  public Integer getProductid() {
    return Productid;
  }

  public void setProductid(Integer Productid) {
    this.Productid=Productid;
  }

  public String getUnitprice() {
    return Unitprice;
  }

  public void setUnitprice(String Unitprice) {
    this.Unitprice=Unitprice;
  }

  public Integer getQuantity() {
    return Quantity;
  }

  public void setQuantity(Integer Quantity) {
    this.Quantity=Quantity;
  }
}
