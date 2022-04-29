package hibernate.demo;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDAO {
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

            // get instructor by primary key - id
            int id = 1;
            Instructor instructor2 = session.get(Instructor.class, id);
            System.out.println("found instructor: " + instructor2);


            // delete instructor
            if(instructor2 != null) {
                System.out.println("deleting: " + instructor2);
                // will also delete associated details object, because of CascadeType.ALL
                session.delete(instructor2);
            }

            // commit transaction
            session.getTransaction().commit();
            System.out.println("entry was update successfully");

        } finally {
            sessionFactory.close();
        }
    }
}
