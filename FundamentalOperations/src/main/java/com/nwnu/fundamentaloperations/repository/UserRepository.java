package com.nwnu.fundamentaloperations.repository;

import com.nwnu.fundamentaloperations.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户的接口
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    UserEntity findByUsername(String userName);
}
