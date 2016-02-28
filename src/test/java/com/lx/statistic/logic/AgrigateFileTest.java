package com.lx.statistic.logic;

import com.lx.statistic.data.FileStatistic;
import com.lx.statistic.data.RowStatistic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey_PC on 26.02.2016.
 */
public class AgrigateFileTest extends Assert{
    Agrigator agrigator = null;
    FileStatistic fileStatistic = null;
    RowStatistic rowStatistic = null;

    @Before
    public void init(){
        agrigator = new Agrigator();
        rowStatistic = new RowStatistic();
        fileStatistic = new FileStatistic();
    }
    @Test
    public void test1CheckEmpty() {
        assertNull(agrigator.agregateFile(null));
    }
    @Test
    public void test2CheckEmpty() {
        assertNull(agrigator.agregateFile(new ArrayList<RowStatistic>()));
    }
    @Test
//    public RowStatistic(String longWord, String shortWord, Integer longWordLenght, Integer shortWordLenght,
//                        Integer rowLenght, Integer averageWordLenght, Integer countWords) {

//    public FileStatistic(String fileName, String longWord, String shortWord, int longWordLenght, int shortWordLenght,
//                         int rowLenght, int averageWordLenght, int countWords) {

        public void test3CheckEmpty() {
        fileStatistic = new FileStatistic(null, "hello", "a", 5, 1, 25, 5, 16);
        List<RowStatistic> list = new ArrayList<>();
        list.add(new RowStatistic("hello", "a", 5, 1, 25, 5, 16));
        fileStatistic.setRows(list);
        assertEquals(fileStatistic, agrigator.agregateFile(list));
    }
    @Test
    public void test4CheckEmpty() {
        fileStatistic = new FileStatistic(null, "hello1", "a", 6, 1, 26, 4, 26);
        List<RowStatistic> list = new ArrayList<>();
        list.add(new RowStatistic("hello", "a", 5, 1, 25, 5, 16));
        list.add(new RowStatistic("hello1", "ab", 6, 2, 28, 3, 10));
        fileStatistic.setRows(list);
        assertEquals(fileStatistic, agrigator.agregateFile(list));
    }
}
