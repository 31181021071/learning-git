package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDAO;
import com.spring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 new student objects...");
		Student newStudent1 = new Student("A", "Degurechaff", "a266@gmail.com");
		Student newStudent2 = new Student("B", "Degurechaff", "b266@gmail.com");
		Student newStudent3 = new Student("C", "Degurechaff", "c266@gmail.com");

		System.out.println("Saving 3 student objects...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);

		System.out.println("Saved student1. Generated id: " + newStudent1.getId());
		System.out.println("Saved student2. Generated id: " + newStudent2.getId());
		System.out.println("Saved student3. Generated id: " + newStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student newStudent = new Student("Tanya", "Degurechaff", "tanya266@gmail.com");

		System.out.println("Saving student object...");
		studentDAO.save(newStudent);

		System.out.println("Saved student. Generated id: " + newStudent.getId());
	}

}
