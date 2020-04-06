package com.cei.training.hibernatebatch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cei.training.hibernatebatch.domain.BillToAddress;
import com.cei.training.hibernatebatch.domain.Customer;

public class OneToManyBatch {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		conf.setProperty("hibernate.connection.url", "jdbc:h2:mem:testdb");
		conf.setProperty("hibernate.connection.username", "sa");
		conf.setProperty("hibernate.connection.password", "");
		conf.setProperty("hibernate.ddl-auto", "none");
		conf.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		conf.setProperty("hibernate.jdbc.batch_size", "50");
		conf.setProperty("hibernate.order_inserts", "true");
		
		conf.addAnnotatedClass(Customer.class);
		conf.addAnnotatedClass(BillToAddress.class);

		try (SessionFactory sessionFactory = conf.buildSessionFactory();
				Session session = sessionFactory.openSession();) {

			for (int i = 0; i <= 200; i++) {
				Customer customer = new Customer(i, "custName-" + i, "custEmail-" + i);

				BillToAddress billToAddr1 = new BillToAddress(i, "billToAddrName-" + i, customer);
				BillToAddress billToAddr2 = new BillToAddress(i, "billToAddrName-" + i, customer);
				BillToAddress billToAddr3 = new BillToAddress(i, "billToAddrName-" + i, customer);

				customer.getBillToAddress().add(billToAddr1);
				customer.getBillToAddress().add(billToAddr2);
				customer.getBillToAddress().add(billToAddr3);

				session.save(customer);
				
				if (i % 50 == 0) {
					session.clear();
				}
			}

			session.getTransaction().commit();
		}
	}

}
