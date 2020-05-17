package com.ascoprp.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ascoprp.model.User;

@Repository
public class UserService {

	static List<User> userList = new ArrayList<>();
	static int userCount = 5;
	static {
		userList.add(new User(1, "Krishna", "Yadav", "Kumar", "Sunderpur"));
		userList.add(new User(2, "Azad", "Khan", "Khan", "Barra"));
		userList.add(new User(3, "Adna", "Sayyed", "Sayyed", "Mau"));
		userList.add(new User(4, "Kayum", "Ansari", "Ansari", "Deoria"));
		userList.add(new User(5, "Raza", "Mirza", "Mirza", "Bindaki"));
	}

	// findAll Users
	public List<User> findAll() {
		return userList;
	}

	// save a particular User
	public User save(User user) {
		if (user.getUserId() == 0) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;
	}

	// Find a specific User
	public User findUser(int id) {
		for (User user : userList) {
			if (user.getUserId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteUser(int id) {
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getUserId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
