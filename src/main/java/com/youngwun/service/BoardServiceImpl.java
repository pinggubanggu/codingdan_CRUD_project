package com.youngwun.service;

import com.youngwun.domain.BoardVO;
import com.youngwun.mapper.BoardMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register....." + board);

        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get...." + bno);

        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {

        log.info("modify....." + board);

        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {

        log.info("remove...." + bno);

        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList() {

        log.info("getList.....");

        return mapper.getList();
    }
}
