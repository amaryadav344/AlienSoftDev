package com.business.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBase<T, ID> extends JpaRepository<T, ID> {
}
