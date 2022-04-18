package com.herokuapp.realestatebk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.herokuapp.realestatebk.entity.Nhanvien;

@Repository
public interface NhanvienRepository extends CrudRepository<Nhanvien, Integer> {

	@Query("select nv from nhanvien nv where nv.taikhoan = :taikhoan and nv.matkhau = :matkhau")
	Nhanvien login(@Param("taikhoan") String taikhoan, @Param("matkhau") String matkhau);

	@Query("select nv from nhanvien nv where nv.taikhoan = :taikhoan")
	Nhanvien findNhanvienByTaikhoan(@Param("taikhoan") String taikhoan);

}
