package my.onecrud;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import my.bean.Member;

import org.junit.Before;
import org.junit.Test;

public class MemberServiceTest {

	MemberService service = new MemberService();
	private Member members[];

	@Before
	public void setUp() throws Exception {
		members = new Member[4];
		for (int i = 0; i < members.length; i++)
			members[i] = new Member("arahansa" + i, "1234", new Date());
		service.deleteAll();
		insertAllMember();
		System.out.println("다시 넣는다.");
	}

	@Test
	public void insertOneDelete() {
		service.insert(members[0]);
		System.out.println("멤버 한명 삽입완료");
		assertEquals(5, service.count());
		service.deleteAll();
		assertEquals(0, service.count());
	}

	@Test
	public void listMembers() throws Exception {
		List<Member> list =  service.getMemberList();
		assertEquals(list.get(0).getId(), "arahansa0");
		assertEquals(list.get(1).getId(), "arahansa1");
		assertEquals(list.get(2).getId(), "arahansa2");
		assertEquals(list.get(3).getId(), "arahansa3");
	}

	@Test
	public void updateMember() throws Exception {
		members[1].setId("updatedUser");
		service.update(members[1]);
		Member member = service.selectById(members[1].getId());
		for (Iterator<Member> iterator = service.getMemberList().iterator(); iterator.hasNext();)
			System.out.println((Member) iterator.next());
		assertEquals("updatedUser", member.getId());
	}

	@Test
	public void delete() throws Exception {
		service.delete(service.selectByNum(2));
		assertEquals(3, service.count());
	}
	void insertAllMember() {
		for (int i = 0; i < members.length; i++)
			service.insert(members[i]);
		System.out.println("삽입완료");
	}

}
