package com.herokuapp.realestatebk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Batdongsan;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface BatdongsanRepository extends CrudRepository<Batdongsan, Integer> {

}
