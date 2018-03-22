package com.nwnu.fundamentaloperations.repository;

import com.nwnu.fundamentaloperations.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    UserEntity findByUsername(String userName);
}
