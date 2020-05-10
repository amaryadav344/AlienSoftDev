package com.business.businessobjects.Order.DTO;

import com.business.common.BusBase;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "AST_ORDER"
)
public class Order extends BusBase {
  @Id
  private Integer Id;

  private Date OrderDate;

  private String OrderNumber;

  private Integer CustomerId;

  private String TotalAmount;

  public Integer getId() {
    return Id;
  }

  public void setId(Integer Id) {
    this.Id=Id;
  }

  public Date getOrderDate() {
    return OrderDate;
  }

  public void setOrderDate(Date OrderDate) {
    this.OrderDate=OrderDate;
  }

  public String getOrderNumber() {
    return OrderNumber;
  }

  public void setOrderNumber(String OrderNumber) {
    this.OrderNumber=OrderNumber;
  }

  public Integer getCustomerId() {
    return CustomerId;
  }

  public void setCustomerId(Integer CustomerId) {
    this.CustomerId=CustomerId;
  }

  public String getTotalAmount() {
    return TotalAmount;
  }

  public void setTotalAmount(String TotalAmount) {
    this.TotalAmount=TotalAmount;
  }
}
