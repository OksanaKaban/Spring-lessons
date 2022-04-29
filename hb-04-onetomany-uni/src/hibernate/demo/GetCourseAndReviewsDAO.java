package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDAO {
    public static void main(String[] args) {

        // crete session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
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

            // get course
            int id = 10;
            Course course = session.get(Course.class, id);

            // print course
            System.out.println("Course: " + course);

            // print course reviews
            System.out.println("reviews: " + course.getReviewList()); // lazy


            // commit transaction
            session.getTransaction().commit();
            System.out.println("new entity created successfully");

        } finally {
            // add cleanup code
            session.close();
            sessionFactory.close();
        }
    }
}
