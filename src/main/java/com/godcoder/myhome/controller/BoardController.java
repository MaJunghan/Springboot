package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.Board;
import com.godcoder.myhome.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    // required는 필수값안들어오면 에러창발생 : 이미작성된글을 수정하기떄문에 id가 무조건있음 필수 no
    public String form(Model model, @RequestParam(required = false) Long id ) {
        if(id == null) {
            // id의 값no => 기존대로 board를넘겨줌
            model.addAttribute("board", new Board() );
        } else{
            // id의 값ok => db에 해당id가있는지 찾아서 board에 넣어줌.
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }
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
