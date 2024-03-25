package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDAO;
import com.spring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			readStudent(studentDAO);
//			queryReadAll(studentDAO);
//			queryReadByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Delete all student");
		int numberOfRow = studentDAO.deleteAll();
		System.out.println("Deleted rows: " + numberOfRow);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Delete student by id");
		studentDAO.delete(7);
		System.out.println("Get all student after delete");

		List<Student> listStudent = studentDAO.findAll();

		for (Student student: listStudent) {
			System.out.println("id: " + student.getId() + " ,first name " + student.getFirstName() + " ,last name " + student.getLastName());
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		System.out.println("Get student by id");
		Student student = studentDAO.findById(1);

		System.out.println("Change student last name");
		student.setLastName("Duck");

		studentDAO.update(student);
		System.out.println("Get student after updated");

		Student studentUpdated = studentDAO.findById(1);
		System.out.println("Last name updated: " + studentUpdated.getLastName());
	}

	private void queryReadByLastName(StudentDAO studentDAO) {
		System.out.println("Get student by last name");
		List<Student> listStudent = studentDAO.findByLastName("Degurechaff");

		for (Student student: listStudent) {
			System.out.println("id: " + student.getId() + " ,first name " + student.getFirstName() + " ,last name " + student.getLastName());
		}
	}

	private void queryReadAll(StudentDAO studentDAO) {
		System.out.println("Get all student");

		List<Student> listStudent = studentDAO.findAll();

		for (Student student: listStudent) {
			System.out.println("id: " + student.getId() + " ,first name " + student.getFirstName() + " ,last name " + student.getLastName());
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student newStudent = new Student("Tanya", "Degurechaff", "tanya266@gmail.com");

		System.out.println("Saving student object...");
		studentDAO.save(newStudent);

		System.out.println("Saved student. Generated id: " + newStudent.getId());

		Student student = studentDAO.findById(newStudent.getId());
		System.out.println("Read data: " + student);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 new student objects...");
		Student newStudent1 = new Student("A", "Duck", "a266@gmail.com");
		Student newStudent2 = new Student("B", "Jeff", "b266@gmail.com");
		Student newStudent3 = new Student("C", "Joe", "c266@gmail.com");

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
