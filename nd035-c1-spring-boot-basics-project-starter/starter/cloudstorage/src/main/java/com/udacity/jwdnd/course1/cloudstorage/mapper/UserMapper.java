package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.course1.cloudstorage.model.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USERS")
	public List<User> findAllUsers();
	
	@Select("SELECT * FROM USERS WHERE username = #{username}")
	User findUser(final String username);
	
	@Insert("INSERT INTO USERS(username, salt, password, firstname, lastname)" + 
	       " VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
	
	@Options(useGeneratedKeys = true, keyProperty = "userId")
	int createUser(User user);
}
