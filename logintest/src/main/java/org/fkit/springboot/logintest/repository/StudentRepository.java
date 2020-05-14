package org.fkit.springboot.logintest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.springboot.logintest.bean.Student;
import org.springframework.data.repository.query.Param;

public interface StudentRepository {

	@Insert("insert into tb_student(login_name,username,password) "
			+ "values(#{loginName},#{username},#{password})")
	public int insertStudent(Student student);
	
	@Select("select * from tb_student where username = #{username}")
	@ResultMap("studentResult")
	public Student selectByUsername(@Param("username") String username);
	
	@Select("select * from tb_student")
	@Results(id="studentResult", value={
			@Result(id=true,column="id",property="id"),
			@Result(column="login_name",property="loginName"),
			@Result(column="username",property="username"),
			@Result(column="password",property="password")
	})
	public List<Student> findAll();
	
	@Delete("delete from tb_student where id = #{id}")
	public void delete(@Param("id") int id);
	
	@Update("update tb_student set username=#{username} where id=#{id}")
	public void update(Student student);
}
