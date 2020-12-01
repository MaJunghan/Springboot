package com.godcoder.myhome.validator;


import com.godcoder.myhome.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        // obj 받아와서 > 강제 board형변환
        Board b = (Board) obj;
        // StringUtils: 값이있는지체크 content값이.
        if(StringUtils.isEmpty(b.getContent())) {
            // content fild , 메시지key값 없어서 key라고 , 메시지
            errors.rejectValue("content", "key", "내용을 입력하세요");
        }
    }
}
