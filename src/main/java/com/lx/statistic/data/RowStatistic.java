package com.lx.statistic.data;


/**
 * Created by turenko on 19.02.2016.
 */

public class RowStatistic {

    private Integer id               ;
    private Integer extId            ;
    private String  longWord         ;
    private String  shortWord        ;
    private Integer longWordLenght   ;
    private Integer shortWordLenght  ;
    private Integer rowLenght        ;
    private Integer averageWordLenght;
    private Integer countWords       ;

    public RowStatistic() {}

    public RowStatistic(String longWord, String shortWord, Integer longWordLenght, Integer shortWordLenght, Integer rowLenght, Integer averageWordLenght, Integer countWords) {
        this.longWord          = longWord         ;
        this.shortWord         = shortWord        ;
        this.longWordLenght    = longWordLenght   ;
        this.shortWordLenght   = shortWordLenght  ;
        this.rowLenght         = rowLenght        ;
        this.averageWordLenght = averageWordLenght;
        this.countWords        = countWords       ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExtId() {
        return extId;
    }

    public void setExtId(Integer extId) {
        this.extId = extId;
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

    public Integer getRowLenght() {
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

    public Integer getCountWords() {
        return countWords;
    }

    public void setCountWords(Integer countWords) {
        this.countWords = countWords;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RowStatistic that = (RowStatistic) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (extId != null ? !extId.equals(that.extId) : that.extId != null) return false;
        if (longWord != null ? !longWord.equals(that.longWord) : that.longWord != null) return false;
        if (shortWord != null ? !shortWord.equals(that.shortWord) : that.shortWord != null) return false;
        if (longWordLenght != null ? !longWordLenght.equals(that.longWordLenght) : that.longWordLenght != null)
            return false;
        if (shortWordLenght != null ? !shortWordLenght.equals(that.shortWordLenght) : that.shortWordLenght != null)
            return false;
        if (rowLenght != null ? !rowLenght.equals(that.rowLenght) : that.rowLenght != null) return false;
        if (averageWordLenght != null ? !averageWordLenght.equals(that.averageWordLenght) : that.averageWordLenght != null)
            return false;
        return !(countWords != null ? !countWords.equals(that.countWords) : that.countWords != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (extId != null ? extId.hashCode() : 0);
        result = 31 * result + (longWord != null ? longWord.hashCode() : 0);
        result = 31 * result + (shortWord != null ? shortWord.hashCode() : 0);
        result = 31 * result + (longWordLenght != null ? longWordLenght.hashCode() : 0);
        result = 31 * result + (shortWordLenght != null ? shortWordLenght.hashCode() : 0);
        result = 31 * result + (rowLenght != null ? rowLenght.hashCode() : 0);
        result = 31 * result + (averageWordLenght != null ? averageWordLenght.hashCode() : 0);
        result = 31 * result + (countWords != null ? countWords.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RowStatistic{" +
                "id=" + id +
                ", extId=" + extId +
                ", longWord='" + longWord + '\'' +
                ", shortWord='" + shortWord + '\'' +
                ", longWordLenght=" + longWordLenght +
                ", shortWordLenght=" + shortWordLenght +
                ", rowLenght=" + rowLenght +
                ", averageWordLenght=" + averageWordLenght +
                ", countWords=" + countWords +
                "}\n";
    }
}
