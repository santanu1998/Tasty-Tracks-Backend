package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.Exception.UserException;
import com.santanu.TastyTracks.model.User;

import java.util.List;

public interface UserService {
    public User findUserProfileByJwt(String jwt) throws UserException;

    public User findUserByEmail(String email) throws UserException;

    public List<User> findAllUsers();

    public List<User> getPendingRestaurantOwner();

    void updatePassword(User user, String newPassword);

    void sendPasswordResetEmail(User user);
}