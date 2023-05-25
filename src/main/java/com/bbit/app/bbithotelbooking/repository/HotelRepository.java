package com.bbit.app.bbithotelbooking.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bbit.app.bbithotelbooking.dto.Hotel;
import com.bbit.app.bbithotelbooking.dto.Room;
import com.bbit.app.bbithotelbooking.util.Queries;

@Repository
public class HotelRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void addHotel(Hotel hotel) {
    	
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("hotelName", hotel.getHotelName());
            parameterSource.addValue("address", hotel.getAddress());
            parameterSource.addValue("city", hotel.getCity());
            parameterSource.addValue("country", hotel.getCountry());

            namedParameterJdbcTemplate.update(Queries.INSERT_HOTEL, parameterSource);
    }
    
    public Hotel getHotelByName(String hotelName) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("hotelName", hotelName);

        return namedParameterJdbcTemplate.queryForObject(Queries.Get_Hotel_By_Name, parameterSource, new BeanPropertyRowMapper<>(Hotel.class));
    }
    
    public void updateHotelDetails( Hotel hotel) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("hotelName", hotel.getHotelName());
        parameterSource.addValue("address", hotel.getAddress());
        parameterSource.addValue("city", hotel.getCity());
        parameterSource.addValue("country", hotel.getCountry());

        namedParameterJdbcTemplate.update(Queries.UPDATE_HOTEL_DETAILS, parameterSource);
    }
    
    public void deleteHotelByName(String hotelName) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("hotelName", hotelName);
        
	    namedParameterJdbcTemplate.update(Queries.DELETE_HOTEL_BY_NAME, mapSqlParameterSource);
    }
    
    public List<Hotel> searchHotel(String city) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("city", city);

        return namedParameterJdbcTemplate.query(Queries.SEARCH_HOTELS_BY_CITY, parameterSource, new BeanPropertyRowMapper<>(Hotel.class));
    }
    
    public void addRoom(Room room) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("roomNumber", room.getRoomNumber());
        parameterSource.addValue("roomType", room.getRoomType());
        parameterSource.addValue("roomPrice", room.getRoomPrice());
        parameterSource.addValue("hotelName", room.getHotelName());

        namedParameterJdbcTemplate.update(Queries.INSERT_ROOM, parameterSource);
    }

    
    public List<Room> getRoomsByHotelName(String hotelName) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("hotelName", hotelName);

        return namedParameterJdbcTemplate.query(Queries.GET_ROOMS_BY_HOTEL_NAME, parameterSource, new BeanPropertyRowMapper<>(Room.class));
    }
    
    public void updateRoom(Room room) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("hotelName", room.getHotelName());
        parameterSource.addValue("roomNumber", room.getRoomNumber());
        parameterSource.addValue("roomType", room.getRoomType());
        parameterSource.addValue("roomPrice", room.getRoomPrice());
        
        namedParameterJdbcTemplate.update(Queries.UPDATE_ROOM_BY_HOTEL_NAME, parameterSource);
    }
    
    public int deleteRoomsByHotelNameAndRoomNumber(String hotelName, int roomNumber) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("hotelName", hotelName);
        parameterSource.addValue("roomNumber", roomNumber);

        return namedParameterJdbcTemplate.update(Queries.DELETE_ROOMS_BY_HOTEL_NAME_AND_ROOM_NUMBER, parameterSource);
    }

    
}
