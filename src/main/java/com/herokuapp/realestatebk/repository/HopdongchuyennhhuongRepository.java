package com.herokuapp.realestatebk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Hopdongchuyennhuong;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface HopdongchuyennhhuongRepository extends CrudRepository<Hopdongchuyennhuong, Integer> {
	
	@Query("select count(cn) from hopdongchuyennhuong cn where khachhang.khid = :khid")
	int countHopdongchuyennhuongByKhID(@Param("khid") int khid);
	

	@Query("select count(cn) from hopdongchuyennhuong cn where hopdongdatcoc.dcid = :dcid")
	int countHopdongchuyennhuongByHopdongdatcocId(@Param("dcid") int dcid);
	
	@Query("select count(cn) from hopdongchuyennhuong cn where batdongsan.bdsid = :bdsid")
	int countHopdongchuyennhuongByBdsID(@Param("bdsid") int bdsid);
}
