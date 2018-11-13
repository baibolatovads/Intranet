package com.company;

import java.io.Serializable;
import java.util.Date;

public class CourseFile implements Serializable {
    private String title;
    private String description;
    private Date addDate;

    public CourseFile(){}

    public CourseFile(String title, String description, Date addDate){
        this.title = title;
        this.description = description;
        this.addDate = addDate;
    }

    @Override
    public String toString(){
        return "CourseFile{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", addDate=" + addDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseFile that = (CourseFile) o;

       return (title.equals(that.title) && description.equals(that.description) && addDate.equals(that.addDate));
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}
