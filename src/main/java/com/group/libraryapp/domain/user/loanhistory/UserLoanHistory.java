package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    private User user;

    private String bookName;
    private boolean isReturn;

    public UserLoanHistory(User user, String bookName) {
        this.user=user;
        this.bookName = bookName;
    }

    public void doReturn(){
        this.isReturn = true;
    }

    public UserLoanHistory() {}
}
