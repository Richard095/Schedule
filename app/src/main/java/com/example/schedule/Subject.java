package com.example.schedule;


public class Subject implements  Comparable<Subject> {
    private int day;
    private String subject_name;
    private String teacher;
    private String classroom;
    private int hour_start_class;
    private int hour_end_class;
    private String indicator;  //AM | PM
    private int image_on_off; //NO
    private int keySubject;  //NO

    public Subject(int day,String subject_name,String teacher,String classroom,int hour_start_class,
                   int hour_end_class,String indicator,int image_on_off,int keySubject){
        this.day = day;
        this.subject_name=subject_name;
        this.teacher = teacher;
        this.classroom = classroom;
        this.hour_start_class=hour_start_class;
        this.hour_end_class = hour_end_class;
        this.indicator = indicator;
        this.image_on_off = image_on_off;
        this.keySubject = keySubject;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getHour_start_class() {
        return hour_start_class;
    }

    public void setHour_start_class(int hour_start_class) {
        this.hour_start_class = hour_start_class;
    }

    public int getHour_end_class() {
        return hour_end_class;
    }

    public void setHour_end_class(int hour_end_class) {
        this.hour_end_class = hour_end_class;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public int getImage_on_off() {
        return image_on_off;
    }

    public void setImage_on_off(int image_on_off) {
        this.image_on_off = image_on_off;
    }

    public int getKeySubject() {
        return keySubject;
    }

    public void setKeySubject(int keySubject) {
        this.keySubject = keySubject;
    }

    @Override
    public int compareTo( Subject subject) {
        if (hour_start_class < subject.hour_start_class) {
            return -1;
        }
        if (hour_start_class > subject.hour_start_class) {
            return 1;
        }
        return 0;
    }
}
