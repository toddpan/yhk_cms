package com.ykh.dao.conference.domain;


import javax.persistence.*;

@Entity
@Table
public class ConfJoinTempConf implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer confId;
	private Integer tempConfId;
//	private Integer status;			//旧意义：1新建  2 结束；新意义：不使用
	private Integer bmsStatus;//旧意义：0新建  1 会议已创建	3会议已开始；新意义：0新建,  1 会议已创建, 2会议已开始, 3已结束，4 未找到
	@Transient
	private boolean needCreate = false;		//用于用户加入时，判断是否需要create conf，只在内存中使用，不需要保存到数据库
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getConfId() {
		return confId;
	}

	public void setConfId(Integer confId) {
		this.confId = confId;
	}

	public Integer getTempConfId() {
		return tempConfId;
	}

	public void setTempConfId(Integer tempConfId) {
		this.tempConfId = tempConfId;
	}


	public Integer getBmsStatus() {
		return bmsStatus;
	}
	public void setBmsStatus(Integer bmsStatus) {
		this.bmsStatus = bmsStatus;
	}
	public boolean isNeedCreate() {
		return needCreate;
	}
	public void setNeedCreate(boolean needCreate) {
		this.needCreate = needCreate;
	}

	public static class Bulider{
		private  ConfJoinTempConf confJoinTempConf =new ConfJoinTempConf();

		public Bulider confId(Integer confId){
			this.confJoinTempConf.confId=confId;
			return  this;
		}
		public Bulider tempConfId(Integer tempConfId){
			this.confJoinTempConf.tempConfId=tempConfId;
			return this;
		}
		//	private Integer status;			//旧意义：1新建  2 结束；新意义：不使用
		public Bulider bmsStatus(Integer bmsStatus){
			this.confJoinTempConf.bmsStatus=bmsStatus;
			return  this;
		}

		public ConfJoinTempConf create(){
			return this.confJoinTempConf;
		}
	}
}
