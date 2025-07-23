package com.dongruan.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "nep.jwt")
@Data
public class JwtProperties {

    /**
     * 管理端生成jwt令牌相关配置
     */
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;

    /**
     * 网格员端生成jwt令牌相关配置
     */
    private String gridMemberSecretKey;
    private long gridMemberTtl;
    private String gridMemberTokenName;

    /**
     * 监督员端生成jwt令牌相关配置
     */
    private String supervisorSecretKey;
    private long supervisorTtl;
    private String supervisorTokenName;
}
