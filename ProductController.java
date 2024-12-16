package com.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Product;
import com.spring.repo.ProductRepo;

@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private ProductRepo repo;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product p) {
		return repo.save(p);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updatedProduct(@PathVariable int id, @RequestBody Product updatedProduct){
		return repo.findById(id).map(p -> {
			p.setName(updatedProduct.getName());
			p.setPrice(updatedProduct.getPrice());
			p.setDescription(updatedProduct.getDescription());
			return ResponseEntity.ok(repo.save(p));
		})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id){
		return repo.findById(id).map(p ->{
			repo.delete(p);
			return ResponseEntity.ok().build();
		})
				.orElse(ResponseEntity.notFound().build());
	}

}
