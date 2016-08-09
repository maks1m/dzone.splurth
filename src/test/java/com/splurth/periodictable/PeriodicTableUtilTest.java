package com.splurth.periodictable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PeriodicTableUtilTest {

    @Parameterized.Parameter(value = 0)
    public String elementName;

    @Parameterized.Parameter(value = 1)
    public String elementSymbol;

    @Parameterized.Parameter(value = 2)
    public boolean isValid;

    @Test
    public void isChemicalSymbolCorrect() throws Exception {
        assertThat(PeriodicTableUtil.isChemicalSymbolCorrect(elementName, elementSymbol), is(isValid));
    }

    @Parameterized.Parameters(name = "{index}: {0} : {1} = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Boron", "b", false},
                {"Mercury", "Hg", false},
                {"Mercury", "Cy", true},
                {"Silver", "Rv", false},
                {"Magnesium", "Ma", true},
                {"Magnesium", "Am", true},
                {"Xenon", "Nn", true},
                {"Xenon", "Xx", false},
                {"Xenon", "Oo", false},
                {"Spenglerium", "Ee", true},
                {"Zeddemorium", "Zr", true},
                {"Venkmine", "Kn", true},
                {"Stantzon", "Zt", false},
                {"Melintzum", "Nn", false},
                {"Tullium", "Ty", false},
                {"Gozerium", "Ei", true},
                {"Slimyrine", "Ie", true},
                {"Slimyrine", null, false},
                {"Slimyrine", "aaa", false},
                {"Slimyrine", "aa", false},
                {"Slimyrine", "a", false},
                {"", "a", false},
                {"Abcde", "az", false},
                {"Abcde", "de", true},
                {"Abcde", "ab", true},
                {"Abcde", "bc", true},
                {"Abcde", "ea", false},
                {null, "a", false}
        });
    }

}