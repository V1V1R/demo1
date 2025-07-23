package com.dongruan.service.Impl;

import com.dongruan.DTO.AqiFeedbackDTO;
import com.dongruan.DTO.SupervisorDTO;
import com.dongruan.DTO.SupervisorLoginDTO;
import com.dongruan.ENTITY.AqiFeedback;
import com.dongruan.ENTITY.Supervisor;
import com.dongruan.constant.MessageConstant;
import com.dongruan.constant.StatusConstant;
import com.dongruan.context.BaseContext;
import com.dongruan.exception.AccountNotFoundException;
import com.dongruan.exception.PasswordErrorException;
import com.dongruan.mapper.AqiFeedbackMapper;
import com.dongruan.mapper.SupervisorMapper;
import com.dongruan.service.SupervisorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Slf4j
public class SupervisorServiceImpl implements SupervisorService {
    @Autowired
    private SupervisorMapper supervisorMapper;
    @Autowired
    private AqiFeedbackMapper aqiFeedbackMapper;

    /**
     * 监督员端登录
     * @param supervisorLoginDTO
     * @return
     */
    @Override
    public Supervisor login(SupervisorLoginDTO supervisorLoginDTO) {
        String telId = supervisorLoginDTO.getTelId();
        String password = supervisorLoginDTO.getPassword();

        Supervisor supervisor = supervisorMapper.getByTelId(telId);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (supervisor == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        // 对前端传来的明文密码进行MD5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(supervisor.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }


        //3、返回实体对象
        return supervisor;
    }

    /**
     * 监督员注册
     * @param supervisorDTO
     */
    @Override
    public void saveSupervisor(SupervisorDTO supervisorDTO) {
        Supervisor supervisor = new Supervisor();

        BeanUtils.copyProperties(supervisorDTO,supervisor);

        supervisor.setPassword(DigestUtils.md5DigestAsHex(supervisorDTO.getPassword().getBytes()));

        supervisor.setRemarks(MessageConstant.NULL);

        supervisorMapper.insert(supervisor);

    }

    /**
     * 添加反馈信息
     * @param aqiFeedbackDTO
     */
    @Override
    public void saveAqiFeedback(AqiFeedbackDTO aqiFeedbackDTO) {
        AqiFeedback aqiFeedback = new AqiFeedback();

        BeanUtils.copyProperties(aqiFeedbackDTO,aqiFeedback);

        aqiFeedback.setAfDate(LocalDate.now());
        aqiFeedback.setAfTime(LocalDateTime.now());

        aqiFeedback.setState(StatusConstant.NOT_ASSIGN);
        aqiFeedback.setGmId(StatusConstant.DEFAULT_NOT_ASSIGN);

        aqiFeedbackMapper.insert(aqiFeedback);
    }


    @Override
    public AqiFeedback listAqiFeedbackByTelId(String telId) {
        AqiFeedback aqiFeedback = aqiFeedbackMapper.listAqiFeedbackByTelId(telId);
        return aqiFeedback;
    }
}
