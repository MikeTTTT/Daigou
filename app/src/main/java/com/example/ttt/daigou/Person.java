package com.example.ttt.daigou;

/**
 * Created by ttt on 2018/6/30.
 */

public class Person {


        private String _id;
        private String name;
        private String age;
        private String no;
        private String cpp;
        private String math;
        private String english;

        public void set_id(String _id){
            this._id = _id;
        }
        public String get_id(){
            return _id;
        }

        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void setAge(String age){
            this.age = age;
        }
        public String getAge(){
            return age;
        }
        public void setNo(String no){
            this.no = no;
        }
        public String getNo(){
            return no;
        }
        public void setCpp (String cpp){
            this.cpp = cpp;
        }
        public String getCpp(){
            return cpp;
        }
        public void setMath(String math){
            this.math = math;
        }
        public String getMath(){
            return math;
        }
        public void setEnglish(String english){
            this.english = english;
        }
        public String getEnglish(){
            return english;
        }

        @Override
        public String toString() {
            return name + ", "+no+", "+age;
        }

        public Person(String _id, String name, String no, String age, String cpp, String math, String english){
            super();
            this._id = _id;
            this.name = name;
            this.age = age;
            this.cpp = cpp;
            this.math = math;
            this.english = english;
        }
    }


