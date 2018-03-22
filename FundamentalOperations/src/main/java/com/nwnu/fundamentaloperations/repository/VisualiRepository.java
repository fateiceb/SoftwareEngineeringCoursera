package com.nwnu.fundamentaloperations.repository;

import com.nwnu.fundamentaloperations.domain.VisualizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisualiRepository extends JpaRepository<VisualizationEntity,String> {
    List<VisualizationEntity> findByUsername(@Param("username") String username);
}
