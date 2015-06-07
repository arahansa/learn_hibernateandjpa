package util;

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
	private int 페이지당글의개수=10;
	private int 블럭당페이지수=9;
	public void set페이지당글의개수(int 페이지당글의개수) {
		this.페이지당글의개수 = 페이지당글의개수;
	}
	public void set블럭당페이지수(int 블럭당페이지수) {
		this.블럭당페이지수 = 블럭당페이지수;
	}


	/*public DaoCommon() {
		factorySession = HibernateUtil.getSessionFactory();
	}*/
	public DaoCommon(Class<?> clazz){
		this(clazz, clazz.getSimpleName());
	}
	public DaoCommon(Class<?> clazz, boolean test){
		factorySession = HibernateUtil.getSessionFacWithPackageXml(clazz);
		setClazz(clazz);
		setBoardName(clazz.getSimpleName());
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
	public List<?> get페이징게시글목록(int 요청페이지){
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = (Query) session.createQuery("from "+boardName +" order by id asc");

		query.setFirstResult((요청페이지-1)*페이지당글의개수);
		query.setMaxResults(페이지당글의개수);
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

	//보드용으로 쓰일 것
	public int get총페이지수(){
		int totalArticleCount = (int) count(); //총 글의 개수
		int totalPageCount = totalArticleCount / 페이지당글의개수; // 총 페이지 개수
		if (totalArticleCount % 페이지당글의개수 != 0)
			totalPageCount++;
		return totalPageCount;
	}

	public int get시작페이지(int 요청페이지){
		return (요청페이지 - 1) / 페이지당글의개수 * 페이지당글의개수 + 1;
	}
	public int get끝페이지(int 요청페이지){
		int endPage = get시작페이지(요청페이지) + 블럭당페이지수;
		if (endPage > get총페이지수())
			endPage = get총페이지수();
		return endPage;
	}
	public int[] get시작과끝페이지(int 요청페이지){
		int[] page= new int[2];
		page[0] = get시작페이지(요청페이지);
		page[1] = get끝페이지(요청페이지);
		return page;
	}

	//그외
	public boolean loginChk(String id, String password){

		return false;
	}


	/*
	 * 원래는 이것이 진정한 다오다.
	 * int COUNT_PER_PAGE = 10;
	int totalArticleCount = (int) dao.count(); //총 글의 개수
	int totalPageCount = totalArticleCount / COUNT_PER_PAGE; // 총 페이지 개수
	if (totalArticleCount % COUNT_PER_PAGE != 0)
		totalPageCount++;

	// 화면 하단에 보일 시작, 끝 페이지 수 계산
	int beginPage = (requestPage - 1) / COUNT_PER_PAGE * COUNT_PER_PAGE + 1;
	int endPage = beginPage + 9;
	if (endPage > totalPageCount)
		endPage = totalPageCount;

	//리스트에 들어갈 요청페이지와, 페이지 개수를 넣어준다.
	List<Restaurant> restaurants = (List<Restaurant>) dao.selectPageList(requestPage, COUNT_PER_PAGE);

	for (Restaurant restaurant : restaurants)
		System.out.println(restaurant);
	System.out.println("첫 페이지 "+ beginPage);
	System.out.println("끝페이지 : "+ endPage);
	System.out.println("총 페이지 :"+totalPageCount);
	*/



}
