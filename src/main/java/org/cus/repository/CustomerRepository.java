package org.cus.repository;

import org.cus.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByFirstName(String firstName);
}
