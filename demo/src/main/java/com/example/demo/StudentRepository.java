package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

class Student {
    public String name;
    public String gender;

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
        template.execute("CREATE TABLE student(id bigint auto_increment primary key, name VARCHAR(50), gender VARCHAR(1))");
    }

    public void createStudent(String name, String gender) {
        template.update("INSERT INTO student(id, name, gender) VALUES (?,?,?)", null, name, gender);
    }

    public List<Student> findStudentByName(String inputName) {
        String sql = "SELECT name, gender FROM student WHERE name LIKE ?";
        String namePattern = inputName + "%";

        return template.query(sql, new Object[]{namePattern}, rs -> {
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                students.add(new Student(name, gender));
            }
            return students;
        });
    }
}