package com.java.stringoperations.repositories;

import com.java.stringoperations.entities.PalindromeData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringOperationRepository extends CrudRepository<PalindromeData, Long> {

}
