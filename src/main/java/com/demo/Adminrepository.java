package com.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface Adminrepository extends CrudRepository<Admin, Integer> {
	Admin findByUsername(String username);
}
