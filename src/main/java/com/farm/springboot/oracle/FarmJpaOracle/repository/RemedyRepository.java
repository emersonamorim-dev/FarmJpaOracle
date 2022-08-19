package com.farm.springboot.oracle.FarmJpaOracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.farm.springboot.oracle.FarmJpaOracle.model.Remedy;

public interface RemedyRepository extends JpaRepository<Remedy, Integer> {

    public List<Remedy> findByProductStartingWithOrMarcaStartingWith(String product, String marca);

    // @Query("SELECT e FROM Remedy e WHERE LOWER (e.product) LIKE
    // LOWER(:searchword) OR LOWER (e.marca) LIKE LOWER (:searchword) ")
    public List<Remedy> findRemedy(@Param("searchword") String searchword);

}
