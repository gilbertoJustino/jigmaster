package com.jigmaster.repository;

import com.jigmaster.model.Jig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JigRepository extends JpaRepository<Jig, Long> {
}
