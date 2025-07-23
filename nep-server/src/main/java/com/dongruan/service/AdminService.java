package com.dongruan.service;

import com.dongruan.DTO.AdminLoginDTO;
import com.dongruan.ENTITY.*;

public interface AdminService {
/**
 * 管理员登录
 * @param adminLoginDto
 * @return
 */
    Admin login(AdminLoginDTO adminLoginDto);

}
