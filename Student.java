package com.company;

import java.io.Serializable;
import java.util.*;

public class Student extends Person implements Serializable, Comparable, Interactive {
    //working on it
    private double gpa;
    private Faculty faculty;
    public  ArrayList<Course> current = new ArrayList<>();
    private HashSet<Course> passed = new HashSet<>();
    private HashMap<Course, Teacher> teachers = new HashMap<>();
    private Registration registration = new Registration();
    private HashMap<Course, Mark> marks = new HashMap<>();


    public Student(){}

    public Student(String name, String login, String password){
        super(name, login, password);
    }
    public Student(String name, String login, String password, String id, Double gpa, Faculty faculty){
        super(name, login, password, id);
        this.gpa = gpa;
        this.faculty = faculty;
    }

    private static final Scanner sc = new Scanner(System.in);
    public void registerForACourse(Course c){
        registration.addRegistration(new Registration(this, c, Type.PENDING));
    }

    public ArrayList<Course> getCourses(){
        return current;
    }

    public HashSet<CourseFile> getCourseFile(Course c){
        return c.getCourseFiles();
    }
    public HashMap<Course, Mark> getMarks(){
        return marks;
    }

    public Mark getMark(Course c){
        if(!getMarks().containsKey(c)){
            marks.put(c, null);
        }
        return marks.get(c);
    }


    public void setMark(Mark m, Course c){
        if(!getMarks().containsKey(c)){
            marks.put(c, m);
        }
        marks.replace(c, m);
    }

    public String viewTeacher(Course c){
        Teacher t = c.getTeacher();
        return t + "\n";
    }

    public String viewCourses(){
        String s = "";
        for(Course c : current){
            s += c + "\n";
        }
        return s;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gpa, faculty, current, passed, teachers, registration, marks);
    }

    public void setTeacher(Course course, Teacher teacher){
        teachers.put(course, teacher);
    }

    public int getCreditsNum(){
        int cnt = 0;
        for(Course c : getCourses()){
            cnt+=c.getCreditsNumber();
        }
        return cnt;
    }

    public Faculty getFaculty(){
        return faculty;
    }

    public void setFaculty(Faculty faculty){
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return (gpa == student.gpa && faculty == student.faculty && current.equals(student.current)
                && passed.equals(student.passed) && marks.equals(student.marks) && teachers.equals(student.teachers));
    }

    @Override
    public String toString() {
        return "Student{" +
                ", faculty=" + faculty +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;

        if(gpa > s.gpa) return 1;
        if(gpa == s.gpa) return 0;
        return -1;
    }

    public void session(){
        System.out.println("You are logged as student!");

        System.out.println("Choose the option you want");
        System.out.println("1. Courses");
        System.out.println("2. Transcript");
        System.out.println("3. Register for a course");
        System.out.println("4. Exit");
        String ans = sc.nextLine();
        switch (ans) {
            case "1":
                showCourses();
                break;
            case "2":
                StudentTranscript();
                break;
            case "3":
                studentRegistration();
                break;
            case "4":
                System.out.println("Good Bye!");
                break;
        }
    }

    private void showCourses(){
        String ans = "";

        while(!ans.equals("exit")){
            System.out.println("Your courses: \n");
            for(int i = 0; i < current.size(); ++i){
                System.out.println((i + 1) + ". " + current.get(i).getName());
            }

            System.out.println("Select course");
            ans = sc.nextLine();

            try{
                int ind = Integer.decode(ans);
                ind--;

                if(ind > -1 && ind < current.size()){
                   StudentCourse(ind);
                }
                else {
                    System.out.println("Wrong selection");
                }
            }
            catch(Exception e){
                System.out.println("Wrong selection");
            }
        }
    }

    private void StudentCourse(int ind){
        String ans = "";
        while(!ans.equals("exit")){
            System.out.println("Choose option:\n");
            System.out.println("1. Show Marks");
            System.out.println("2. Show Course Files");
            System.out.println("3. Show Course Info");
            System.out.println("4. Show Teachers");
            System.out.println("5. Exit");
            ans = sc.nextLine();

            switch(ans){
                case "1":
                    System.out.println("This is your mark for current course:\n");
                    getMark(current.get(ind));
                    break;
                case "2":
                    System.out.println("Course Files:\n");
                    current.get(ind).getCourseFiles();
                    break;
                case "3":
                    System.out.println("Course Info Section:\n");
                    current.get(ind).toString();
                    break;
                case "4":
                    System.out.println("Teacher of the course is: ");
                    viewTeacher(current.get(ind));
                case "5":
                    return;
            }
        }
    }

    private void StudentTranscript(){
        System.out.println("Transcript:\n");
            getMarks();
    }

    private void studentRegistration(){
        Driver.loadCourses();
        System.out.println("Your courses: \n");
        for(int i = 0; i < Driver.courses.size(); ++i){
            System.out.println((i + 1) + ". " + Driver.courses.get(i).getName());
        }
        System.out.println("Choose the course you want to register");
        String ans = sc.nextLine();
        System.out.println("");
        try{
            int ind = Integer.decode(ans);
            ind--;

            if(ind > -1 && ind < Driver.courses.size()){
               registerForACourse(Driver.courses.get(ind));
               current.add(Driver.courses.get(ind));
                System.out.println("You have registered for the course successfully");
            }
            else {

                System.out.println("Wrong selection");
            }
        }
        catch(Exception e){
            System.out.println("Wrong selection");
            e.printStackTrace();
        }

    }



    private void studentInfo(){
        System.out.println("Student Info Section\n");
        toString();
    }
}
