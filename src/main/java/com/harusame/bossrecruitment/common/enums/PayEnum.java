package com.harusame.bossrecruitment.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum PayEnum  {
    PAY_FOR_POSITION(10, "发布职位职位费用"),

    ;

    private int value;
    private String desc;

    PayEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int getValue() {
        return value;
    }
}
