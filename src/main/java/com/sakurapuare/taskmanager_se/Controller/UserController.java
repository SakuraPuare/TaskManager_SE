package com.sakurapuare.taskmanager_se.Controller;

import com.sakurapuare.taskmanager_se.POJO.DTO.UserDTO;
import com.sakurapuare.taskmanager_se.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Slf4j
@Tag(name = "用户管理")
@RequestMapping("/user")
public class UserController {

    ArrayList<UserDTO> users = new ArrayList<>();

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<String> login(@RequestBody UserDTO userDTO) {
        for (UserDTO user : users) {
            if (user.getUsername().equals(userDTO.getUsername()) && user.getPassword().equals(userDTO.getPassword())) {
                return Result.success("登录成功");
            }
        }
    }

    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public Result<String> register(@RequestBody UserDTO userDTO){
        for (UserDTO user : users) {
            if (user.getUsername().equals(userDTO.getUsername()) && user.getPassword().equals(userDTO.getPassword())) {
                return Result.error("该账号已被注册");
            }
        }
        users.add(userDTO);
        return Result.success("注册成功");
    }
}
