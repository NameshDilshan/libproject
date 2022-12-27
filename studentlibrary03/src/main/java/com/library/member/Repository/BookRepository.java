/**
 * 
 */
package com.library.member.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.member.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
