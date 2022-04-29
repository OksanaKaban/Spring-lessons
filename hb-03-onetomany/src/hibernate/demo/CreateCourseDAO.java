package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class CreateCourseDAO {
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

            // create some courses
            Course course = new Course("Spring");
            Course course1 = new Course("DB");

            // add courses to instructor
            instructor1.add(course);
            instructor1.add(course1);

            // save courses
            session.save(course);
            session.save(course1);

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
