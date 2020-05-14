package com.business.businessobjects.Supplier.DTO;

import com.business.businessobjects.Product.DTO.Product;
import com.business.common.base.BusBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "AST_SUPPLIER"
)
public class Supplier extends BusBase {
    @Id
    private Integer Id;

    private String CompanyName;

    private String ContactName;

    private String ContactTitle;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    private List<Product> products;

    private String City;

    private String Country;

    private String Phone;

    private String Fax;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public String getContactTitle() {
        return ContactTitle;
    }

    public void setContactTitle(String ContactTitle) {
        this.ContactTitle = ContactTitle;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
