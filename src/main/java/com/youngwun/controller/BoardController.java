package com.youngwun.controller;

import com.youngwun.domain.BoardVO;
import com.youngwun.service.BoardService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    private BoardService service;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        log.info("list");
        model.addAttribute("list", service.getList());

        return "board/list";
    }

    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr) {
        log.info("register: " + board);

        service.register(board);
        rttr.addFlashAttribute("testResult", "1");
        rttr.addFlashAttribute("result", board.getBno());

        return "redirect:/board/list";
    }

    @GetMapping({"/get","/modify"})
    public void get(@RequestParam("bno") Long bno, Model model) {
        log.info("/get or modify");
        model.addAttribute("board", service.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttr) {
        log.info("modify:" + board);

        if(service.modify(board)) {
            rttr.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
        log.info("remove..." + bno);
        if(service.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }


}
