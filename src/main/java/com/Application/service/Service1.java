package com.Application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Application.repository.StudentRepository;
import com.Application.student.Student;

@Service
public class Service1 {
	@Autowired
	private StudentRepository rep;
	
	public Student insert (Student std) {
		return rep.save(std);
	}
	public Optional<Student> getStudentById(String id) {
        return rep.findById(id);
    }
	public Student update(String id, String name, String branch, String clg) {
        Student student = rep.findById(id).orElseThrow(() -> new RuntimeException("Student not found")); 
        student.setName(name);
        student.setBranch(branch);
        student.setClg(clg);
        return rep.save(student);
    }
	public void delete(String id) {
        Student user = rep.findById(id).orElseThrow(() -> new RuntimeException("STudent not found"));
        rep.deleteById(id);
    }
}