package com.dongruan.service;

import com.dongruan.DTO.AqiFeedbackAssignDTO;
import com.dongruan.DTO.AqiFeedbackPageRequestDto;
import com.dongruan.DTO.StatusUpdateDto;
import com.dongruan.ENTITY.AqiFeedback;
import com.dongruan.result.PageResult;

import java.util.List;

public interface AqiFeedbackService {

    /**
     * 分页查询所有反馈信息
     * @param aqiFeedbackPageRequestDto
     * @return
     */
    PageResult listAqiFeedbackPage(AqiFeedbackPageRequestDto aqiFeedbackPageRequestDto);

    /**
     * 通过反馈信息编号查询反馈信息
     * @param afId
     * @return
     */
    AqiFeedback getAqiFeedbackById(Long afId);

    /**
     * 修改反馈信息,指派网格员
     * @param afId
     * @param aqiFeedbackAssignDTO
     */
    void updateAqiFeedbackAssign(long afId, AqiFeedbackAssignDTO aqiFeedbackAssignDTO);

    /**
     * 通过网格员编号查询反馈信息
     * @param aqiFeedbackAssignDTO
     * @return
     */
    List<AqiFeedback> listAqiFeedbackByGmId(AqiFeedbackAssignDTO aqiFeedbackAssignDTO);

    /**
     * 反馈信息状态更新
     * @param aqiFeedbackDTO
     */
    void updateAqiFeedbackState(StatusUpdateDto aqiFeedbackDTO);
}
