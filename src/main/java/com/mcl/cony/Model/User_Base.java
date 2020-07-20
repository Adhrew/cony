package com.mcl.cony.Model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

//保证数据一致性@NotNull
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@KeySequence()
public class User_Base {
    @TableId(value = "userid", type = IdType.AUTO)
    private int userid;
    @Builder.Default
    private int userRole = 2;
    private int registerSource;
    @NotBlank private String userName;
    @NotBlank private String nickName;
    private int gender;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @NotEmpty
    private Date birthday;

    private String signature;
    private String mobile;
    private String mobileBindTime;
    @Email
    private String email;
    private String emailBindTime;
    private String face;
    private String face200;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @NotEmpty
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;

    @NotBlank private String password;

    private String realName;
}
