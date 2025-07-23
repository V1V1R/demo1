package com.dongruan.service.Impl;

import com.dongruan.DTO.AdminLoginDTO;
import com.dongruan.ENTITY.*;
import com.dongruan.mapper.AdminMapper;
import com.dongruan.service.AdminService;
import com.dongruan.constant.MessageConstant;
import com.dongruan.exception.AccountNotFoundException;
import com.dongruan.exception.PasswordErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员端登录
     *
     * @param adminLoginDto
     * @return
     */
    public Admin login(AdminLoginDTO adminLoginDto) {
        String adminCode = adminLoginDto.getAdminCode();
        String password = adminLoginDto.getPassword();


        Admin admin = adminMapper.getByAdminCode(adminCode);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (admin == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        // 对前端传来的明文密码进行MD5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(admin.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }


        //3、返回实体对象
        return admin;
    }



}
