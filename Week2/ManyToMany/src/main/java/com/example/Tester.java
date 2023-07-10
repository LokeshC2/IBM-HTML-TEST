package com.example;

import org.hibernate.Session;

import com.example.factory.MySessionFactory;
import com.example.model.InternationalAlbum;
import com.example.model.NationalAlbum;
import com.example.model.Singer;

public class Tester {
    public static void main(String[] args) {

        Singer singer1 = new Singer();
        singer1.setSingerName("Singer1");
        singer1.setSingerCountry("Country1");
        
        Singer singer2 = new Singer();
        singer2.setSingerName("Singer2");
        singer2.setSingerCountry("Country2");

        Singer singer3 = new Singer();
        singer3.setSingerName("Singer3");
        singer3.setSingerCountry("Country3");

        Singer singer4 = new Singer();
        singer4.setSingerName("Singer4");
        singer4.setSingerCountry("Country4");
        
        NationalAlbum nAlbum = new NationalAlbum();
        nAlbum.setAlbumName("Album1");
        nAlbum.setAlbumPrice("INR100");
        nAlbum.setSinger(singer4);

        NationalAlbum nAlbum2 = new NationalAlbum();
        nAlbum2.setAlbumName("Album2");
        nAlbum2.setAlbumPrice("INR200");
        nAlbum2.setSinger(singer1);
        
        InternationalAlbum iAlbum = new InternationalAlbum();
        iAlbum.setAlbumName("Album3");
        iAlbum.setAlbumLanguage("English");
        iAlbum.setAlbumPrice("USD100");
        iAlbum.setSinger(singer1);

        InternationalAlbum iAlbum2 = new InternationalAlbum();
        iAlbum2.setAlbumName("Album4");
        iAlbum2.setAlbumLanguage("English");
        iAlbum2.setAlbumPrice("USD200");
        iAlbum2.setSinger(singer2);

        Session session = MySessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(nAlbum);
        session.save(nAlbum2);
        session.save(iAlbum);
        session.save(iAlbum2);
        session.getTransaction().commit();
        session.close();
    }
}