package com.library.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.employee.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
