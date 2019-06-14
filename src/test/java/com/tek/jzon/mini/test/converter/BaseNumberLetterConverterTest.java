package com.tek.jzon.mini.test.converter;

import com.tek.jzon.mini.test.IllegalInputException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseNumberLetterConverterTest {

    @Autowired
    private BaseNumberLetterConverter baseNumberLetterConverter;

    @Test
    public void testInputLessThanZero(){
        int input = -1;
        try {
            baseNumberLetterConverter.convert(input);
            TestCase.fail();
        }catch (IllegalInputException e){ }
    }

    @Test
    public void testInputGreaterThanNine(){
        int input = 10;
        try {
            baseNumberLetterConverter.convert(input);
            TestCase.fail();
        }catch (IllegalInputException e){ }
    }

    @Test
    public void testLegalInput(){
        int input = 5 ;
        try {
            TestCase.assertEquals(baseNumberLetterConverter.convert(input).toString(),"[J, K, L]");
        }catch (IllegalInputException e){
            TestCase.fail();
        }
    }

    @Test
    public void testLegalInputZero(){
        int input = 0 ;
        try {
            TestCase.assertEquals(baseNumberLetterConverter.convert(input).toString(),"[]");
        }catch (IllegalInputException e){
            TestCase.fail();
        }
    }

    @Test
    public void testLegalInputOne(){
        int input = 1 ;
        try {
            TestCase.assertEquals(baseNumberLetterConverter.convert(input).toString(),"[]");
        }catch (IllegalInputException e){
            TestCase.fail();
        }
    }


}
