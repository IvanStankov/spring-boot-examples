package com.ivan.sbe.wdj.service.impl;

import com.ivan.sbe.wdj.entity.Book;
import com.ivan.sbe.wdj.model.BookDto;
import com.ivan.sbe.wdj.repository.BookRepository;
import com.ivan.sbe.wdj.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Long createBook(BookDto bookDto) {
        final Book book = new Book();
        book.setName(bookDto.getName());
        book.setAuthorName(bookDto.getAuthor());
        book.setPageCount(bookDto.getPageCount());

        return this.bookRepository.save(book).getId();
    }

    @Override
    public List<BookDto> findBooks() {
        return this.bookRepository.findAll()
                .stream()
                .map(book -> {
                    final BookDto bookDto = new BookDto();
                    bookDto.setId(book.getId());
                    bookDto.setName(book.getName());
                    bookDto.setAuthor(book.getAuthorName());
                    bookDto.setPageCount(book.getPageCount());
                    return bookDto;
                })
                .collect(Collectors.toList());
    }

}
