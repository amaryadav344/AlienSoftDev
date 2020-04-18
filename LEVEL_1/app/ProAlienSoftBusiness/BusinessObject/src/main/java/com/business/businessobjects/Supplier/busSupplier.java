package com.business.businessobjects.Supplier;

import com.business.businessobjects.BusBase;

public class busSupplier extends BusBase {
  public cdoSupplier icdoSupplier;

  public cdoSupplier geticdoSupplier() {
    return icdoSupplier;
  }

  public void seticdoSupplier(cdoSupplier icdoSupplier) {
    this.icdoSupplier=icdoSupplier;
  }
}
