package com.entity.view;

import com.entity.ZuoyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 作业信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zuoye")
public class ZuoyeView extends ZuoyeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 交付状态的值
		*/
		private String zuoyeValue;



		//级联表 kecheng
			/**
			* 课程名称
			*/
			private String kechengName;
			/**
			* 课程类型
			*/
			private Integer kechengTypes;
				/**
				* 课程类型的值
				*/
				private String kechengValue;
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
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 作业交付时间
			*/
			private Date kechengRenzhiyaoqiu;
			/**
			* 课程详情
			*/
			private String kechengContent;

		//级联表 yonghu
			/**
			* 学生姓名
			*/
			private String yonghuName;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public ZuoyeView() {

	}

	public ZuoyeView(ZuoyeEntity zuoyeEntity) {
		try {
			BeanUtils.copyProperties(this, zuoyeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 交付状态的值
			*/
			public String getZuoyeValue() {
				return zuoyeValue;
			}
			/**
			* 设置： 交付状态的值
			*/
			public void setZuoyeValue(String zuoyeValue) {
				this.zuoyeValue = zuoyeValue;
			}










				//级联表的get和set kecheng
					/**
					* 获取： 课程名称
					*/
					public String getKechengName() {
						return kechengName;
					}
					/**
					* 设置： 课程名称
					*/
					public void setKechengName(String kechengName) {
						this.kechengName = kechengName;
					}
					/**
					* 获取： 课件
					*/
					public String getKechengFile() {
						return kechengFile;
					}
					/**
					* 设置： 课件
					*/
					public void setKechengFile(String kechengFile) {
						this.kechengFile = kechengFile;
					}
					/**
					* 获取： 视频
					*/
					public String getKechengVideo() {
						return kechengVideo;
					}
					/**
					* 设置： 视频
					*/
					public void setKechengVideo(String kechengVideo) {
						this.kechengVideo = kechengVideo;
					}
					/**
					* 获取： 课程时间/分钟
					*/
					public Integer getKechengShijian() {
						return kechengShijian;
					}
					/**
					* 设置： 课程时间/分钟
					*/
					public void setKechengShijian(Integer kechengShijian) {
						this.kechengShijian = kechengShijian;
					}
					/**
					* 获取： 负责教师
					*/
					public Integer getJiaoshiId() {
						return jiaoshiId;
					}
					/**
					* 设置： 负责教师
					*/
					public void setJiaoshiId(Integer jiaoshiId) {
						this.jiaoshiId = jiaoshiId;
					}
					/**
					* 获取： 作业信息
					*/
					public String getZuoyeContent() {
						return zuoyeContent;
					}
					/**
					* 设置： 作业信息
					*/
					public void setZuoyeContent(String zuoyeContent) {
						this.zuoyeContent = zuoyeContent;
					}
					/**
					* 获取： 作业交付时间
					*/
					public Date getKechengRenzhiyaoqiu() {
						return kechengRenzhiyaoqiu;
					}
					/**
					* 设置： 作业交付时间
					*/
					public void setKechengRenzhiyaoqiu(Date kechengRenzhiyaoqiu) {
						this.kechengRenzhiyaoqiu = kechengRenzhiyaoqiu;
					}
					/**
					* 获取： 课程详情
					*/
					public String getKechengContent() {
						return kechengContent;
					}
					/**
					* 设置： 课程详情
					*/
					public void setKechengContent(String kechengContent) {
						this.kechengContent = kechengContent;
					}







				//级联表的get和set yonghu
					/**
					* 获取： 学生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 课程类型
					*/
					public Integer getKechengTypes() {
						return kechengTypes;
					}
					/**
					* 设置： 课程类型
					*/
					public void setKechengTypes(Integer kechengTypes) {
						this.kechengTypes = kechengTypes;
					}


						/**
						* 获取： 课程类型的值
						*/
						public String getKechengValue() {
							return kechengValue;
						}
						/**
						* 设置： 课程类型的值
						*/
						public void setKechengValue(String kechengValue) {
							this.kechengValue = kechengValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}






}
