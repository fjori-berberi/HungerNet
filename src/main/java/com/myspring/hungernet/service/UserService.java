package com.myspring.hungernet.service;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myspring.hungernet.Model.entity.User;

@Service
@Transactional
public class UserService {

	@PersistenceContext
	private EntityManager entityManager;
	private UserService userService;
	
	public ResponseEntity<String> addNewUser(String userLoggedIn,String name, String userRole, String email ) {
		if(userLoggedIn.equals("Admin")) {
			User user= new User();
				user.setName(name);
				user.setUserRole(userRole);
				user.setEmail(email);
				entityManager.persist(user);
			  return new ResponseEntity<>("User added!", HttpStatus.OK);
		  }
		  else return new ResponseEntity<>("Unauthorized access!", HttpStatus.NOT_ACCEPTABLE);
		}
	
	public ResponseEntity<String> deleteUserById(String userLoggedIn,int id) {
		User user = entityManager.find(User.class, id);
		if(userLoggedIn.equals("Admin")) {
		if (user != null) {
			entityManager.remove(user);
		}
		return new ResponseEntity<>("User deleted.", HttpStatus.ACCEPTED);	
	}
		else {
			return new ResponseEntity<>("User not found,", HttpStatus.NOT_FOUND);
		}
	}
	
	public List<User> findAll() {
		List<User> users = entityManager.createNativeQuery("select * from user", User.class).getResultList();	
		return users;
	}
	
	public ResponseEntity<String> updateUserById(Integer id, String name,String userRole, String email) {
		User user= entityManager.find(User.class, id);
		if(user!=null) {
			user.setName(name);
			user.setUserRole(userRole);;
			user.setEmail(email);
			return new ResponseEntity<>("User modified", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
	}
	
	public List<User> findExceptAdmin(){
		List<User> users = entityManager.createNativeQuery("SELECT * from user WHERE USER.ROLE <> 'Admin'", User.class).getResultList();	
		return users;
	}
	
}
