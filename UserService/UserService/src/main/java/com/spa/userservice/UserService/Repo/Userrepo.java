package com.spa.userservice.UserService.Repo;

import com.spa.userservice.UserService.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<user,String> {
}
