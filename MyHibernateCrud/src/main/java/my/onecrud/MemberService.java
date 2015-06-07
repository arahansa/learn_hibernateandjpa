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

public class MemberService {

	private Session session;
	private SessionFactory factorySession;

	public MemberService() {
		factorySession = HibernateUtil.getSessionFactory();
	}



	// 읽고 쓰고 수정하고 삭제하고
	//읽고
	public Member selectByNum(int num) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Member getMember = (Member) session.get(Member.class, num);
		tx.commit();
		return getMember;
	}

	public Member selectById(String id) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Member getMember = (Member) session.createCriteria(Member.class).add(Restrictions.eq("id", id)).uniqueResult();
		tx.commit();
		return getMember;
	}

	@SuppressWarnings("unchecked")
	public List<Member> getMemberList() {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = (Query) session.createQuery("from Member");
		List<Member> members = query.list();
		tx.commit();
		return members;
	}


	//쓰고
	public void insert(Member member) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(member);
		tx.commit();
	}

	//수정하고
	public void update(Member member) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(member);
		tx.commit();
	}
	//삭제하고
	public void delete(Member member) {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.delete(member);
		tx.commit();
	}

	// --------------------------------------------------------------

	public int deleteAll() {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		int result = session.createQuery("delete from Member").executeUpdate();
		tx.commit();
		return result;
	}

	public int deleteAllSpecific(String table){
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		int result = session.createQuery("delete from "+table).executeUpdate();
		tx.commit();
		return result;
	}

	public long count() {
		session = factorySession.getCurrentSession();
		Transaction tx = session.beginTransaction();
		long result = (Long) session.createCriteria(Member.class).setProjection(Projections.rowCount()).uniqueResult();
		tx.commit();
		return result;
	}

}
