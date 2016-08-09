package com.splurth.periodictable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PeriodicTableUtilGetValidSymbolTest {

    @Parameterized.Parameter(value = 0)
    public String elementName;

    @Parameterized.Parameter(value = 1)
    public String elementSymbol;

    @Test
    public void getValidSymbol() throws Exception {
        assertThat(PeriodicTableUtil.getValidSymbol(elementName), is(elementSymbol));
    }

    @Parameterized.Parameters(name = "{index}: {0} : {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Mercury", "Cr"},
                {"Silver", "Er"},
                {"Magnesium", "Ae"},
                {"Xenon", "En"},
                {"Gozerium", "Ei"},
                {"Slimyrine", "Ie"},
                {"", ""},
                {null, ""},
                {"Aaaa", "Aa"},
                {"Aaab", "Aa"},
                {"Abcde", "Ab"}
        });
    }

}
