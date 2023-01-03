package com.codeWithAjay.fullStackBackend.repository;

import com.codeWithAjay.fullStackBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Long> {

}
