package com.herokuapp.realestatebk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herokuapp.realestatebk.entity.Loaibd;

@Repository
public interface LoaibdRepository extends CrudRepository<Loaibd, Integer>{

}
