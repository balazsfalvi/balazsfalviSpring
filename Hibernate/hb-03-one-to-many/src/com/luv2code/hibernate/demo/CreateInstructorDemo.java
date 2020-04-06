package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)

				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			Instructor tempInstructor = new Instructor("Susan", "Joi", "sus@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("y2be.com", "Gamer");
			
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
			//add clean up
			session.close();
			factory.close();
		}

	}

}