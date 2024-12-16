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

import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.repo.CategoryRepo;
import com.spring.repo.ProductRepo;

@RestController
@RequestMapping("/")
public class CategoryController {
	
	@Autowired
	private CategoryRepo Crepo;
	
	@Autowired
	private ProductRepo Prepo;
	
	@GetMapping
	public List<Category> getAllCategories(){
		return Crepo.findAll();
	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Category> getCategoryById(@PathVariable int id){
//		return Crepo.findById(id).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
//	}
	
	@GetMapping("/getproductsbyid/{id}")
	public List<Product> getProductById(@PathVariable int id){
		System.out.println("Product Id:"+id);
		List<Product> lstProduct=Crepo.findById(id);
		System.out.println("lstProduct"+lstProduct);
		return lstProduct;
	}
	
//	@GetMapping("/gettrainbytrainno/{trainno}")
//	public List<TrainInfo> getTrainByTrainNo(@PathVariable int trainno){
//		System.out.println("trainno="+trainno);
//		List<TrainInfo> lstTrains=repo.findByTrainNo(trainno);
//		System.out.println("lstTrains="+lstTrains);
//		return lstTrains;
//	}
//	@PostMapping
//	public Category createCategory(@RequestBody Category c) {
//		return Crepo.save(c);
//	}
//	
//	@PostMapping("/{id}/products")
//	public ResponseEntity<Product> addProductToCategory(@PathVariable int id, @RequestBody Product product ){
//		return Crepo.findById(id).map(category -> {
//			product.setCategory(category);
//			return ResponseEntity.ok(Prepo.save(product));
//		})
//				.orElse(ResponseEntity.notFound().build());
//	}
//	
//	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable int id){
//		return Crepo.findById(id).map(category -> ResponseEntity.ok(category.getP())).orElse(ResponseEntity.notFound().build());
//	}
	/*
	 * @PutMapping("/{id}") public ResponseEntity<Category>
	 * updateCategory(@PathVariable int id, @RequestBody Category updatedCategory){
	 * return Crepo.findById(id).map(existingCategory -> {
	 * existingCategory.setName(updatedCategory.getName());
	 * existingCategory.setDescription(updatedCategory.getDescription()); return
	 * ResponseEntity.ok(Crepo.save(existingCategory)); })
	 * .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<?> deleteCategory(@PathVariable
	 * int id){ return Crepo.findById(id).map(c -> { Crepo.delete(c); return
	 * ResponseEntity.ok().build(); }) .orElse(ResponseEntity.notFound().build()); }
	 * 
	 */

}
