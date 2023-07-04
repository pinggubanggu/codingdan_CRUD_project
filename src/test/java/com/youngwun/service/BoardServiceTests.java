package com.youngwun.service;

import com.youngwun.domain.BoardVO;
import com.youngwun.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/springroot/root-context.xml")
@Log4j
public class BoardServiceTests {
    // BoardService 객체가 제대로 주입이 가능한지 확인

    @Autowired
    private BoardServiceImpl service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister() {
        //given
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 글 내용");
        board.setWriter("새로 작성자");

        //when
        service.register(board);

        //then
        log.info("생성된 게시물의 번호: " + board.getBno());

    }

    @Test
    public void testGetList() {

        // service.getList().forEach(board -> log.info(board));
        service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
    }

    @Test
    public void testRead() {
        log.info(service.get(5L));
    }

    @Test
    public void testDelete(){
        log.info("REMOVE RESULT:" + service.remove(5L));
    }

    @Test
    public void testUpdate() {
        //given
        BoardVO board = service.get(4L);
        if(board == null) {
            return;
        }
        //when
        board.setTitle("제목을 수정합니다.");

        //then
        log.info("MODIFY RESULT: " + service.modify(board));
    }
}
