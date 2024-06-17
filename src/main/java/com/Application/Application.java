package com.Application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Application.service.Service1;
import com.Application.student.Student;

public class Application {

	public static void main(String[] args) {
		ApplicationContext con = new AnnotationConfigApplicationContext(com.Application.config.MongoConfig.class);
			Service1 s = con.getBean(Service1.class);
			Student std1 = new Student();
			std1.setName("Aravind");
			std1.setBranch("ECE");
			std1.setClg("Scits");
			s.insert(std1);
			//Reading the Data
			Student savedStudent = s.getStudentById(std1.getId()).orElse(null);
			//updating the data
			if(savedStudent!=null) {
				s.update(savedStudent.getId(), "Naresh", "CSE", "VAAG");
			}
			//deleting the data
			if(savedStudent!=null) {
				s.delete(savedStudent.getId());
			}
	}

}
