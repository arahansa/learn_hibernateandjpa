package jpatest.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.EntityListeners;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


@EntityListeners(jpatest.util.AuditingFieldListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {
	
	@Version
	protected int version;
	
	@Column(name="CREATE_USER")
	protected String createUser;

	@Column(name="CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createTime;

	@Column(name="UPDATE_USER")
	protected String updateUser;

	@Column(name="UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date updateTime;
	
	private static final long serialVersionUID = 1L;
	
//	@PrePersist
//	public void insertAuditingField() {
//		Timestamp currentTime = new Timestamp(new Date().getTime());
//		setCreateTime(currentTime);
//		setCreateUser("jpaUser");
//		setUpdateTime(currentTime);
//		setUpdateUser("jpaUser");
//	}
//
//	@PreUpdate
//	public void updateAuditingField() {
//		Timestamp currentTime = new Timestamp(new Date().getTime());
//		setUpdateTime(currentTime);
//		setUpdateUser("jpaUser");
//	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getCreateUser() {
		return this.createUser;
	}
	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
