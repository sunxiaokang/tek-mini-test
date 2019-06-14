package com.tek.jzon.mini.test.converter;

import com.tek.jzon.mini.test.IllegalInputException;

import java.util.Collection;

/**
 * 数字字母映射转换接口
 */
public interface NumberLetterConverter {

    Collection<String> convert(int inputNumber) throws IllegalInputException;

}
