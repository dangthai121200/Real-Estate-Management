package com.herokuapp.realestatebk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herokuapp.realestatebk.entity.Yeucaukhachhang;

@Repository
public interface YeucaukhachhangRepository extends CrudRepository<Yeucaukhachhang, Integer> {

}
