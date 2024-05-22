package com.sakurapuare.taskmanager_se.Controller;

import com.sakurapuare.taskmanager_se.POJO.DTO.UserDTO;
import com.sakurapuare.taskmanager_se.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    ArrayList<UserDTO> users = new ArrayList<>();

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserDTO userDTO) {
        for (UserDTO user : users) {
            if (user.getUsername().equals(userDTO.getUsername()) && user.getPassword().equals(userDTO.getPassword())) {
                return Result.success("登录成功");
            }
        }
    }
}
