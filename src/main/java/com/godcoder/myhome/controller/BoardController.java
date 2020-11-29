package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.Board;
import com.godcoder.myhome.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;
    // @Autowired 사용해서 BoardRepository객체를 사용하겠다


    // db에 있는 테이블을 list로 뿌리는 메서드
    @GetMapping("/list")
    // db값 가져와야하니까 model 생성
    public String list(Model model)  {
      List<Board> boards = boardRepository.findAll();
      model.addAttribute("boards", boards);
      return "board/list";
    }

    // form.html의 데이터를 모델에담아서 해당모델 Board()를 자기자신에게보냄
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("board", new Board() );
        return "board/form";
    }

    //  ModelAttribute 반환받아서 그걸 db에 save 하고 list페이지로가는것.
    @PostMapping("/form")
    public String greetingSubmit(@ModelAttribute Board board) {
        // save : key값이 있으면 update 없으면 insert
        boardRepository.save(board);
        return "redirect:/board/list";
    }

}
