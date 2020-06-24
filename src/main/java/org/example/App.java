package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee e1 = new Employee();
        e1.setName("Employee 1");

        Employee e2 = new Employee();
        e2.setName("Employee 2");

        Employee e3 = new Employee();
        e3.setName("Employee 3");

        Project project1 = new Project();
        project1.setTitle("new project 1");

        Project project2 = new Project();
        project2.setTitle("new project 2");

        Set<Project> projects = new HashSet<>();
        projects.add(project1);
        projects.add(project2);

        e1.setProjects(projects);
//        e2.setProjects(projects);

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        Employee ee = session.get(Employee.class, 4L);

//        session.save(e1);
//        session.save(e2);
//        session.save(e3);
//
//        session.save(project1);
//        session.save(project2);
//        session.save(project3);

        t.commit();
    }
}
