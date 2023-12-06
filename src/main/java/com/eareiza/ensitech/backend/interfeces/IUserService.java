package com.eareiza.ensitech.backend.interfeces;

import com.eareiza.ensitech.backend.model.User;

import java.util.List;

public interface IUserService extends ICommonService<User> {

    public User findByUsername(String username);

}
