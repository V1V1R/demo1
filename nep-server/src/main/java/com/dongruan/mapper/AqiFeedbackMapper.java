package com.dongruan.mapper;

import com.dongruan.DTO.AqiFeedbackPageRequestDto;
import com.dongruan.ENTITY.AqiFeedback;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AqiFeedbackMapper {


    /**
     * 添加反馈信息
     *
     * @param aqiFeedback
     */
    @Insert("insert into aqi_feedback (tel_id,province_id,city_id,address,information,estimated_grade,af_date,af_time,state,gm_id) " +
            "values " +
            "(#{telId},#{provinceId},#{cityId},#{address},#{information},#{estimatedGrade},#{afDate},#{afTime},#{state},#{gmId})")
    void insert(AqiFeedback aqiFeedback);

    /**
     * 根据手机号查询反馈信息
     *
     * @param telId
     * @return
     */
    @Select("select * from aqi_feedback where tel_id = #{telId}")
    AqiFeedback listAqiFeedbackByTelId(String telId);

    /**
     * 分页查询反馈信息
     *
     * @param aqiFeedbackPageRequestDto
     * @return
     */
    Page<AqiFeedback> listAqiFeedbackPage(AqiFeedbackPageRequestDto aqiFeedbackPageRequestDto);

    /**
     * 根据id查询反馈信息
     *
     * @param afId
     * @return
     */
    @Select("select * from aqi_feedback where af_id = #{afId}")
    AqiFeedback getAqiFeedbackById(Long afId);

    /**
     * 分配反馈信息
     *
     * @param aqiFeedback
     */
    void updateAqiFeedbackAssign(AqiFeedback aqiFeedback);

    /**
     * 根据网格员编号查询指派给网格员的AQI反馈信息
     * @param gmId
     * @return
     */
    @Select("select * from aqi_feedback where gm_id = #{gmId} ")
    List<AqiFeedback> listAqiFeedbackByGmId(Integer gmId);

    /**
     * 修改反馈信息状态
     * @param aqiFeedback
     */
    void updateAqiFeedbackState(AqiFeedback aqiFeedback);
}
