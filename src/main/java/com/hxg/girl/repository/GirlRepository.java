package com.hxg.girl.repository;

import com.hxg.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
}
