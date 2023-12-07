package com.eareiza.ensitech.backend.controller;

import com.eareiza.ensitech.backend.interfeces.IUserService;
import com.eareiza.ensitech.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController  extends CommonController<User, IUserService>{

}
