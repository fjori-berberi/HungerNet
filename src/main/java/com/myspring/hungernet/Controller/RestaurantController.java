package com.myspring.hungernet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.myspring.hungernet.Model.entity.Restaurant;
import com.myspring.hungernet.Model.pojo.CreateRestaurantDTO;
import com.myspring.hungernet.service.RestaurantService;


@RestController
@RequestMapping(path="/hungernet")
public class RestaurantController {
	
	@Autowired 
	private RestaurantService restaurantService;
	
	  @PostMapping(path="/addRestaurant") 
	  //add new restaurant to hungernetdb.user
	  public ResponseEntity<String> addNewRestaurant (@RequestParam String userLoggedIn,
			  @RequestBody CreateRestaurantDTO createRestaurantDTO) {
		  return restaurantService.addNewRestaurant(userLoggedIn, createRestaurantDTO);
	  }
	  
	  @DeleteMapping(path="/deleteRestaurant")
	  public ResponseEntity<String> deleteByRestaurantId(@RequestParam String userLoggedIn,@RequestParam int id){
		  return restaurantService.deleteRestaurantById(userLoggedIn,id);
	  }
	  
	  @GetMapping(path="/findAllRestaurants")
	  public ResponseEntity<List<Restaurant>> findAllRestaurants(){
		  List<Restaurant> restaurant= restaurantService.findAllRestaurants();
		  return ResponseEntity.ok(restaurant);
	  }
	  
	  @PutMapping(path="/updateRestaurants")
	  public ResponseEntity<String> updateRestaurantById(@RequestParam int id, @RequestParam String name ){
		  return restaurantService.updateRestaurantById(id, name);
	  }
	  

}
