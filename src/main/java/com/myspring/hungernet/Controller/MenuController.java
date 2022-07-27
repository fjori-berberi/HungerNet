package com.myspring.hungernet.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.myspring.hungernet.service.MenuService;

@RestController
@RequestMapping(path="/hungernet")
public class MenuController {
		@Autowired
		private MenuService menuService;
		
		@PostMapping(path="/addMenu") 
		  //add new user to hungernetdb.user
		  public ResponseEntity<String> addNewMenu (@RequestParam String userLoggedIn,@RequestParam String name) {
			  return menuService.addNewMenu(userLoggedIn, name);
		  }
		
		@DeleteMapping(path="/deleteMenu")
		  public ResponseEntity<String> deleteByUserId(@RequestParam String userLoggedIn,@RequestParam int id){
			  return menuService.deleteMenuById(userLoggedIn,id);
		  }
		  
//		  @GetMapping(path="/findAllMenus")
//		  public List<Menu> findAllMenus(@RequestParam String userLoggedIn){
//			  return menuService.findAllMenus(userLoggedIn);
//		  }
		  
		  @PutMapping(path="/updateMenu")
		  public ResponseEntity<String> updateMenuById(@RequestParam int id,@RequestParam String name ){
			  return menuService.updateMenuById(id, name);
		  }
}
