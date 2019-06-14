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
public class AdvancedNumberLetterConverterTest {

    @Autowired
    private AdvancedNumberLetterConverter advancedNumberLetterConverter;
    @Test
    public void testInputLessThan0(){
        int input = -1;
        try {
            advancedNumberLetterConverter.convert(input);
            TestCase.fail();
        }catch (IllegalInputException e){ }
    }

    @Test
    public void testInputGreaterThan99(){
        int input = 100;
        try {
            advancedNumberLetterConverter.convert(input);
            TestCase.fail();
        }catch (IllegalInputException e){ }
    }
    @Test
    public void testIllegalInput0_9(){
        int input = 9;
        try {
            System.err.println(advancedNumberLetterConverter.convert(input).toString());
            TestCase.assertEquals(advancedNumberLetterConverter.convert(input).toString(),"[W, X, Y, Z]");
        }catch (IllegalInputException e){
            TestCase.fail();
        }
    }

    @Test
    public void testIllegalInput90(){
        int input = 90;
        try {
            TestCase.assertEquals(advancedNumberLetterConverter.convert(input).toString(),"[W, X, Y, Z]");
        }catch (IllegalInputException e){
            TestCase.fail();
        }
    }

    @Test
    public void testIllegalInput91(){
        int input = 91;
        try {
            System.err.println(advancedNumberLetterConverter.convert(input).toString());
            TestCase.assertEquals(advancedNumberLetterConverter.convert(input).toString(),"[W, X, Y, Z]");
        }catch (IllegalInputException e){
            TestCase.fail();
        }
    }

    @Test
    public void testIllegalInput92(){
        int input = 92;
        try {
            TestCase.assertEquals(advancedNumberLetterConverter.convert(input).toString(),"[AW, AX, AY, AZ, BW, BX, BY, BZ, CW, CX, CY, CZ]");
        }catch (IllegalInputException e){
            TestCase.fail();
        }
    }

    @Test
    public void testIllegalInput99(){
        int input = 99;
        try {
            TestCase.assertEquals(advancedNumberLetterConverter.convert(input).toString(),"[WW, WX, WY, WZ, XW, XX, XY, XZ, YW, YX, YY, YZ, ZW, ZX, ZY, ZZ]");
        }catch (IllegalInputException e){
            TestCase.fail();
        }
    }

    @Test
    public void testIllegalInput10(){
        int input = 10;
        try {
            TestCase.assertEquals(advancedNumberLetterConverter.convert(input).toString(),"[]");
        }catch (IllegalInputException e){
            TestCase.fail();
        }
    }

}
