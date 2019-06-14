package com.tek.jzon.mini.test.converter;

import com.tek.jzon.mini.test.IllegalInputException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 基础数字字母映射转换 器
 */
@Service
public class BaseNumberLetterConverter implements  NumberLetterConverter{

    public static final int BASE_NUM_MIN = 0;

    public static final int BASE_NUM_MAX = 9;

    private static final List<String>[] numberLetterMapping = new List[]{
            Collections.emptyList(),
            Collections.emptyList(),
            Arrays.asList("A","B","C"),
            Arrays.asList("D","E","F"),
            Arrays.asList("G","H","I"),
            Arrays.asList("J","K","L"),
            Arrays.asList("M","N","O"),
            Arrays.asList("P","Q","R","S"),
            Arrays.asList("T","U","V"),
            Arrays.asList("W","X","Y","Z")
    };

    /**
     * 转换输入的数字为对应的字母映射列表
     * @param inputNumber
     * @return
     * @throws Exception
     */
    public Collection<String> convert(int inputNumber) throws IllegalInputException {
        if(inputNumber < BASE_NUM_MIN || inputNumber > BASE_NUM_MAX)
            throw new IllegalInputException("Illegal input number , must in the range [0,9]");

        return numberLetterMapping[inputNumber];
    }

}
