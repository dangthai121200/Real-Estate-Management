package com.herokuapp.realestatebk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herokuapp.realestatebk.entity.Hinhbd;

@Repository
public interface HinhbdRepository extends CrudRepository<Hinhbd, Integer>{

}
