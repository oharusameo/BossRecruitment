package com.harusame.bossrecruitment.domain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 求职者表
 * @TableName t_seeker
 */
@TableName(value ="t_seeker")
@Data
public class Seeker implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 求职状态
     */
    @TableField(value = "availability")
    private Integer availability;

    /**
     * 牛人身份 1:学生，2:职场人
     */
    @TableField(value = "identity")
    private Integer identity;

    /**
     * 学历:1-8
     */
    @TableField(value = "level")
    private Integer level;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 理想的工作城市id
     */
    @TableField(value = "city_id")
    private Integer cityId;

    /**
     * 期望职位
     */
    @TableField(value = "position")
    private String position;

    /**
     * 个人优势
     */
    @TableField(value = "advantage")
    private String advantage;

    /**
     * 首次参加工作时间
     */
    @TableField(value = "first_employed_date")
    private Date firstEmployedDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Seeker other = (Seeker) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAvailability() == null ? other.getAvailability() == null : this.getAvailability().equals(other.getAvailability()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getAdvantage() == null ? other.getAdvantage() == null : this.getAdvantage().equals(other.getAdvantage()))
            && (this.getFirstEmployedDate() == null ? other.getFirstEmployedDate() == null : this.getFirstEmployedDate().equals(other.getFirstEmployedDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAvailability() == null) ? 0 : getAvailability().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getAdvantage() == null) ? 0 : getAdvantage().hashCode());
        result = prime * result + ((getFirstEmployedDate() == null) ? 0 : getFirstEmployedDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", availability=").append(availability);
        sb.append(", identity=").append(identity);
        sb.append(", level=").append(level);
        sb.append(", userId=").append(userId);
        sb.append(", birthday=").append(birthday);
        sb.append(", cityId=").append(cityId);
        sb.append(", position=").append(position);
        sb.append(", advantage=").append(advantage);
        sb.append(", firstEmployedDate=").append(firstEmployedDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}