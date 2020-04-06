package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)

				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
			
			Instructor tempInstructor = new Instructor("Balazs", "Gergo", "me@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("y2.com", "Mobile2");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();

			// save the instructor (and also Instructor because of cascade)
			//
			System.out.println("Saving instructor: "+tempInstructor);
			session.save(tempInstructor);
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}