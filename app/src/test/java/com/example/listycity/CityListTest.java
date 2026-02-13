package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    public City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });}
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));}
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        assertFalse(cityList.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDeleteRemovesCity() {
        CityList cityList = mockCityList();
        cityList.delete(mockCity());
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(mockCity()));}
   // @Test
   // void testDeleteThrowsException() {
     //   CityList cityList = mockCityList();
      //  City notInList = new City("Calgary", "Alberta");
     //   assertThrows(IllegalArgumentException.class, () -> cityList.delete(notInList));}
    @Test
    void testDeleteThrowsException() {
        CityList cityList = mockCityList();
        City notInList = new City("Calgary", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(notInList));}

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        cityList.add(new City("Edmonton", "Alberta"));
        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());}

}