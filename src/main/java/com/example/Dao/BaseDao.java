package com.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/6.
 */
@NoRepositoryBean
public interface BaseDao<T,PK extends Serializable> extends JpaRepository<T,PK> {

}
