package hibernate.demo;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDAO {
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
            int id = 3;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print instructor detail
            System.out.println("instructor details: " + instructorDetail);

            // print associated instructor
            System.out.println("associated instructor: " + instructorDetail.getInstructor());

            // now let's delete the instructor detail along with instructor!!!
            System.out.println("deleting instructor detail: " + instructorDetail);
            // remove associated object reference
            // break bi- directional link
            instructorDetail.getInstructor().setInstructorDetail(null); // istrinsim tik instructor details!!

            session.delete(instructorDetail);

            // commit transaction
            session.getTransaction().commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            // handle connection leak issue
            session.close();
            sessionFactory.close();
        }
    }
}
