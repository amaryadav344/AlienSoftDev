package com.business.businessobjects.Product.DTO;

import com.business.businessobjects.Supplier.DTO.Supplier;
import com.business.common.base.BusBase;

import java.lang.Integer;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "AST_PRODUCT"
)
public class Product extends BusBase {
    @Id
    private Integer Id;

    private String ProductName;
    @ManyToOne
    private Supplier supplier;

    private String UnitPrice;

    private String Package;

    private Integer DiscontinuedFlag;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public String getPackage() {
        return Package;
    }

    public void setPackage(String Package) {
        this.Package = Package;
    }

    public Integer getDiscontinuedFlag() {
        return DiscontinuedFlag;
    }

    public void setDiscontinuedFlag(Integer DiscontinuedFlag) {
        this.DiscontinuedFlag = DiscontinuedFlag;
    }
}
