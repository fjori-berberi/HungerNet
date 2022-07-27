package com.myspring.hungernet.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.myspring.hungernet.Model.entity.User;
import com.myspring.hungernet.service.UserService;

@RestController // This means that this class is a Controller
@RequestMapping(path="/hungernet") // This means URL's start with /demo (after Application path)
public class UserController {

	@Autowired 
	private UserService userService;
	
	  @PostMapping(path="/add") 
	  //add new user to hungernetdb.user
	  public ResponseEntity<String> addNewUser (@RequestParam String userLoggedIn,@RequestParam String name
	      , @RequestParam String userRole, String email) {
		  return userService.addNewUser(userLoggedIn, name, userRole, email);
	  }
	  
	  @DeleteMapping(path="/delete")
	  public ResponseEntity<String> deleteByUserId(@RequestParam String userLoggedIn,@RequestParam int id){
		  return userService.deleteUserById(userLoggedIn,id);
	  }
	  
	  @GetMapping(path="/findAll")
	  public ResponseEntity<List<User>> findAll(){
		  List<User> user= userService.findAll();
		  return ResponseEntity.ok(user);
	  }
	  
	  @PutMapping(path="/update")
	  public ResponseEntity<String> updateUserById(@RequestParam int id,
			  @RequestParam String name, @RequestParam String userRole, 
			  @RequestParam String email ){
		  return userService.updateUserById(id, name, userRole, email);
	  }
	  
	  @GetMapping(path="/findExceptAdmin")
	  public ResponseEntity<List<User>> findExceptAdmin(){
		  List<User> user= userService.findExceptAdmin();
		  return ResponseEntity.ok(user);
	  }
}
