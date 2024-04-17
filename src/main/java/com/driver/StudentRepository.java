package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            List<String> students = teacherStudentMapping.getOrDefault(teacher, new ArrayList<>());
            students.add(student);
            teacherStudentMapping.put(teacher, students);
        }
    }

    public Student findStudent(String student){
        // your code goes here
        if(studentMap.containsKey(student)){
            return studentMap.get(student);
        }else{
            return null;
        }
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        if(teacherMap.containsKey(teacher)){
            return teacherMap.get(teacher);
        }else{
            return null;
        }
    }

    public List<String> findStudentsFromTeacher(String teacherName){
        return teacherStudentMapping.getOrDefault(teacherName, new ArrayList<>());
    }

    public List<String> findAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacherName){
        teacherMap.remove(teacherName);
        teacherStudentMapping.remove(teacherName);
    }

    public void deleteAllTeachers(){
        teacherMap.clear();
        teacherStudentMapping.clear();
    }
}