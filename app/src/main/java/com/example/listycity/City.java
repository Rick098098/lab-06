package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     *creates a new City object with a city name and a province name
     *@param city the name of the city (like Edmonton)
     *@param province the name of the province (like Alberta)
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;}

    /**
     *gets the city name of this City object
     *@return the city name
     */
    public String getCityName(){
        return this.city;
    }

    /**
     *gets the province name of this City object
     *@return the province name
     */
    public String getProvinceName(){
        return this.province;}

    @Override
    //public int compareTo(Object o) {
        //City city = (City) o;
     //   return this.city.compareTo(city.getCityName()); // this.city refers to the city name
   // }

    /**
     *compares this City with another City by city name this is used when sorting a list of City objects
     *@param other the other City to compare with
     *@return a negative number if this City comes before other 0 if they are equal, and a positive number if it comes after
     */
    public int compareTo(City other) {
        return this.city.compareToIgnoreCase(other.getCityName());}

    /**
     *checks if this City is equal to another object
     *two City objects are considered equal if they have the same city name and the same province name
     *@param o the object to compare with
     *@return true if they are the same city and province, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return Objects.equals(city, other.city) &&
                Objects.equals(province, other.province);}
    /**
     *generates a hash code for this City
     *this works with equals() so City objects can be used in collections
     *@return the hash code value for this City
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);}


}