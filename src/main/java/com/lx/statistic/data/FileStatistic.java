package com.lx.statistic.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by turenko on 19.02.2016.
 */

public class FileStatistic {
    private Integer id               ;
    private String  fileName         ;
    private String  longWord         ;
    private String  shortWord        ;
    private int     longWordLenght   ;
    private int     shortWordLenght  ;
    private int     rowLenght        ;
    private int     averageWordLenght;
    private int     countWords       ;
    private List<RowStatistic> rows = null;

    public FileStatistic() {
        rows = new ArrayList();
    }

    public FileStatistic(String fileName, String longWord, String shortWord, int longWordLenght, int shortWordLenght, int rowLenght, int averageWordLenght, int countWords) {
        this.fileName = fileName;
        this.longWord = longWord;
        this.shortWord = shortWord;
        this.longWordLenght = longWordLenght;
        this.shortWordLenght = shortWordLenght;
        this.rowLenght = rowLenght;
        this.averageWordLenght = averageWordLenght;
        this.countWords = countWords;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileStatistic(List<RowStatistic> rows) {
        this.rows = rows;
    }

    public String getLongWord() {
        return longWord;
    }

    public void setLongWord(String longWord) {
        this.longWord = longWord;
    }

    public String getShortWord() {
        return shortWord;
    }

    public void setShortWord(String shortWord) {
        this.shortWord = shortWord;
    }

    public Integer getLongWordLenght() {
        return longWordLenght;
    }

    public void setLongWordLenght(Integer longWordLenght) {
        this.longWordLenght = longWordLenght;
    }

    public Integer getShortWordLenght() {
        return shortWordLenght;
    }

    public void setShortWordLenght(Integer shortWordLenght) {
        this.shortWordLenght = shortWordLenght;
    }

    public int getRowLenght() {
        return rowLenght;
    }

    public void setRowLenght(Integer rowLenght) {
        this.rowLenght = rowLenght;
    }

    public Integer getAverageWordLenght() {
        return averageWordLenght;
    }

    public void setAverageWordLenght(Integer averageWordLenght) {
        this.averageWordLenght = averageWordLenght;
    }

    public int getCountWords() {
        return countWords;
    }

    public void setCountWords(int countWords) {
        this.countWords = countWords;
    }

    public List<RowStatistic> getRows() {
        return rows;
    }

    public void setRows(List<RowStatistic> rows) {
        this.rows = rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileStatistic that = (FileStatistic) o;

        if (longWordLenght != that.longWordLenght) return false;
        if (shortWordLenght != that.shortWordLenght) return false;
        if (rowLenght != that.rowLenght) return false;
        if (averageWordLenght != that.averageWordLenght) return false;
        if (countWords != that.countWords) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (longWord != null ? !longWord.equals(that.longWord) : that.longWord != null) return false;
        if (shortWord != null ? !shortWord.equals(that.shortWord) : that.shortWord != null) return false;
        return !(rows != null ? !rows.equals(that.rows) : that.rows != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (longWord != null ? longWord.hashCode() : 0);
        result = 31 * result + (shortWord != null ? shortWord.hashCode() : 0);
        result = 31 * result + longWordLenght;
        result = 31 * result + shortWordLenght;
        result = 31 * result + rowLenght;
        result = 31 * result + averageWordLenght;
        result = 31 * result + countWords;
        result = 31 * result + (rows != null ? rows.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FileStatistic{" +
                "id=" + id +
                ", longWord='" + longWord + '\'' +
                ", shortWord='" + shortWord + '\'' +
                ", longWordLenght=" + longWordLenght +
                ", shortWordLenght=" + shortWordLenght +
                ", rowLenght=" + rowLenght +
                ", averageWordLenght=" + averageWordLenght +
                ", rows=" + rows +
                '}';
    }
}
