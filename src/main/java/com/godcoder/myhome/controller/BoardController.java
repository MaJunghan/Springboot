package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.Board;
import com.godcoder.myhome.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;
    // @Autowired 사용해서 BoardRepository객체를 사용하겠다



    @GetMapping("/list")
    // db값 가져와야하니까 model 생성
    public String list(Model model)  {
      List<Board> boards = boardRepository.findAll();
      model.addAttribute("boards", boards);
      return "board/list";
    }
}
