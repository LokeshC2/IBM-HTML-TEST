package org.example.userservice.repo;

import org.example.userservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	@Query("SELECT u FROM UserEntity u WHERE u.userId=?1")
	UserEntity findByUserId(String userId);
}
