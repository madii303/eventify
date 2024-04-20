package com.eventify.eventify.models;

public class EventBooking {
        public int Event_id;
        public int User_id;
        public String Event_type;
        public String Event_date;
        public String Event_time;
        public int No_of_people;
        public String Booking_date;
        public String Booking_time;
        public int Caterer_id;
        public int Venue_id;
        public int Decorator_id;

        public EventBooking(int user_id, String event_type, String event_date, String event_time, int no_of_people, String booking_date, String booking_time, int caterer_id, int venue_id, int decorator_id) {
                User_id = user_id;
                Event_type = event_type;
                Event_date = event_date;
                Event_time = event_time;
                No_of_people = no_of_people;
                Booking_date = booking_date;
                Booking_time = booking_time;
                Caterer_id = caterer_id;
                Venue_id = venue_id;
                Decorator_id = decorator_id;
        }

    public EventBooking() {

    }

        public int getUser_id() {
                return User_id;
        }

        public void setUser_id(int user_id) {
                User_id = user_id;
        }

        public String getEvent_type() {
                return Event_type;
        }

        public void setEvent_type(String event_type) {
                Event_type = event_type;
        }

        public String getEvent_date() {
                return Event_date;
        }

        public void setEvent_date(String event_date) {
                Event_date = event_date;
        }

        public String getEvent_time() {
                return Event_time;
        }

        public void setEvent_time(String event_time) {
                Event_time = event_time;
        }

        public int getNo_of_people() {
                return No_of_people;
        }

        public void setNo_of_people(int no_of_people) {
                No_of_people = no_of_people;
        }

        public String getBooking_date() {
                return Booking_date;
        }

        public void setBooking_date(String booking_date) {
                Booking_date = booking_date;
        }

        public String getBooking_time() {
                return Booking_time;
        }

        public void setBooking_time(String booking_time) {
                Booking_time = booking_time;
        }

        public int getCaterer_id() {
                return Caterer_id;
        }

        public void setCaterer_id(int caterer_id) {
                Caterer_id = caterer_id;
        }

        public int getVenue_id() {
                return Venue_id;
        }

        public void setVenue_id(int venue_id) {
                Venue_id = venue_id;
        }

        public int getDecorator_id() {
                return Decorator_id;
        }

        public void setDecorator_id(int decorator_id) {
                Decorator_id = decorator_id;
        }
}
