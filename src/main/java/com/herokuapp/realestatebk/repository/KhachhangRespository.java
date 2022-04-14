package com.herokuapp.realestatebk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.herokuapp.realestatebk.entity.Khachhang;

@Repository
public interface KhachhangRespository extends CrudRepository<Khachhang, Integer> {
	
	@Query("select count(kh) from khachhang kh where nhanvien.nvid = :nvid")
	int getKhachhangByNvID(@Param("nvid") int nvid);
}
