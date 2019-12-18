package com.example.springinversionofcontrol;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  List<BookRepository> bookRepository;

  public void printBookRepository(){
    this.bookRepository.forEach(System.out::println);
  }
}
