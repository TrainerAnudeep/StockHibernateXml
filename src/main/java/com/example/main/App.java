package com.example.main;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.example.model.Stock;
import com.example.model.StockDailyRecord;
import com.example.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML Mapping)");
		Session session= HibernateUtil.getSessionFactory().openSession();
		try {		
	
		session.beginTransaction();
	 
			Stock stock = new Stock();
	        stock.setStockCode("101");
	        stock.setStockName("Khandoker");
	        session.save(stock);
	 
	        StockDailyRecord stockDailyRecords = new StockDailyRecord();
	        stockDailyRecords.setPriceOpen(new Float("1.2"));
	        stockDailyRecords.setPriceClose(new Float("1.1"));
	        stockDailyRecords.setPriceChange(new Float("10.0"));
	        stockDailyRecords.setVolume(3000000L);
	        stockDailyRecords.setDate(createDate(2015,4,17));
	 
	        stockDailyRecords.setStock(stock);        
	        stock.getStockDailyRecords().add(stockDailyRecords);
	 
	        session.save(stockDailyRecords);
	 
	        session.getTransaction().commit();
	        System.out.println("Done");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.shutdown();
		}
	}
	
	private static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
 }

}
