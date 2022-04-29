package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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
            int id2 = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i "
             + "join fetch i.courseList where i.id =:id2", Instructor.class);
            // set parameter on query
            query.setParameter("id2", id2);

            // execute query and get instructor
            Instructor instructor1 = query.getSingleResult();
            System.out.println("Instructor: " + instructor1);

            System.out.println("courses: " + instructor1.getCourseList()); // lazy

            // commit transaction
            session.getTransaction().commit();
            session.close();

            System.out.println("session is closed ");

            System.out.println("courses: " + instructor1.getCourseList()); // lazy

                        // get courses for instructor

            System.out.println("new entity created successfully");

        } finally {
            // add cleanup code
            session.close();
            sessionFactory.close();
        }
    }
}
