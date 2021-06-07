package com.abhi.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.abhi.data.modal.User;

@RepositoryRestResource()
public interface UserRepository extends JpaRepository<User, Long>{

}
