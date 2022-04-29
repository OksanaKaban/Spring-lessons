package hibernate.demo;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDAO {
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
            //create a objects
            Instructor instructor=new Instructor("Jonas", "Jonaitis","jonas@jonaitis.com");
            InstructorDetail instructorDetail=new InstructorDetail("httpp://www.youtube.com/jonasMaladec", "eating");

            //associate objects
            instructor.setInstructorDetail(instructorDetail);

            //start transaction
            session.beginTransaction();

            //create course
            Course course=new Course("HTML");

            //save course
            System.out.println("Saving course: "+course);
            session.save(course);
            System.out.println("Saved course: "+course);

            //create students
            Student student=new Student("Pavel", "Mac", "opa@gut.com");
            Student student1=new Student("Agne", "Krasauskaite", "grazuole@lip.com");

            //add students to the course
            course.addStudent(student);
            course.addStudent(student1);

            //save students
            System.out.println("Saving students");
            session.save(student);
            session.save(student1);
            System.out.println("Saved students: "+course.getStudentList());

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
