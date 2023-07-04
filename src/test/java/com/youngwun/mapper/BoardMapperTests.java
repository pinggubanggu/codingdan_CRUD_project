package com.youngwun.mapper;

import com.youngwun.domain.BoardVO;
import com.youngwun.domain.Criteria;
import java.util.List;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/springroot/root-context.xml")
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void testGetList() {
        mapper.getList().forEach( board -> log.info(board));
    }

    @Test
    public void testInsert() {
        //given
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");

        //when
        mapper.insert(board);

        //then
        log.info(board);
    }

    @Test
    public void testInsertSelectKey() {
        //given
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");

        //when
        mapper.insertSelectKey(board);

        //then
        log.info(board);
    }

    @Test
    public void testRead() {

        // 존재하는 게시물 번호로 테스트
        BoardVO board = mapper.read(5L);

        log.info(board);
    }

    @Test
    public void testDelete() {
        log.info("DELETE COUNT: " + mapper.delete(3L));
    }

    @Test
    public void testUpdate() {
        //given
        BoardVO board = new BoardVO();
        board.setBno(5L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user00");

        //when
        int updateCount = mapper.update(board);

        //then
        log.info("UPDATE COUNT: " + updateCount);
    }

    @Test
    public void testPaging() {
        //given
        Criteria cri = new Criteria();
        cri.setPageNum(3);
        cri.setAmount(10);

        //when
        List<BoardVO> list = mapper.getListWithPaging(cri);

        //then
        list.forEach(board -> log.info(board));
    }

}
