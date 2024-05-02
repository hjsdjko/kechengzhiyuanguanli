package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 作业信息
 *
 * @author 
 * @email
 */
@TableName("zuoye")
public class ZuoyeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZuoyeEntity() {

	}

	public ZuoyeEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 课程
     */
    @TableField(value = "kecheng_id")

    private Integer kechengId;


    /**
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 作业
     */
    @TableField(value = "zuoye_file")

    private String zuoyeFile;


    /**
     * 交付状态
     */
    @TableField(value = "zuoye_types")

    private Integer zuoyeTypes;


    /**
     * 教师评分
     */
    @TableField(value = "zuoye_pingfen")

    private Integer zuoyePingfen;


    /**
     * 交付时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：课程
	 */
    public Integer getKechengId() {
        return kechengId;
    }


    /**
	 * 获取：课程
	 */

    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：作业
	 */
    public String getZuoyeFile() {
        return zuoyeFile;
    }


    /**
	 * 获取：作业
	 */

    public void setZuoyeFile(String zuoyeFile) {
        this.zuoyeFile = zuoyeFile;
    }
    /**
	 * 设置：交付状态
	 */
    public Integer getZuoyeTypes() {
        return zuoyeTypes;
    }


    /**
	 * 获取：交付状态
	 */

    public void setZuoyeTypes(Integer zuoyeTypes) {
        this.zuoyeTypes = zuoyeTypes;
    }
    /**
	 * 设置：教师评分
	 */
    public Integer getZuoyePingfen() {
        return zuoyePingfen;
    }


    /**
	 * 获取：教师评分
	 */

    public void setZuoyePingfen(Integer zuoyePingfen) {
        this.zuoyePingfen = zuoyePingfen;
    }
    /**
	 * 设置：交付时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：交付时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zuoye{" +
            "id=" + id +
            ", kechengId=" + kechengId +
            ", yonghuId=" + yonghuId +
            ", zuoyeFile=" + zuoyeFile +
            ", zuoyeTypes=" + zuoyeTypes +
            ", zuoyePingfen=" + zuoyePingfen +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
