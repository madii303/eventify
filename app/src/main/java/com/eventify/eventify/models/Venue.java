package com.eventify.eventify.models;

public class Venue {
    public int Venue_id;
    public String Name;
    public String Address;
    public String Contact_no;
    public String Price_range;

    public Venue(String name, String address, String contact_no, String price_range) {
        Name = name;
        Address = address;
        Contact_no = contact_no;
        Price_range = price_range;
    }

    public Venue() {

    }

    public int getVenue_id() {
        return Venue_id;
    }

    public void setVenue_id(int venue_id) {
        Venue_id = venue_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public String getPrice_range() {
        return Price_range;
    }

    public void setPrice_range(String price_range) {
        Price_range = price_range;
    }
}
