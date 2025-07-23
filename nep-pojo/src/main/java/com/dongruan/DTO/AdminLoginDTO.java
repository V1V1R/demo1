package com.dongruan.DTO;

import lombok.Data;
import java.io.Serializable;

@Data
public class AdminLoginDTO implements Serializable {

    private String adminCode;

    private String password;

}
