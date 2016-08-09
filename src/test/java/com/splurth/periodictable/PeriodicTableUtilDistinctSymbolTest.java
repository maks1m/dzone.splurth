package com.splurth.periodictable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PeriodicTableUtilDistinctSymbolTest {

    @Parameterized.Parameter(value = 0)
    public String elementName;

    @Parameterized.Parameter(value = 1)
    public int count;

    @Test
    public void getDistinctSymbols() {
        assertThat(PeriodicTableUtil.getNumberOfDistinctSymbols(elementName), is(count));
    }

    @Parameterized.Parameters(name = "{index}: {0} : {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Zuulon", 11},
                {"", 0},
                {"Aa", 1},
                {"Aaa", 1},
                {"Aba", 3},
                {null, 0}
        });
    }

}
