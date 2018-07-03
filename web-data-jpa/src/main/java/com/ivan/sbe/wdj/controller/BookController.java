package com.ivan.sbe.wdj.controller;

import com.ivan.sbe.wdj.model.BookDto;
import com.ivan.sbe.wdj.service.BookService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> getBooks() {
        return bookService.findBooks();
    }

    @PostMapping
    public void saveBook(@RequestBody BookDto bookDto) {
        this.bookService.createBook(bookDto);
    }

}
