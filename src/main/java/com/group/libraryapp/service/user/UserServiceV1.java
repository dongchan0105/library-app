package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.request.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepositoryV1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserRepositoryV1 userRepositoryV1;

    public UserServiceV1(UserRepositoryV1 userRepositoryV1) {
        this.userRepositoryV1 = userRepositoryV1;
    }

    public void saveUser(UserCreateRequest request) {
        userRepositoryV1.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers() {
        return userRepositoryV1.getUserResponses();
    }


    public void updateUser(UserUpdateRequest request) {
        if (userRepositoryV1.isUserNotExist(request.getName())) {
            throw new IllegalArgumentException();
        }
        userRepositoryV1.updateUserName( request.getName(), request.getId());
    }

    public void deleteUser(String name) {
        if (userRepositoryV1.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userRepositoryV1.deleteUserByName(name);
    }
}