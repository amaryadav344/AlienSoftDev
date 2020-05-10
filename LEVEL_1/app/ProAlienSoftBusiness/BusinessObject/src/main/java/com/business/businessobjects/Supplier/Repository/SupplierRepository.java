package com.business.businessobjects.Supplier.Repository;

import com.business.businessobjects.Supplier.DTO.Supplier;
import com.business.common.RepositoryBase;
import java.lang.Integer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("session")
public interface SupplierRepository extends RepositoryBase<Supplier, Integer> {
}
