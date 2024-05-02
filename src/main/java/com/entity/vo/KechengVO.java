package com.entity.vo;

import com.entity.KechengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 课程信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kecheng")
public class KechengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 课程名称
     */

    @TableField(value = "kecheng_name")
    private String kechengName;


    /**
     * 课程类型
     */

    @TableField(value = "kecheng_types")
    private Integer kechengTypes;


    /**
     * 课件
     */

    @TableField(value = "kecheng_file")
    private String kechengFile;


    /**
     * 视频
     */

    @TableField(value = "kecheng_video")
    private String kechengVideo;


    /**
     * 课程时间/分钟
     */

    @TableField(value = "kecheng_shijian")
    private Integer kechengShijian;


    /**
     * 负责教师
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 作业信息
     */

    @TableField(value = "zuoye_content")
    private String zuoyeContent;


    /**
     * 作业交付时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "kecheng_renzhiyaoqiu")
    private Date kechengRenzhiyaoqiu;


    /**
     * 课程详情
     */

    @TableField(value = "kecheng_content")
    private String kechengContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：课程名称
	 */
    public String getKechengName() {
        return kechengName;
    }


    /**
	 * 获取：课程名称
	 */

    public void setKechengName(String kechengName) {
        this.kechengName = kechengName;
    }
    /**
	 * 设置：课程类型
	 */
    public Integer getKechengTypes() {
        return kechengTypes;
    }


    /**
	 * 获取：课程类型
	 */

    public void setKechengTypes(Integer kechengTypes) {
        this.kechengTypes = kechengTypes;
    }
    /**
	 * 设置：课件
	 */
    public String getKechengFile() {
        return kechengFile;
    }


    /**
	 * 获取：课件
	 */

    public void setKechengFile(String kechengFile) {
        this.kechengFile = kechengFile;
    }
    /**
	 * 设置：视频
	 */
    public String getKechengVideo() {
        return kechengVideo;
    }


    /**
	 * 获取：视频
	 */

    public void setKechengVideo(String kechengVideo) {
        this.kechengVideo = kechengVideo;
    }
    /**
	 * 设置：课程时间/分钟
	 */
    public Integer getKechengShijian() {
        return kechengShijian;
    }


    /**
	 * 获取：课程时间/分钟
	 */

    public void setKechengShijian(Integer kechengShijian) {
        this.kechengShijian = kechengShijian;
    }
    /**
	 * 设置：负责教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：负责教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：作业信息
	 */
    public String getZuoyeContent() {
        return zuoyeContent;
    }


    /**
	 * 获取：作业信息
	 */

    public void setZuoyeContent(String zuoyeContent) {
        this.zuoyeContent = zuoyeContent;
    }
    /**
	 * 设置：作业交付时间
	 */
    public Date getKechengRenzhiyaoqiu() {
        return kechengRenzhiyaoqiu;
    }


    /**
	 * 获取：作业交付时间
	 */

    public void setKechengRenzhiyaoqiu(Date kechengRenzhiyaoqiu) {
        this.kechengRenzhiyaoqiu = kechengRenzhiyaoqiu;
    }
    /**
	 * 设置：课程详情
	 */
    public String getKechengContent() {
        return kechengContent;
    }


    /**
	 * 获取：课程详情
	 */

    public void setKechengContent(String kechengContent) {
        this.kechengContent = kechengContent;
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

}
