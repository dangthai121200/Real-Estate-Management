package com.herokuapp.realestatebk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Khachhang;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface KhachhangRespository extends CrudRepository<Khachhang, Integer> {

	@Query("select count(kh) from khachhang kh where nhanvien.nvid = :nvid")
	int countKhachhangByNvID(@Param("nvid") int nvid);

	@Query("select kh from khachhang kh where nhanvien.nvid = :nvid")
	Iterable<Khachhang> getKhachHangByNvId(@Param("nvid") int nvid);

}
