package com.entity.model;

import com.entity.KechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 课程信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KechengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程名称
     */
    private String kechengName;


    /**
     * 课程类型
     */
    private Integer kechengTypes;


    /**
     * 课件
     */
    private String kechengFile;


    /**
     * 视频
     */
    private String kechengVideo;


    /**
     * 课程时间/分钟
     */
    private Integer kechengShijian;


    /**
     * 负责教师
     */
    private Integer jiaoshiId;


    /**
     * 作业信息
     */
    private String zuoyeContent;


    /**
     * 作业交付时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kechengRenzhiyaoqiu;


    /**
     * 课程详情
     */
    private String kechengContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：课程名称
	 */
    public String getKechengName() {
        return kechengName;
    }


    /**
	 * 设置：课程名称
	 */
    public void setKechengName(String kechengName) {
        this.kechengName = kechengName;
    }
    /**
	 * 获取：课程类型
	 */
    public Integer getKechengTypes() {
        return kechengTypes;
    }


    /**
	 * 设置：课程类型
	 */
    public void setKechengTypes(Integer kechengTypes) {
        this.kechengTypes = kechengTypes;
    }
    /**
	 * 获取：课件
	 */
    public String getKechengFile() {
        return kechengFile;
    }


    /**
	 * 设置：课件
	 */
    public void setKechengFile(String kechengFile) {
        this.kechengFile = kechengFile;
    }
    /**
	 * 获取：视频
	 */
    public String getKechengVideo() {
        return kechengVideo;
    }


    /**
	 * 设置：视频
	 */
    public void setKechengVideo(String kechengVideo) {
        this.kechengVideo = kechengVideo;
    }
    /**
	 * 获取：课程时间/分钟
	 */
    public Integer getKechengShijian() {
        return kechengShijian;
    }


    /**
	 * 设置：课程时间/分钟
	 */
    public void setKechengShijian(Integer kechengShijian) {
        this.kechengShijian = kechengShijian;
    }
    /**
	 * 获取：负责教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：负责教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：作业信息
	 */
    public String getZuoyeContent() {
        return zuoyeContent;
    }


    /**
	 * 设置：作业信息
	 */
    public void setZuoyeContent(String zuoyeContent) {
        this.zuoyeContent = zuoyeContent;
    }
    /**
	 * 获取：作业交付时间
	 */
    public Date getKechengRenzhiyaoqiu() {
        return kechengRenzhiyaoqiu;
    }


    /**
	 * 设置：作业交付时间
	 */
    public void setKechengRenzhiyaoqiu(Date kechengRenzhiyaoqiu) {
        this.kechengRenzhiyaoqiu = kechengRenzhiyaoqiu;
    }
    /**
	 * 获取：课程详情
	 */
    public String getKechengContent() {
        return kechengContent;
    }


    /**
	 * 设置：课程详情
	 */
    public void setKechengContent(String kechengContent) {
        this.kechengContent = kechengContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
