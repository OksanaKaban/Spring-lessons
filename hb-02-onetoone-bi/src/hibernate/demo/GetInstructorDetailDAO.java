package hibernate.demo;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDAO {
    public static void main(String[] args) {

        // crete session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();

        try {

            // start transaction
            session.beginTransaction();

            // get instructor detail object
            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print instructor detail
            System.out.println("instructor details: " + instructorDetail);

            // print associated instructor
            System.out.println("associated instructor: " + instructorDetail.getInstructor());

            // commit transaction
            session.getTransaction().commit();

        }  catch (Exception exception) {
             exception.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();
            sessionFactory.close();
        }
    }
}
