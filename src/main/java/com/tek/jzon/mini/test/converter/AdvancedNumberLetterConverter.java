package com.tek.jzon.mini.test.converter;

import com.tek.jzon.mini.test.IllegalInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
*处理 0 - 99 范围内的数字转换成字母列表
*/
@Service
public class AdvancedNumberLetterConverter implements NumberLetterConverter {

    public static final int ADVANCE_NUM_MAX = 99;

    @Autowired
    private BaseNumberLetterConverter baseNumberLetterConverter;


    public Collection<String> convert(int inputNumber) throws IllegalInputException {
        if (inputNumber < BaseNumberLetterConverter.BASE_NUM_MIN || inputNumber > ADVANCE_NUM_MAX)
            throw new IllegalInputException("Illegal input number , must in the range [0,99]");

        if (inputNumber <= BaseNumberLetterConverter.BASE_NUM_MAX)
            return baseNumberLetterConverter.convert(inputNumber);

        //split input
        int units = inputNumber % 10;
        int tens = (inputNumber - units) / 10;

        Collection<String> unitsLetters = baseNumberLetterConverter.convert(units);
        Collection<String> tensLetters = baseNumberLetterConverter.convert(tens);


        Collection<String> letterCombines = new ArrayList<>();
        if (CollectionUtils.isEmpty(unitsLetters) || CollectionUtils.isEmpty(tensLetters)) {
            letterCombines.addAll(tensLetters);
            letterCombines.addAll(unitsLetters);
        } else {
            //combine
            unitsLetters.stream().forEach(unitLetter -> {
                tensLetters.stream().forEach(tenLetter -> {
                    letterCombines.add(unitLetter.concat(tenLetter));
                });
            });
        }
        return letterCombines;
    }

}
