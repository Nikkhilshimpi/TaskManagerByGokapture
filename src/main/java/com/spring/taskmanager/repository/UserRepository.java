package com.spring.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.taskmanager.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT * FROM user e WHERE e.name = :name and password=:password",nativeQuery = true) 
	List<User> findByNameAndPassword(@Param("name") String name,@Param("password") String password);
}
