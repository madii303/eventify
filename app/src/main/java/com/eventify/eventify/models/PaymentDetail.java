package com.eventify.eventify.models;

public class PaymentDetail {
        public int Payment_id;
	    public int Event_id;
        public int User_id;
        public String Card_name;
        public int Card_no;
        public int CVV;
        public String Expire_date;
        public int Caterer;
        public int Decorator;
        public int Venue;
        public int Total;

        public PaymentDetail(int event_id, int user_id, String card_name, int card_no, int CVV, String expire_date, int caterer, int decorator, int venue, int total) {
                Event_id = event_id;
                User_id = user_id;
                Card_name = card_name;
                Card_no = card_no;
                this.CVV = CVV;
                Expire_date = expire_date;
                Caterer = caterer;
                Decorator = decorator;
                Venue = venue;
                Total = total;
        }

        public int getEvent_id() {
                return Event_id;
        }

        public void setEvent_id(int event_id) {
                Event_id = event_id;
        }

        public int getUser_id() {
                return User_id;
        }

        public void setUser_id(int user_id) {
                User_id = user_id;
        }

        public String getCard_name() {
                return Card_name;
        }

        public void setCard_name(String card_name) {
                Card_name = card_name;
        }

        public int getCard_no() {
                return Card_no;
        }

        public void setCard_no(int card_no) {
                Card_no = card_no;
        }

        public int getCVV() {
                return CVV;
        }

        public void setCVV(int CVV) {
                this.CVV = CVV;
        }

        public String getExpire_date() {
                return Expire_date;
        }

        public void setExpire_date(String expire_date) {
                Expire_date = expire_date;
        }

        public int getCaterer() {
                return Caterer;
        }

        public void setCaterer(int caterer) {
                Caterer = caterer;
        }

        public int getDecorator() {
                return Decorator;
        }

        public void setDecorator(int decorator) {
                Decorator = decorator;
        }

        public int getVenue() {
                return Venue;
        }

        public void setVenue(int venue) {
                Venue = venue;
        }

        public int getTotal() {
                return Total;
        }

        public void setTotal(int total) {
                Total = total;
        }
}
