package com.herokuapp.realestatebk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Hinhbd;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface HinhbdRepository extends CrudRepository<Hinhbd, Integer>{

	@Query("delete from Hinhbd h where h.batdongsan.bdsid=:bdsid")
	void deleteHinhbdByBdsID(@Param("bdsid") int bdsid);
}
