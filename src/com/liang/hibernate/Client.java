package com.liang.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {
	public static void main(String[] args) {
		// 读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration().configure();
		// 建立SessionFactory
		SessionFactory factory = cfg.buildSessionFactory();

		// 取得session
		Session session = null;

		try {
			// 开启session
			session = factory.openSession();
			// 开启事务
			session.beginTransaction();
			IdCard idCard = new IdCard();
			idCard = (IdCard)session.get(IdCard.class,1);	
//			idCard.setCardNo("1234567");
//			session.save(idCard);
			Person person = new Person();
			person.setName("xiaofong2");
			person.setIdCard(idCard);
			session.save(person);
			//session.save(group);
			//User user = new User();
			//user.setId("1");
			//user.setName("ss");
			//user.setGroup(group);
			// 保存User对象
			//session.save(user);
			//session.save(user);
			// 提交事务
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					// 关闭session
					session.close();
				}
			}
		}
	}
}