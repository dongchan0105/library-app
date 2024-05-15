package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.Book.request.BookCreateRequest;
import com.group.libraryapp.dto.Book.request.BookReturnRequest;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestParam BookCreateRequest request){
        bookService.saveBook(request);
    }

    @PutMapping("/book/return")
    public void returnBook(@RequestParam BookReturnRequest request){
        bookService.returnBook(request);
    }
}
