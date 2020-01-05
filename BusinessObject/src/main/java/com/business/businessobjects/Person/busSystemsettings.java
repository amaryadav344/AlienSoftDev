package com.business.businessobjects.Person;


import com.business.businessobjects.BusBase;

public class busSystemsettings extends BusBase {
  public cdobusSystemsettings icdobusSystemsettings;

  public cdobusSystemsettings geticdobusSystemsettings() {
    return icdobusSystemsettings;
  }

  public void seticdobusSystemsettings(cdobusSystemsettings icdobusSystemsettings) {
    this.icdobusSystemsettings=icdobusSystemsettings;
  }
}
