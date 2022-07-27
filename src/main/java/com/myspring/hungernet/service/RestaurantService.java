package com.myspring.hungernet.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myspring.hungernet.Model.entity.Item;
import com.myspring.hungernet.Model.entity.Menu;
import com.myspring.hungernet.Model.entity.Restaurant;
import com.myspring.hungernet.Model.pojo.CreateRestaurantDTO;
import com.myspring.hungernet.Model.pojo.ItemPojo;
import com.myspring.hungernet.Model.pojo.MenuPojo;

@Service
@Transactional
public class RestaurantService {
	
	@PersistenceContext
	private EntityManager entityManager;
	public ResponseEntity<String> addNewRestaurant(String userLoggedIn, CreateRestaurantDTO createRestaurantDTO) {
		if (userLoggedIn.equals("Admin")) {
			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantName(createRestaurantDTO.getRestaurantName());
			restaurant.setMenuList(new ArrayList<>());
			
			for (MenuPojo menuPojo : createRestaurantDTO.getMenus()) {
				Menu menuEntity = new Menu();
				menuEntity.setType(menuPojo.getType());
				menuEntity.setRestaurant(restaurant);
				menuEntity.setItems(new ArrayList<>());

				for (ItemPojo itemPojo : menuPojo.getMenuItems()) {
					Item itemEntity = new Item();
					itemEntity.setItemName(itemPojo.getName());
					itemEntity.setMenu(menuEntity);
					menuEntity.getItems().add(itemEntity);
				}
				restaurant.getMenuList().add(menuEntity);
			}
			entityManager.persist(restaurant);

			return new ResponseEntity<>("Restaurant added!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Unauthorized access!", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	public ResponseEntity<String> deleteRestaurantById(String userLoggedIn,int id) {
		Restaurant restaurant = entityManager.find(Restaurant.class, id);
		if(userLoggedIn.equals("Admin")) {
		if (restaurant != null) {
			entityManager.remove(restaurant);
		}
		return new ResponseEntity<>("Restaurant deleted.", HttpStatus.ACCEPTED);	
		}
		else {
			return new ResponseEntity<>("Restaurant not found.", HttpStatus.NOT_FOUND);
		}
	}
	
	public List<Restaurant> findAllRestaurants() {
		List<Restaurant> restaurant = entityManager.createNativeQuery("select * from restaurant", Restaurant.class).getResultList();	
		return restaurant;
	}
	
	public ResponseEntity<String> updateRestaurantById(Integer id, String name) {
		Restaurant restaurant= entityManager.find(Restaurant.class, id);
		if(restaurant!=null) {
			restaurant.setRestaurantName(name);
			return new ResponseEntity<>("Restaurant name modified", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Restaurant not found", HttpStatus.NOT_FOUND);
		}
	}
}
