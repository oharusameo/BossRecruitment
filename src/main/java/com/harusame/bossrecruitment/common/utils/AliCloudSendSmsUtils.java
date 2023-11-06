package com.harusame.bossrecruitment.common.utils;

import cn.hutool.core.util.RandomUtil;
import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.google.gson.Gson;
import com.harusame.bossrecruitment.common.constant.RedisKeyConst;
import darabonba.core.client.ClientOverrideConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 阿里云发送短信工具类
 */
@Component
@Slf4j
public class AliCloudSendSmsUtils {
    @Value("${aliyun.accessKeyId}")
    private  String accessKeyId;
    @Value("${aliyun.accessKeySecret}")
    private  String accessKeySecret;
    @Value("${aliyun.signName}")
    private  String signName;
    @Value("${aliyun.templateCode}")
    private  String templateCode;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private AliCloudSendSmsUtils() {
    }


    public String createRandomCode() {
        String code = RandomUtil.randomNumbers(6);
        String key = String.format(RedisKeyConst.USER_LOGIN_CAPTCHA, code);
        stringRedisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);
        return code;
    }

    /**
     * 发送验证码方法
     *
     * @param phone
     * @param code
     * @return
     */
    public SendSmsResponse sendSms(String phone, String code) {
        AsyncClient client = null;
        try {
            StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                    .accessKeyId(accessKeyId)
                    .accessKeySecret(accessKeySecret)
                    .build());

            client = AsyncClient.builder()
                    .region("cn-hangzhou") // Region ID
                    .credentialsProvider(provider)
                    .overrideConfiguration(
                            ClientOverrideConfiguration.create()
                                    // Endpoint 请参考 https://api.aliyun.com/product/Dysmsapi
                                    .setEndpointOverride("dysmsapi.aliyuncs.com")
                                    .setConnectTimeout(Duration.ofSeconds(30))
                    )
                    .build();

            SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                    .signName(signName)
                    .templateCode(templateCode)
                    .phoneNumbers(phone)
                    .templateParam("{\"code\":\"" + code + "\"}")
                    .build();

            CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
            SendSmsResponse resp = response.get();
            log.info(new Gson().toJson(resp));
            return resp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }


}
