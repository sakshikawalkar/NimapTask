package com.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.model.Category;
import com.spring.model.Product;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	@Query("from Product p where p.id=:id")
	List<Product> findById(int id);
}
