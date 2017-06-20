package com.slowe.domain;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user WHERE name = #{name}")
	User findByName(@Param("name") String name);

	@Insert("INSERT INTO user(name,age) VALUES(#{name},#{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);

	@Insert("INSERT INTO USER(name,age) VALUES(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
	int insertByMap(Map<String, Object> map);

	@Insert("INSERT INTO user(name,age) VALUES(#{name},#{age})")
	int insertByUser(User user);

	@Update("UPDATE user SET age=#{age} WHERE name=#{name}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id = #{id}")
	void delete(Long id);

	
	
	

}
