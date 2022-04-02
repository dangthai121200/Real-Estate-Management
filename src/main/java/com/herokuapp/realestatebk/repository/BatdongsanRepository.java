package com.herokuapp.realestatebk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herokuapp.realestatebk.entity.Batdongsan;


@Repository
public interface BatdongsanRepository extends CrudRepository<Batdongsan, Integer> {

}
