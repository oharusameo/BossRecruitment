package com.harusame.bossrecruitment.domain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 求职者_职位中间表
 * @TableName t_seeker_position
 */
@TableName(value ="t_seeker_position")
@Data
public class SeekerPosition implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 薪资范围
     */
    @TableField(value = "salary_bottom")
    private String salaryBottom;

    /**
     * 薪资范围
     */
    @TableField(value = "salary_top")
    private String salaryTop;

    /**
     * 城市
     */
    @TableField(value = "city_name")
    private String cityName;

    /**
     * 职位id
     */
    @TableField(value = "position_id")
    private Integer positionId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 子行业id
     */
    @TableField(value = "sub_sector_id")
    private Integer subSectorId;

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
        SeekerPosition other = (SeekerPosition) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSalaryBottom() == null ? other.getSalaryBottom() == null : this.getSalaryBottom().equals(other.getSalaryBottom()))
            && (this.getSalaryTop() == null ? other.getSalaryTop() == null : this.getSalaryTop().equals(other.getSalaryTop()))
            && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
            && (this.getPositionId() == null ? other.getPositionId() == null : this.getPositionId().equals(other.getPositionId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSubSectorId() == null ? other.getSubSectorId() == null : this.getSubSectorId().equals(other.getSubSectorId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSalaryBottom() == null) ? 0 : getSalaryBottom().hashCode());
        result = prime * result + ((getSalaryTop() == null) ? 0 : getSalaryTop().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getPositionId() == null) ? 0 : getPositionId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSubSectorId() == null) ? 0 : getSubSectorId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", salaryBottom=").append(salaryBottom);
        sb.append(", salaryTop=").append(salaryTop);
        sb.append(", cityName=").append(cityName);
        sb.append(", positionId=").append(positionId);
        sb.append(", userId=").append(userId);
        sb.append(", subSectorId=").append(subSectorId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}