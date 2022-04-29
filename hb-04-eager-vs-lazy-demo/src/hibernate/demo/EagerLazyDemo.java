package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {

        // crete session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // creat  objects
            Instructor instructor = new Instructor("Jonas111", "Jonaitis222", "jonas@one.lt");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube22.com/jonas",
                    "sports");


            // associate objects
            instructor.setInstructorDetail(instructorDetail);

            // start transaction
            session.beginTransaction();

            // get instructor from db
            int id = 1;

            Instructor instructor1 = session.get(Instructor.class, id);

            System.out.println("instructor: " + instructor1);
            System.out.println("courses: " + instructor1.getCourseList()); // lazy

            // commit transaction
            session.getTransaction().commit();
            session.close();

            System.out.println("session is closed ");

            System.out.println("courses: " + instructor1.getCourseList()); // lazy

            // since courses or lazy loaded this should faile
            // get courses for instructor

            System.out.println("new entity created successfully");

        } finally {
            // add cleanup code
            session.close();
            sessionFactory.close();
        }
    }
}
