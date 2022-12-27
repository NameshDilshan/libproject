/**
 * 
 */
package com.library.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.student.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
