package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)

				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			//get the instructor detail obj
			int theId=300;
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);
			//print the instr detail
			System.out.println("tempInstructorDetail: "+tempInstructorDetail);
			//print the associated instructor
			System.out.println("The associated instructor: "+
									tempInstructorDetail.getInstructor());
			//commit			
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}

	}

}