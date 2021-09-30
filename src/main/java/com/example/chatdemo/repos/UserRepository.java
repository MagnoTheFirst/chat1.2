package com.example.chatdemo.repos;

import com.example.chatdemo.model.User;
import com.example.chatdemo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserAccount, Long> {

   // @Query("SELECT s FROM User s WHERE s.email = ?1")
  //  Optional<User> findByName(String email);


}
