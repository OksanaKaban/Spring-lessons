package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDAO {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory=new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .addAnnotatedClass(Course.class)
                                            .addAnnotatedClass(Review.class)
                                            .buildSessionFactory();
        //create session
        Session session=sessionFactory.getCurrentSession();

        try {
            //create a objects
            Instructor instructor=new Instructor("Jonas", "Jonaitis","jonas@jonaitis.com");
            InstructorDetail instructorDetail=new InstructorDetail("httpp://www.youtube.com/jonasMaladec", "eating");

            //associate objects
            instructor.setInstructorDetail(instructorDetail);

            //start transaction
            session.beginTransaction();

            //create course
            Course course=new Course("HTML");

            //add some reviews
            course.addReview(new Review("Super course"));
            course.addReview(new Review("Good course"));
            course.addReview(new Review("Bad course, you are an idiot"));

            //save course and leverage cascade all
            System.out.println("Saving course"+course);
            System.out.println("Saving reviews"+course.getReviewList());
            session.save(course);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("New entry was created successfully");
        } finally {
            //add cleanup code
            session.close();
            sessionFactory.close();
        }
    }
}
