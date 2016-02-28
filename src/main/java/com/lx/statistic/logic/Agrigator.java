package com.lx.statistic.logic;

import com.lx.statistic.data.FileStatistic;
import com.lx.statistic.data.RowStatistic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Sergey_PC on 23.02.2016.
 */
public class Agrigator {

    public static final String CODDING_WINDOWS_1251 = "windows-1251";
    public static final String CODDING_UTF_8        = "utf-8";

    public RowStatistic calculateRow(String str) {
        RowStatistic statistic = null;
        String currentString = null;
        StringTokenizer st = null;
        boolean isFirst = true;
        int maxLength  = 0;
        int minLength  = 0;
        int countWords = 0;
        int middleCountLetters = 0;
        String maxLenghtWord = null;
        String minLenghtWord = null;

        if (str != null && str.trim().length() > 0) {
            st = new StringTokenizer(str, " ");

            while (st.hasMoreTokens()) {
                currentString = st.nextToken();
                if (currentString.length() > 0) {
                    if (currentString.length() >= maxLength && currentString.length() > 0 || isFirst) {
                        maxLength = currentString.length();
                        maxLenghtWord = currentString;
                    }
                    if (currentString.length() <= minLength && currentString.length() > 0 || isFirst) {
                        minLength = currentString.length();
                        minLenghtWord = currentString;
                    }
                    isFirst = false;
                    middleCountLetters += currentString.length();
                    countWords++;
                }
            }
             int averageWordLenght = middleCountLetters>0 && countWords>0?middleCountLetters/countWords:0;
            statistic = new RowStatistic(maxLenghtWord, minLenghtWord, maxLength, minLength, str.trim().length(), averageWordLenght, countWords);
        }
        return statistic;
    }

    public List<RowStatistic> getRowsStatisticsByFile(File file, String coding) throws FileNotFoundException, UnsupportedEncodingException {
        List<RowStatistic> statistic = null;
        String sCurrentLine      = null;
        FileInputStream stream   = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader (stream, coding);

        try (BufferedReader br = new BufferedReader (reader);) {
            statistic = new ArrayList<>();
            while ((sCurrentLine = br.readLine()) != null) {
                statistic.add(calculateRow(sCurrentLine));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return statistic;
    }

    public FileStatistic agregateFile(List<RowStatistic> list){
        FileStatistic fileStatistic = null;
        if(list!= null && list.size()>0){
            boolean isFirst = true;
            int countWords       = 0;
            int rowLenght        = 0;
            int averageCountWords = 0;
            fileStatistic = new FileStatistic();
            RowStatistic row = null;
            for(int i=0; i<list.size(); i++){
                if((row = list.get(i))!= null){
                    if ((fileStatistic.getLongWordLenght() == null || row.getLongWordLenght() >= fileStatistic.getLongWordLenght()) || isFirst) {
                        fileStatistic.setLongWordLenght(row.getLongWordLenght());
                        fileStatistic.setLongWord(row.getLongWord());
                    }
                    if (fileStatistic.getShortWordLenght() == null || row.getShortWordLenght() <= fileStatistic.getShortWordLenght() || isFirst) {
                        fileStatistic.setShortWordLenght(row.getShortWordLenght());
                        fileStatistic.setShortWord(row.getShortWord());
                    }
                    isFirst = false;
                    averageCountWords += row.getAverageWordLenght();
                    rowLenght+= row.getRowLenght();
                    countWords+=row.getCountWords();
                }
            }
            fileStatistic.setAverageWordLenght(averageCountWords/list.size());
            fileStatistic.setRowLenght(list.size());
            fileStatistic.setCountWords(countWords);
            fileStatistic.setRows(list);
        }
        return fileStatistic;
    }
}
