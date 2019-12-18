package com.example.springinversionofcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  BookRepository doikBookRepository;

  public void printBookRepository(){
    System.out.println(doikBookRepository.getClass());
  }
}
