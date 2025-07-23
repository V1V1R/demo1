package com.dongruan.service.Impl;

import com.dongruan.DTO.GridMemberLoginDTO;
import com.dongruan.DTO.StatisticsDTO;
import com.dongruan.ENTITY.Admin;
import com.dongruan.ENTITY.GridMember;
import com.dongruan.ENTITY.Statistics;
import com.dongruan.constant.MessageConstant;
import com.dongruan.constant.StatusConstant;
import com.dongruan.context.BaseContext;
import com.dongruan.exception.AccountLockedException;
import com.dongruan.exception.AccountNotFoundException;
import com.dongruan.exception.PasswordErrorException;
import com.dongruan.mapper.GridMemberMapper;
import com.dongruan.service.GridMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Slf4j
public class GridMemberServiceImpl implements GridMemberService {
    @Autowired
    private GridMemberMapper gridMemberMapper;

    /**
     * 网格员端登录
     *
     * @param gridMemberLoginDTO
     * @return
     */
    @Override
    public GridMember login(GridMemberLoginDTO gridMemberLoginDTO) {
        String gmCode = gridMemberLoginDTO.getGmCode();
        String password = gridMemberLoginDTO.getPassword();

        GridMember gridMember = gridMemberMapper.getByGmCode(gmCode);
        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (gridMember == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        // 对前端传来的明文密码进行MD5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(gridMember.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (gridMember.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3、返回实体对象
        return gridMember;
    }

    /**
     * 保存网格员提交的AQI确认信息
     *
     * @param statisticsDTO
     */
    @Override
    public void saveStatistics(StatisticsDTO statisticsDTO) {
        Statistics statistics = new Statistics();

        BeanUtils.copyProperties(statisticsDTO,statistics);

        statistics.setConfirmDate(LocalDate.now());
        statistics.setConfirmTime(LocalDateTime.now());

        statistics.setGmId(BaseContext.getCurrentId());

        gridMemberMapper.insert(statistics);


    }
}
