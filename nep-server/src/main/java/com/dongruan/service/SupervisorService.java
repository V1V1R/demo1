package com.dongruan.service;

import com.dongruan.DTO.AqiFeedbackDTO;
import com.dongruan.DTO.GridMemberLoginDTO;
import com.dongruan.DTO.SupervisorDTO;
import com.dongruan.DTO.SupervisorLoginDTO;
import com.dongruan.ENTITY.AqiFeedback;
import com.dongruan.ENTITY.GridMember;
import com.dongruan.ENTITY.Supervisor;

public interface SupervisorService {

    /**
     * 监督员登录
     * @param supervisorLoginDTO
     * @return
     */
    Supervisor login(SupervisorLoginDTO supervisorLoginDTO);

    /**
     * 监督员注册
     * @param supervisorDTO
     */
    void saveSupervisor(SupervisorDTO supervisorDTO);

    /**
     * 添加反馈信息
     * @param aqiFeedbackDTO
     */
    void saveAqiFeedback(AqiFeedbackDTO aqiFeedbackDTO);

    /**
     * 根据手机号查询空气质量反馈
     * @param telId
     * @return
     */
    AqiFeedback listAqiFeedbackByTelId(String telId);
}
