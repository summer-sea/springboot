package com.summer.springboot.dao;

import com.summer.springboot.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * jpa 继承JpaRepository参数为实体类名称和主键类型
 *
 */
public interface BookDao extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);

    List<Book> findBookByIdGreaterThan(Integer id);

    //自定义sql 查询
    @Query(value = "select * from t_book where id =(select max(id) from t_book)",nativeQuery = true)
    Book getMaxIdBook();


    //自定义sql insert
    //因为是插入 是修改数据库操作 所以要加@Modifying
    // 和事务@Transactional
    //注意value中的问好后面的数字可加可不加 但是数字会对象参数中的位置
    @Query(value = "insert into t_book(name,author) value(?1,?2)",nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBook1(String name,String author);

    @Query(value = "insert into t_book(name,author) value(:name ,:author)",nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBook2(@Param("name")String name, @Param("author") String author);

}
