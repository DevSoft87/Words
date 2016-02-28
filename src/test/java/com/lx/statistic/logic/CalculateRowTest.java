package com.lx.statistic.logic;

import com.lx.statistic.data.RowStatistic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sergey_PC on 26.02.2016.
 */
public class CalculateRowTest extends Assert {
    Agrigator agrigator = null;
    RowStatistic rowStatistic = null;

    @Before
    public void init(){
        agrigator = new Agrigator();
        rowStatistic = new RowStatistic();
    }
    @Test
    public void checkCalculateRowEmpty1(){
        assertNull(agrigator.calculateRow(""));
    }
    @Test
    public void checkCalculateRowEmpty2(){
        assertNull(agrigator.calculateRow(null));
    }
    @Test
    public void checkCalculateRowEmpty3(){
        assertNull(agrigator.calculateRow("       "));
    }
    @Test
    public void checkCalculateRow1(){
        String str = "Hello world 1 12 123 test";
        rowStatistic.setLongWord("world");
        rowStatistic.setShortWord("1");
        rowStatistic.setLongWordLenght(5);
        rowStatistic.setShortWordLenght(1);
        rowStatistic.setRowLenght(25);
        rowStatistic.setAverageWordLenght(3);
        rowStatistic.setCountWords(6);
        assertEquals(rowStatistic, agrigator.calculateRow(str));
    }
    @Test
    public void checkCalculateRow2(){
        String str = "1 22 333 4444 55555 - -- --------";
        rowStatistic.setLongWord("--------");
        rowStatistic.setShortWord("-");
        rowStatistic.setLongWordLenght(8);
        rowStatistic.setShortWordLenght(1);
        rowStatistic.setRowLenght(33);
        rowStatistic.setAverageWordLenght(3);
        rowStatistic.setCountWords(8);
        assertEquals(rowStatistic, agrigator.calculateRow(str));
    }

}
