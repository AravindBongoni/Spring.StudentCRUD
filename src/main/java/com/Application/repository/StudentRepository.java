package com.Application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Application.student.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

}
