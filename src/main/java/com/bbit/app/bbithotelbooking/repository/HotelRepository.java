
package com.bbit.app.bbithotelbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbit.app.bbithotelbooking.entity.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {
	

	public HotelEntity findByName(String name);

	public void deleteById(Integer id);
	
	public HotelEntity getHotelById(Integer id);

	public List<HotelEntity> findByCountryContainingIgnoreCase(String country);
    public List<HotelEntity> findByCityContainingIgnoreCase(String city);

}