package com.junit.homework.repos;

import com.junit.homework.domain.CustomerContact;
import org.springframework.data.repository.CrudRepository;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

}
