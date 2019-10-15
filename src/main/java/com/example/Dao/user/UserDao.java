package com.example.Dao.user;

import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/31.
 */
public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "select u from User u  where u.id>:id")
    List<User> findBy(@Param("id") Long id);


    //参数nativeQuery = true才是表明了使用原生的sql，如果不配置，默认是false，则使用HQL查询方式
    @Query(value = "select * from user where id>?1", nativeQuery = true)
    List<User> findBy2(Long id);


    /**
     * @Query注解好像只是用来查询的，但是如果配合@Modifying注解一共使用，则可以完成数据的删除、添加、更新操作
     * @Transactional更新删除需要事物处理
     * @param mobile
     * @param state
     */
    @Transactional
    @Modifying
    @Query(value = "delete from user where mobile=?1 and state=?2", nativeQuery = true)
    void delete(String mobile, String state);


    @Modifying
    @Transactional
    @Query(value = "update user set name=?2 where id=?1",nativeQuery = true)
    Integer update(Long id,String name);


















}
