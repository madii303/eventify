package com.eventify.eventify.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.eventify.eventify.models.Caterer;
import com.eventify.eventify.models.Decorator;
import com.eventify.eventify.models.EventBooking;
import com.eventify.eventify.models.PaymentDetail;
import com.eventify.eventify.models.User;
import com.eventify.eventify.models.Venue;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {

    public DBManager(@Nullable Context context) {
        super(context, "Eventify.db", null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean logIn(String uName, String password){
        SQLiteDatabase db = getReadableDatabase();
        String[] args = {uName, password};
        Cursor c = db.rawQuery("select * from User where Username=? and Password=?", args);
        c.moveToFirst();
        if(c.isAfterLast() == false){
            c.close();
            return true;
        }else{
            c.close();
            return false;
        }
    }

    public int getUserId(String uName, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String[] args = {uName, password};
        Cursor c = db.rawQuery("select User_id from User where Username=? and Password=?", args);
        c.moveToFirst();
        if (c.isAfterLast() == false) {
            int id = Integer.parseInt(c.getString(0));
            c.close();
            return id;
        } else {
            c.close();
            return 0;
        }
    }

    public void addUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Username", user.Username);
        values.put("Password", user.Password);
        values.put("Contact_no", user.Contact_no);
        values.put("Contact_email", user.Contact_email);
        values.put("User_type", user.User_type);
        try {
            db.insertOrThrow("User", null, values);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCaterer(Caterer caterer) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", caterer.Name);
        values.put("Address", caterer.Address);
        values.put("Contact_no", caterer.Contact_no);
        values.put("Price_range", caterer.Price_range);
        try {
            db.insertOrThrow("Caterer", null, values);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDecorator(Decorator decorator) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", decorator.Name);
        values.put("Address", decorator.Address);
        values.put("Contact_no", decorator.Contact_no);
        values.put("Price_range", decorator.Price_range);
        try {
            db.insertOrThrow("Decorator", null, values);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addVenue(Venue venue) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", venue.Name);
        values.put("Address", venue.Address);
        values.put("Contact_no", venue.Contact_no);
        values.put("Price_range", venue.Price_range);
        try {
            db.insertOrThrow("Venue", null, values);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEventBooking (EventBooking eventBooking){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("User_id",eventBooking.User_id);
        values.put("Event_type",eventBooking.Event_type);
        values.put("Event_date",eventBooking.Event_date);
        values.put("Event_time",eventBooking.Event_time);
        values.put("No_of_people",eventBooking.No_of_people);
        values.put("Booking_date",eventBooking.Booking_date);
        values.put("Booking_time",eventBooking.Booking_time);
        values.put("Caterer_id",eventBooking.Caterer_id);
        values.put("Venue_id",eventBooking.Venue_id);
        values.put("Decorator_id",eventBooking.Decorator_id);

    }

    public void addPaymentDetails (PaymentDetail paymentDetail){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Event_id",paymentDetail.Event_id);
        values.put("User_id",paymentDetail.User_id);
        values.put("Card_name",paymentDetail.Card_name);
        values.put("Card_no",paymentDetail.Card_no);
        values.put("CVV",paymentDetail.CVV);
        values.put("Expire_date",paymentDetail.Expire_date);
        values.put("Caterer",paymentDetail.Caterer);
        values.put("Decorator",paymentDetail.Decorator);
        values.put("Venue",paymentDetail.Venue);
        values.put("Total",paymentDetail.Total);
    }

    public ArrayList<Caterer> getAllCaterer(){
        ArrayList<Caterer> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Caterer", null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Caterer caterer = new Caterer();
            caterer.Caterer_id = Integer.parseInt(c.getString(0));
            caterer.Name = c.getString(1);
            caterer.Address = c.getString(2);
            caterer.Contact_no = c.getString(3);
            caterer.Price_range = c.getString(4);
            data.add(caterer);
            c.moveToNext();
        }
        c.close();
        return data;
    }

    public ArrayList<Decorator> getAllDecorator(){
        ArrayList<Decorator> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Decorator", null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Decorator decorator = new Decorator();
            decorator.Decorator_id = Integer.parseInt(c.getString(0));
            decorator.Name = c.getString(1);
            decorator.Address = c.getString(2);
            decorator.Contact_no = c.getString(3);
            decorator.Price_range = c.getString(4);
            data.add(decorator);
            c.moveToNext();
        }
        c.close();
        return data;
    }

    public ArrayList<Venue> getAllVenue(){
        ArrayList<Venue> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Venue", null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Venue venue = new Venue();
            venue.Venue_id = Integer.parseInt(c.getString(0));
            venue.Name = c.getString(1);
            venue.Address = c.getString(2);
            venue.Contact_no = c.getString(3);
            venue.Price_range = c.getString(4);
            data.add(venue);
            c.moveToNext();
        }
        c.close();
        return data;
    }

    public ArrayList<EventBooking> getAllEventBookings(){
        ArrayList<EventBooking> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from EventBooking", null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            EventBooking eventBooking = new EventBooking();
            eventBooking.Event_id = Integer.parseInt(c.getString(0));
            eventBooking.User_id = Integer.parseInt(c.getString(1));
            eventBooking.Event_type = c.getString(2);
            eventBooking.Event_date = c.getString(3);
            eventBooking.Event_time = c.getString(4);
            eventBooking.No_of_people = Integer.parseInt(c.getString(5));
            eventBooking.Booking_date = c.getString(6);
            eventBooking.Booking_time = c.getString(7);
            eventBooking.Caterer_id = Integer.parseInt(c.getString(8));
            eventBooking.Venue_id = Integer.parseInt(c.getString(9));
            eventBooking.Decorator_id = Integer.parseInt(c.getString(10));
            data.add(eventBooking);
            c.moveToNext();
        }
        c.close();
        return data;
    }

    public ArrayList<EventBooking> getEventBooking(int id){
        ArrayList<EventBooking> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from EventBooking where Event_id= " + id, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            EventBooking eventBooking = new EventBooking();
            eventBooking.Event_id = Integer.parseInt(c.getString(0));
            eventBooking.User_id = Integer.parseInt(c.getString(1));
            eventBooking.Event_type = c.getString(2);
            eventBooking.Event_date = c.getString(3);
            eventBooking.Event_time = c.getString(4);
            eventBooking.No_of_people = Integer.parseInt(c.getString(5));
            eventBooking.Booking_date = c.getString(6);
            eventBooking.Booking_time = c.getString(7);
            eventBooking.Caterer_id = Integer.parseInt(c.getString(8));
            eventBooking.Venue_id = Integer.parseInt(c.getString(9));
            eventBooking.Decorator_id = Integer.parseInt(c.getString(10));
            data.add(eventBooking);
            c.moveToNext();
        }
        c.close();
        return data;
    }




    public ArrayList<Caterer> getCaterer(int id){
        ArrayList<Caterer> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Caterer where Caterer_id = "+id, null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Caterer caterer = new Caterer();
            caterer.Caterer_id = Integer.parseInt(c.getString(0));
            caterer.Name = c.getString(1);
            caterer.Address = c.getString(2);
            caterer.Contact_no = c.getString(3);
            caterer.Price_range = c.getString(4);
            data.add(caterer);
            c.moveToNext();
        }
        c.close();
        return data;
    }

    public ArrayList<Decorator> getDecorator(int id){
        ArrayList<Decorator> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Decorator where Decorator_id = "+id, null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Decorator decorator = new Decorator();
            decorator.Decorator_id = Integer.parseInt(c.getString(0));
            decorator.Name = c.getString(1);
            decorator.Address = c.getString(2);
            decorator.Contact_no = c.getString(3);
            decorator.Price_range = c.getString(4);
            data.add(decorator);
            c.moveToNext();
        }
        c.close();
        return data;
    }

    public ArrayList<Venue> getVenue(int id){
        ArrayList<Venue> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from Venue where Venue_id = "+id, null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            Venue venue = new Venue();
            venue.Venue_id = Integer.parseInt(c.getString(0));
            venue.Name = c.getString(1);
            venue.Address = c.getString(2);
            venue.Contact_no = c.getString(3);
            venue.Price_range = c.getString(4);
            data.add(venue);
            c.moveToNext();
        }
        c.close();
        return data;
    }


}
