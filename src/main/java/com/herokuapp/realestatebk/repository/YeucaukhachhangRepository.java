package com.herokuapp.realestatebk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Yeucaukhachhang;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface YeucaukhachhangRepository extends CrudRepository<Yeucaukhachhang, Integer> {

}
