package my.onecrud;

import java.util.List;

import my.bean.Member;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class ServiceCrudBackup<T> {

	private Session session;
	private SessionFactory factorySession;
	Class<?> clazz;
	private String boardName;

	public ServiceCrudBackup() {
		System.out.println("생성");
		factorySession = HibernateUtil.getSessionFactory();
	}

	public ServiceCrudBackup(Class<?> clazz, String boardName) {
		factorySession = HibernateUtil.getSessionFactory();
		setClazz(clazz);
		setBoardName(boardName);
	}

	// get&set
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	// method

	// select
	public T selectByNum(int num) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T getMember = (T) session.get(clazz, num);
		tx.commit();
		return getMember;
	}

	public T selectById(String column, String value) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T getMember = (T) session.createCriteria(clazz).add(Restrictions.eq(column, value)).uniqueResult();
		tx.commit();
		return getMember;
	}
	@SuppressWarnings("unchecked")
	public List<?> selectMemberList() {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = (Query) session.createQuery("from "+boardName);
		List<?> members = query.list();
		tx.commit();
		return members;
	}


	// insert
	public void insert(T member) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(member);
		tx.commit();
	}

	//update
	public void update(T member) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(member);
		tx.commit();
	}

	// delete
	public void delete(T member) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(member);
		tx.commit();
	}

	public void templet(Session session){

	}






	// for Test
	public int deleteAllSetTable() {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		int result = session.createQuery("delete from " + boardName).executeUpdate();
		tx.commit();
		return result;
	}

	public int deleteAllSpecific(String table) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		int result = session.createQuery("delete from " + table).executeUpdate();
		tx.commit();
		return result;
	}

	public long count() {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		long result = (Long) session.createCriteria(clazz).setProjection(Projections.rowCount()).uniqueResult();
		tx.commit();
		return result;
	}



}
