package com.herokuapp.realestatebk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.herokuapp.realestatebk.entity.Hinhbd;

@Repository
public interface HinhbdRepository extends CrudRepository<Hinhbd, Integer>{

	@Query("delete from Hinhbd h where h.batdongsan.bdsid=:bdsid")
	void deleteHinhbdByBdsID(@Param("bdsid") int bdsid);
}
