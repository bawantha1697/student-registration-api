package com.example.studentregistration;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentregistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentregistrationApplication.class, args);
	}

	private final StudentRepository repository;

	public StudentregistrationApplication(StudentRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Student> getStudents() {
		return repository.findAll();
	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return repository.save(student);
	}
}

interface StudentRepository extends JpaRepository<Student, Long> {
}

@Entity
@Table(name = "students")
class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int age;

	public Student() {
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}