package my.onecrud;

import static org.junit.Assert.*;

import java.util.List;

import my.bean.BoardAritcle;

import org.junit.Before;
import org.junit.Test;

public class BoardServiceTest {

	DaoCommon<BoardAritcle> boardService;
	private int numBoardArticle = 15;

	BoardAritcle article[] = new BoardAritcle[numBoardArticle];

	@Before
	public void setUp() throws Exception {
		boardService = new DaoCommon<BoardAritcle>(BoardAritcle.class, "BoardAritcle");
		for (int i = 0; i < article.length; i++) {
			article[i] = new BoardAritcle("하이"+i, "arahansa"+i, "아라한사"+i, "내용입니다"+i);
		}

		boardService.deleteAllSetTable();
	}

	@Test
	public void insertOne() {
		boardService.insert(article[0]);
		assertEquals(1, boardService.count());
	}

	@Test
	public void insertList() throws Exception {
		insertAll();
		assertEquals(numBoardArticle, boardService.count());
	}
	//select
	@Test
	public void getOneSpecific() throws Exception {
		boardService.insert(article[0]);
		BoardAritcle getArticle = boardService.selectById("userId", "arahansa0");
		assertEquals(getArticle.getId(), article[0].getId());
	}
	@Test
	public void getList() throws Exception {
		insertAll();
		int i=0;
		List<BoardAritcle> articles = (List<BoardAritcle>) boardService.selectList();
		for (BoardAritcle boardAritcle : articles)
			assertEquals("내용입니다"+i++, boardAritcle.getContent());
	}


	@Test
	public void selectPage() throws Exception {
		insertAll();
		System.out.println("---------------------------------------");
		List<BoardAritcle> articles = (List<BoardAritcle>) boardService.selectPageList(1, 10);
		for (BoardAritcle boardAritcle : articles) {
			System.out.println(boardAritcle);
		}
		System.out.println("---------------------------------------");

	}


	//update
	@Test
	public void update() throws Exception {
		insertAll();
		article[0].setContent("이것만 변경됨");
		boardService.update(article[0]);
		BoardAritcle getArticle = boardService.selectById("userId", article[0].getUserId());
		System.out.println(getArticle);
		System.out.println(article[0]);
		assertNotSame(getArticle.getContent(), "내용입니다1");
	}

	//delete
	@Test
	public void deleteSpecific() throws Exception {
		insertAll();
		boardService.delete(article[0]);
		assertEquals(numBoardArticle-1, boardService.count());
	}



	//Common Use
	public void insertAll(){
		for (BoardAritcle member : article)
			boardService.insert(member);
	}


}
