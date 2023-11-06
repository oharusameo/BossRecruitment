package com.harusame.bossrecruitment.api;

import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.harusame.bossrecruitment.common.utils.AliCloudSendSmsUtils;
import com.harusame.bossrecruitment.domain.dto.LoginDTO;
import com.harusame.bossrecruitment.domain.dto.SendSMSDTO;
import com.harusame.bossrecruitment.domain.pojo.Result;
import com.harusame.bossrecruitment.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/login")
@Api(tags = "登录接口", value = "LoginAPI")
public class LoginAPI {
    @Resource
    private UserService userService;

    @Resource
    private AliCloudSendSmsUtils aliCloudSendSmsUtils;

    @PostMapping("/sendCAPTCHA")
    @ApiOperation("验证手机号，发送短信验证码")
    public Result sendCAPTCHA(@RequestBody @Valid SendSMSDTO sendSMSDTO) {
        String code = aliCloudSendSmsUtils.createRandomCode();
        SendSmsResponse sendSmsResponse = aliCloudSendSmsUtils.sendSms(sendSMSDTO.getPhone(), code);
        if ("OK".equals(sendSmsResponse.getBody().getCode())) {
            return Result.success("短信验证码发送成功", code);
        }
        return Result.error("短信验证码发送失败");
    }

    @PostMapping("/loginOrRegister")
    @ApiOperation("通过手机号登录或注册")
    public Result loginOrRegister(@RequestBody @Valid LoginDTO loginDTO) {
        return Result.success(userService.loginOrRegister(loginDTO));
    }
//    eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIyIiwiZXhwIjoxNjk5ODQzOTM2fQ.RJ2y5gy44POKKJPn4Q16fOqPQNjwi8B3oK15Vz94ZXOOf533Z6HQYSCNSvariDp17gCwqGsD6iN5u80d3R8Fug
}

