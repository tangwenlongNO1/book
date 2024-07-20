package com.example.pojo;

/**
 * Class name: Student
 * Package: com.example.pojo
 * Description:
 *
 * @Author: twl
 * @Create-time: 2024/5/13 - 17:09
 */
public class Student {
    private Integer id;
    private String name;
    private String phone;

    public Student() {
    }

    public Student(Integer id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
