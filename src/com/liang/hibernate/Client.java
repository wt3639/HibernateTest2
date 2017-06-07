package com.liang.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {
	public static void main(String[] args) {
		// ��ȡhibernate.cfg.xml�ļ�
		Configuration cfg = new Configuration().configure();
		// ����SessionFactory
		SessionFactory factory = cfg.buildSessionFactory();

		// ȡ��session
		Session session = null;

		try {
			// ����session
			session = factory.openSession();
			// ��������
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
			// ����User����
			//session.save(user);
			//session.save(user);
			// �ύ����
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// �ع�����
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					// �ر�session
					session.close();
				}
			}
		}
	}
}