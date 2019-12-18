package com.example.springinversionofcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired @Qualifier("doikBookRepository")
  BookRepository bookRepository;

  public void printBookRepository(){
    System.out.print(bookRepository.getClass());
  }
}
