package com.dongruan.controller.admin;

import com.dongruan.DTO.AqiFeedbackAssignDTO;
import com.dongruan.DTO.AqiFeedbackPageRequestDto;
import com.dongruan.DTO.StatusUpdateDto;
import com.dongruan.ENTITY.AqiFeedback;
import com.dongruan.result.PageResult;
import com.dongruan.result.Result;
import com.dongruan.service.AqiFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/aqiFeedback")
@Api(tags = "管理员端反馈信息相关接口")
@Slf4j
public class AdminAqiFeedbackController {
    @Autowired
    private AqiFeedbackService aqiFeedbackService;

    /**
     * 分页查询所有反馈信息
     * @param aqiFeedbackPageRequestDto
     * @return
     */
    @GetMapping("/listAqiFeedbackPage")
    @ApiOperation("分页查询所有反馈信息")
    public Result<PageResult> listAqiFeedbackPage (AqiFeedbackPageRequestDto aqiFeedbackPageRequestDto){
        log.info("反馈信息查询: 参数为{}", aqiFeedbackPageRequestDto);
        PageResult pageResult = aqiFeedbackService.listAqiFeedbackPage(aqiFeedbackPageRequestDto);
        return Result.success(pageResult);

    }

    /**
     * 通过反馈信息编号查询反馈信息
     * @param afId
     * @return
     */
    @GetMapping("/{afId}")
    @ApiOperation("通过反馈信息编号查询反馈信息")
    public Result<AqiFeedback> getAqiFeedbackById (@PathVariable long afId){
        AqiFeedback aqiFeedback = aqiFeedbackService.getAqiFeedbackById(afId);
        return Result.success(aqiFeedback);
    }

    /**
     * 修改反馈信息,指派网格员
     * @param afId
     * @param aqiFeedbackAssignDTO
     * @return
     */
    @PutMapping("/{afId}")
    @ApiOperation("修改反馈信息,指派网格员")
    public Result updateAqiFeedbackAssign(@PathVariable long afId, @RequestBody AqiFeedbackAssignDTO aqiFeedbackAssignDTO){
        aqiFeedbackService.updateAqiFeedbackAssign(afId, aqiFeedbackAssignDTO);
        return Result.success();
    }

    /**
     * 通过网格员编号查询反馈信息
     * @param aqiFeedbackAssignDTO
     * @return
     */
    @GetMapping("/listAqiFeedbackByGmId")
    @ApiOperation("通过网格员编号查询反馈信息")
    public Result<List<AqiFeedback>> listAqiFeedbackByGmId(AqiFeedbackAssignDTO aqiFeedbackAssignDTO){
        List<AqiFeedback> list = aqiFeedbackService.listAqiFeedbackByGmId(aqiFeedbackAssignDTO);
        return Result.success(list);
    }

    /**
     * 反馈信息状态更新
     * @param statusUpdateDto
     * @return
     */
    @PutMapping("/updateAqiFeedbackState")
    @ApiOperation("反馈信息状态更新")
    public Result updateAqiFeedbackState(@RequestBody StatusUpdateDto statusUpdateDto){
        aqiFeedbackService.updateAqiFeedbackState(statusUpdateDto);
        return Result.success();
    }
}
