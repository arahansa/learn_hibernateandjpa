package jpatest.util;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;




public class AuditingFieldListener {

	/**
	 * Insert auditing fields: create user, create time, update user, and update
	 * time
	 */
	@PrePersist
	public void insertAuditingField(Object obj) {
		if (!(obj instanceof BaseEntity)) {
			return;
		}

		BaseEntity baseEntity = (BaseEntity) obj;
		Timestamp currentTime = new Timestamp(new Date().getTime());
		baseEntity.setCreateTime(currentTime);
		baseEntity.setUpdateTime(currentTime);

		String user = RequestContext.getLocalInstance().getUserName();
		if (user == null) {
		  user = "jpaUser";    // use default user
		}
		
		baseEntity.setCreateUser(user);
		baseEntity.setUpdateUser(user);	
	}

	/**
	 * Update auditing fields: update user, and update time
	 */
	@PreUpdate
	public void updateAuditingField(Object obj) {
		if (!(obj instanceof BaseEntity)) {
			return;
		}

		BaseEntity baseEntity = (BaseEntity) obj;
		Timestamp currentTime = new Timestamp(new Date().getTime());
		baseEntity.setUpdateTime(currentTime);

		String user = RequestContext.getLocalInstance().getUserName();
		if (user == null) {
	        user = "jpaUser2";    // use default user
		}
		
		baseEntity.setUpdateUser(user);	
	}
}
