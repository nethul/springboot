package edu.ijse.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.ijse.pos_system.dto.UserLoginReq;
import edu.ijse.pos_system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE username = :username", 
    nativeQuery = true)
    User findUserByUsername(@Param("username") String username);
}
