package com.ivan.sbe.wdj.service;

import com.ivan.sbe.wdj.model.BookDto;

import java.util.List;

public interface BookService {

    Long createBook(BookDto bookDto);

    List<BookDto> findBooks();
}
