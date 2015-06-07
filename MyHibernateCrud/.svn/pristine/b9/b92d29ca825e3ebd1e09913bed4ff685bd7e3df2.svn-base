package my.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DaoCommon<T> {

	private Session session;
	private SessionFactory factorySession;
	Class<?> clazz;
	private String boardName;

	
	/*public DaoCommon() {
		factorySession = HibernateUtil.getSessionFactory();
	}*/
	public DaoCommon(Class<?> clazz){
		this(clazz, clazz.getSimpleName());
	}
	
	public DaoCommon(Class<?> clazz, String boardName) {
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
	//연습으로 만든거임.그냥 일반 주키로 뽑아는거
	public T selectByNum(int num) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T getMember = (T) session.get(clazz, num);
		tx.commit();
		return getMember;
	}

	//스트링 값을 하나 넣어주면(주키) // numEmp, "admin";
	public T selectByField(String column, String value) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T getMember = (T) session.createCriteria(clazz).add(Restrictions.eq(column, value)).uniqueResult();
		tx.commit();
		return getMember;
	}
	
	//전체다 뽑아올때 
	@SuppressWarnings("unchecked")
	public List<?> selectList() {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = (Query) session.createQuery("from "+boardName);
		List<?> members = query.list();
		tx.commit();
		return members;
	}

	// 페이징
	public List<?> selectPageList(int page, int numPage){
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = (Query) session.createQuery("from "+boardName);

		query.setFirstResult((page-1)*numPage);
		query.setMaxResults(numPage);
		List<?> members = query.list();
		tx.commit();
		return members;
	}
	//조건 리스트 검색
	public List<?> selectListByField(String column, String value){
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<?> getMember = (List<?>) session.createCriteria(clazz).add(Restrictions.eq(column, value)).list();
		tx.commit();
		return getMember;
	}



	// insert
	public void insert(T member) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(member);
		tx.commit();
	}
	public long insertAndGetLongType(T member){
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		long id = (Long) session.save(member);
		tx.commit();
		return id;
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
	
	//그외 
	public boolean loginChk(String id, String password){
		
		return false;
	}



}
