package com.business.businessobjects.Home;

import com.business.businessobjects.BusBase;
import com.business.businessobjects.Customer.busCustomer;

import java.util.ArrayList;
import java.util.List;

public class busHome extends BusBase {
    public List<busCustomer> Customers;

    public void LoadHomeDetails() {
        Customers = new ArrayList<>();
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
        Customers.add(new busCustomer());
    }
}
