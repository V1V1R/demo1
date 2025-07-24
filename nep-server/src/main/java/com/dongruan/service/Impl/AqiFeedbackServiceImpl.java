package com.dongruan.service.Impl;

import com.dongruan.DTO.AqiFeedbackAssignDTO;
import com.dongruan.DTO.AqiFeedbackPageRequestDto;
import com.dongruan.DTO.StatusUpdateDto;
import com.dongruan.ENTITY.AqiFeedback;
import com.dongruan.VO.AqiFeedbackVO;
import com.dongruan.constant.StatusConstant;
import com.dongruan.mapper.AqiFeedbackMapper;
import com.dongruan.result.PageResult;
import com.dongruan.service.AqiFeedbackService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class AqiFeedbackServiceImpl implements AqiFeedbackService {
    @Autowired
    private AqiFeedbackMapper aqiFeedbackMapper;

    /**
     * 获取AQI反馈列表
     * @param aqiFeedbackPageRequestDto
     * @return
     */
    @Override
    public PageResult listAqiFeedbackPage(AqiFeedbackPageRequestDto aqiFeedbackPageRequestDto) {

        PageHelper.startPage(aqiFeedbackPageRequestDto.getPage(),aqiFeedbackPageRequestDto.getPageSize());

        Page<AqiFeedbackVO> page = aqiFeedbackMapper.listAqiFeedbackPage(aqiFeedbackPageRequestDto);

        long total = page.getTotal();
        List<AqiFeedbackVO> records = page.getResult();
        return new PageResult(total,records);
    }

    /**
     * 根据id查询AQI反馈
     * @param afId
     * @return
     */
    @Override
    public AqiFeedback getAqiFeedbackById(Long afId) {
        AqiFeedback aqiFeedback = aqiFeedbackMapper.getAqiFeedbackById(afId);
        return aqiFeedback;
    }

    /**
     * 更新AQI反馈的分配信息
     * @param afId
     * @param aqiFeedbackAssignDTO
     */
    @Override
    public void updateAqiFeedbackAssign(long afId, AqiFeedbackAssignDTO aqiFeedbackAssignDTO) {
        AqiFeedback  aqiFeedback = AqiFeedback.builder()
                .afId(afId)
                .state(StatusConstant.ASSIGN)
                .gmId(aqiFeedbackAssignDTO.getGmId())
                .build();


        aqiFeedback.setAssignDate(LocalDate.now());
        aqiFeedback.setAssignTime(LocalDateTime.now());

        aqiFeedbackMapper.updateAqiFeedbackAssign(aqiFeedback);

    }

    /**
     * 根据网格员id查询AQI反馈列表
     * @param aqiFeedbackAssignDTO
     * @return
     */
    @Override
    public List<AqiFeedback> listAqiFeedbackByGmId(AqiFeedbackAssignDTO aqiFeedbackAssignDTO) {
        Integer gmId = aqiFeedbackAssignDTO.getGmId();
        List<AqiFeedback> list = aqiFeedbackMapper.listAqiFeedbackByGmId(gmId);
        return list;
    }

    /**
     * 更新AQI反馈的状态
     * @param statusUpdateDto
     */
    @Override
    public void updateAqiFeedbackState(StatusUpdateDto statusUpdateDto) {
        AqiFeedback aqiFeedback = AqiFeedback.builder()
                .afId(statusUpdateDto.getAfId())
                .state(statusUpdateDto.getState())
                .build();

        aqiFeedbackMapper.updateAqiFeedbackState(aqiFeedback);
    }

}
