package com.wlx.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class LoginForm {
    @ApiModelProperty(value = "用户名",required = true,example = "user")
   // @NotEmpty(message = "ID不得为空")
    @javax.validation.constraints.NotEmpty(message = "ID不能为空")
    private String userName;
    @ApiModelProperty(value = "密码",example = "password")
    private String password;

}
