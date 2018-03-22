package com.nwnu.fundamentaloperations.repository;

import com.nwnu.fundamentaloperations.domain.ExpressionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpressionRepository extends JpaRepository<ExpressionEntity,String>{
        List<ExpressionEntity> findAll();
        List<ExpressionEntity> findAllByType(@Param(value = "type") String type);
}
