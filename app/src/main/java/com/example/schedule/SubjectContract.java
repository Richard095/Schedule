package com.example.schedule;

import android.provider.BaseColumns;

public class SubjectContract  {
    public class subjectColumns implements BaseColumns {

        public static final String TABLE_NAME = "subjects";
        public static final String DAY = "day";
        public static final String SUBJECT_NAME = "subject_name";
        public static final String TEACHER = "teacher";
        public static final String CLASSROOM = "classroom";
        public static final String HOUR_START_CLASS = "hour_start_class";
        public static final String HOUR_END_CLASS = "hour_end_class";
        public static final String INDICATOR = "indicator";
        public static final String KEY = "keySubject";
    }
}
