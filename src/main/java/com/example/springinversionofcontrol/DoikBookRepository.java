package com.example.springinversionofcontrol;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class DoikBookRepository implements BookRepository{

}
