package com.business.businessobjects.Customer;

import com.business.businessobjects.BusBase;

public class busCustomer extends BusBase {
    public cdoCustomer icdoCustomer;

    public cdoCustomer geticdoCustomer() {
        return icdoCustomer;
    }

    public void seticdoCustomer(cdoCustomer icdoCustomer) {
        this.icdoCustomer = icdoCustomer;
    }

    public busCustomer() {
        this.icdoCustomer = new cdoCustomer();
        icdoCustomer.setFirstName("Amardeep");
    }
}
