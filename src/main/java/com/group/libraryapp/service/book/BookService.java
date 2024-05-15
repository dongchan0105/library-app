package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.Book.request.BookCreateRequest;
import com.group.libraryapp.dto.Book.request.BookLoanRequest;
import com.group.libraryapp.dto.Book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    private BookRepository bookRepository;
    private UserLoanHistoryRepository userLoanHistoryRepository;
    private UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request){
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        if(userLoanHistoryRepository.existsByBookNameAndIsReturn
                (book.getName(),false)){
            throw new IllegalArgumentException("이미 대출되어 있는 책 입니다");
        }

        User user = userRepository.findByName(request.getUsername())
                .orElseThrow(IllegalArgumentException::new);

        userLoanHistoryRepository.save(new UserLoanHistory(user, book.getName()));

    }
    @Transactional
    public void returnBook(BookReturnRequest request){
        User user= userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
                .orElseThrow(IllegalArgumentException::new);
        history.doReturn();
    }
}

