package springmvc.controller.service;

import java.util.List;

import springmvc.controller.dao.IUserDao;
import springmvc.controller.entity.User;

public class UserManager implements IUserManager{
	private IUserDao userDao;
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public boolean delUser(String id) {
		
		return userDao.delUser(id);
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public User getUser(String id) {
		return userDao.getUser(id);
	}

	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}
	
}
