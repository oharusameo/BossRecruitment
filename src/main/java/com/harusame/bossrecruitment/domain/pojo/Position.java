package com.harusame.bossrecruitment.domain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 职位表
 * @TableName t_position
 */
@TableName(value ="t_position")
@Data
public class Position implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 职位名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 工作经验(1-8)
     */
    @TableField(value = "experience")
    private Integer experience;

    /**
     * 求职类型(1:全职，2:简直)
     */
    @TableField(value = "work_type")
    private Integer workType;

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
     * 学历
     */
    @TableField(value = "level")
    private Integer level;

    /**
     * 专业
     */
    @TableField(value = "major")
    private String major;

    /**
     * 地点
     */
    @TableField(value = "city_name")
    private String cityName;

    /**
     * 曝光度
     */
    @TableField(value = "exposure")
    private Integer exposure;

    /**
     * 职位状态(1:开放，2:关闭,3待开放(审核中):,4:审核失败)
     */
    @TableField(value = "p_status")
    private Integer pStatus;

    /**
     * 职位到期时间
     */
    @TableField(value = "expire_date")
    private Date expireDate;

    /**
     * 是否竞争职位
     */
    @TableField(value = "compete")
    private Integer compete;

    /**
     * 招聘者id
     */
    @TableField(value = "boss_id")
    private Integer bossId;

    /**
     * 公司id
     */
    @TableField(value = "company_id")
    private Integer companyId;

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
        Position other = (Position) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getExperience() == null ? other.getExperience() == null : this.getExperience().equals(other.getExperience()))
            && (this.getWorkType() == null ? other.getWorkType() == null : this.getWorkType().equals(other.getWorkType()))
            && (this.getSalaryBottom() == null ? other.getSalaryBottom() == null : this.getSalaryBottom().equals(other.getSalaryBottom()))
            && (this.getSalaryTop() == null ? other.getSalaryTop() == null : this.getSalaryTop().equals(other.getSalaryTop()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
            && (this.getExposure() == null ? other.getExposure() == null : this.getExposure().equals(other.getExposure()))
            && (this.getpStatus() == null ? other.getpStatus() == null : this.getpStatus().equals(other.getpStatus()))
            && (this.getExpireDate() == null ? other.getExpireDate() == null : this.getExpireDate().equals(other.getExpireDate()))
            && (this.getCompete() == null ? other.getCompete() == null : this.getCompete().equals(other.getCompete()))
            && (this.getBossId() == null ? other.getBossId() == null : this.getBossId().equals(other.getBossId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getExperience() == null) ? 0 : getExperience().hashCode());
        result = prime * result + ((getWorkType() == null) ? 0 : getWorkType().hashCode());
        result = prime * result + ((getSalaryBottom() == null) ? 0 : getSalaryBottom().hashCode());
        result = prime * result + ((getSalaryTop() == null) ? 0 : getSalaryTop().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getExposure() == null) ? 0 : getExposure().hashCode());
        result = prime * result + ((getpStatus() == null) ? 0 : getpStatus().hashCode());
        result = prime * result + ((getExpireDate() == null) ? 0 : getExpireDate().hashCode());
        result = prime * result + ((getCompete() == null) ? 0 : getCompete().hashCode());
        result = prime * result + ((getBossId() == null) ? 0 : getBossId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", experience=").append(experience);
        sb.append(", workType=").append(workType);
        sb.append(", salaryBottom=").append(salaryBottom);
        sb.append(", salaryTop=").append(salaryTop);
        sb.append(", level=").append(level);
        sb.append(", major=").append(major);
        sb.append(", cityName=").append(cityName);
        sb.append(", exposure=").append(exposure);
        sb.append(", pStatus=").append(pStatus);
        sb.append(", expireDate=").append(expireDate);
        sb.append(", compete=").append(compete);
        sb.append(", bossId=").append(bossId);
        sb.append(", companyId=").append(companyId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}