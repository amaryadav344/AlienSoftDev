package com.business.businessobjects.Order;

import com.business.businessobjects.BusBase;

public class busOrderitem extends BusBase {
  public cdoOrderitem icdoOrderitem;

  public cdoOrderitem geticdoOrderitem() {
    return icdoOrderitem;
  }

  public void seticdoOrderitem(cdoOrderitem icdoOrderitem) {
    this.icdoOrderitem=icdoOrderitem;
  }
}
