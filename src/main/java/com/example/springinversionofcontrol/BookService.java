package com.example.springinversionofcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  BookRepository bookRepository;

  @Autowired(required = false)
  public BookService(BookRepository bookRepository){
    this.bookRepository = bookRepository;
  }

}
