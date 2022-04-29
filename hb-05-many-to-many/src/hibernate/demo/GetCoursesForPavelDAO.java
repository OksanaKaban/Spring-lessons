package hibernate.demo;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForPavelDAO {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory=new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .addAnnotatedClass(Course.class)
                                            .addAnnotatedClass(Review.class)
                                            .addAnnotatedClass(Student.class)
                                            .buildSessionFactory();
        //create session
        Session session=sessionFactory.getCurrentSession();

        try {
            //start transaction
            session.beginTransaction();

            //get student Pavel from db
            int id=1;
            Student student=session.get(Student.class, id);
            System.out.println("Loaded student: "+student);
            System.out.println("Courses: "+student.getCourseList());

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
