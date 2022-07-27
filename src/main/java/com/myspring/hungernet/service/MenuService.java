package com.myspring.hungernet.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.myspring.hungernet.Model.entity.Menu;

@Service
@Transactional
public class MenuService {
		@PersistenceContext
		private EntityManager entityManager;

	public ResponseEntity<String> addNewMenu(String userLoggedIn,String name ) {
		if(userLoggedIn.equals("Manager")) {
				Menu menu= new Menu();
				menu.setType(name);
				entityManager.persist(menu);
			  return new ResponseEntity<>("Menu added!", HttpStatus.OK);
		  }
		  else return new ResponseEntity<>("Unauthorized access!", HttpStatus.NOT_ACCEPTABLE);
		}
	public ResponseEntity<String> deleteMenuById(String userLoggedIn,int id) {
		Menu menu = entityManager.find(Menu.class, id);
		if(userLoggedIn.equals("Manager")) {
		if (menu != null) {
			entityManager.remove(menu);
		}
		return new ResponseEntity<>("Menu deleted.", HttpStatus.ACCEPTED);	
	}
		else {
			return new ResponseEntity<>("Menu not found,", HttpStatus.NOT_FOUND);
		}
	}
	
//	public List<Menu> findAllMenus(String userLoggedIn) {
//			List<Menu> menus = entityManager.createNativeQuery("select * from menu", Menu.class).getResultList();
//			if(userLoggedIn.equals("Manager")) {
//				return menus;
//			}else {
//				
//			}	
//	}
	
	public ResponseEntity<String> updateMenuById(Integer id, String name) {
		Menu menu= entityManager.find(Menu.class, id);
		if(menu!=null) {
			menu.setType(name);
			return new ResponseEntity<>("Menu modified", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Menu not found", HttpStatus.NOT_FOUND);
		}
	}
}
