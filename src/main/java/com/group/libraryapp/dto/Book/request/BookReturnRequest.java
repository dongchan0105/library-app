package com.group.libraryapp.dto.Book.request;

public class BookReturnRequest {

    private String userName;
    private String bookName;

    public BookReturnRequest(String bookName, String userName) {
        this.bookName = bookName;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookName() {
        return bookName;
    }
}
