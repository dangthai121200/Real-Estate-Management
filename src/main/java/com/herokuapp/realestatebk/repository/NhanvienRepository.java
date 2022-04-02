package com.herokuapp.realestatebk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herokuapp.realestatebk.entity.Nhanvien;


@Repository
public interface NhanvienRepository extends CrudRepository<Nhanvien, Integer> {

}
