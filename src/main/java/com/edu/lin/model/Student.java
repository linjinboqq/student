package main.java.com.edu.lin.model;

public class Student {
    int sid;
    char sex;
    String name;
    int age;
    String major;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Student() {
    }

    public Student(int sid, char sex, String name, int age, String major) {
        this.sid = sid;
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}