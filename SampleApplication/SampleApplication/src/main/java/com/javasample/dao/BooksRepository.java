package com.javasample.dao;

import org.springframework.data.repository.CrudRepository;  
import com.javasample.model.Books;  
//repository that extends CrudRepository  
public interface BooksRepository extends CrudRepository<Books, Integer>  
{  
}  