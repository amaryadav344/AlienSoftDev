package com.business.businessobjects.Person;

import com.business.businessobjects.BusBase;

public class busProduct extends BusBase {
  public cdoProduct icdoProduct;

  public cdoProduct geticdoProduct() {
    return icdoProduct;
  }

  public void seticdoProduct(cdoProduct icdoProduct) {
    this.icdoProduct=icdoProduct;
  }
}
