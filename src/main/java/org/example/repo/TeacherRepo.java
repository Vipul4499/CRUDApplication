package org.example.repo;

import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepo implements TeacherRepoImpl{
    @Override

    public void insertsingle( Teacher teacher){


            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
                Statement st= Con.createStatement();
                st.executeUpdate("insert into student values('"+teacher.getStudent().getRollNo()+"','"+teacher.getStudent().getName()+"','"+teacher.getStudent().getEmail()+"')");
                st.executeUpdate("insert into teacher values('"+teacher.getId()+"','"+teacher.getName()+"','"+teacher.getEmail()+"')");
            }
            catch(Exception e){
                System.out.println(e);
            }
    }
    @Override
    public Teacher selectsingle( int id,int rollno){
        Teacher teacher =new Teacher();
        Student student=new Student();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
            Statement st= Con.createStatement();

            ResultSet rt= st.executeQuery("select * from teacher where id ='"+id+"'");
            while(rt.next()) {
                teacher.setId(rt.getInt(1));
                teacher.setName(rt.getString(2));
                teacher.setEmail(rt.getString(3));
            }

            ResultSet rs = st.executeQuery("select * from stud3 where rollno = '" + rollno + "'");
            while (rs.next()) {
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            teacher.setStudent(student);

        }
        catch(Exception e){
            System.out.println(e);
        }
        return teacher;
    }

    @Override
    public Teacher updatesingle(Teacher teacher){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
            Statement st= Con.createStatement();
            st.executeUpdate("insert into student values('"+teacher.getStudent().getRollNo()+"','"+teacher.getStudent().getName()+"','"+teacher.getStudent().getEmail()+"')");
            st.executeUpdate("insert into teacher values('"+teacher.getId()+"','"+teacher.getName()+"','"+teacher.getEmail()+"')");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return selectsingle(teacher.getId(),teacher.getStudent().getRollNo());

    }
    @Override
    public boolean deletesingle(int id,int rollno){

            boolean result = false;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
                Statement st= Con.createStatement();
                int count =st.executeUpdate("delete from teacher where rollNo ='"+rollno+"'");
                if (count>0){
                    result=true;
                }

            }
            catch(Exception e){
                System.out.println(e);
            }
            return result;
    }

    @Override
    public List<Teacher> selectall() {

            List<Teacher> teacherList=new ArrayList<>();
            List<Student> studentList=new ArrayList<>();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "");
                Statement st = con.createStatement();

                ResultSet rs1 = st.executeQuery("select * from teacher");
                while (rs1.next()) {
                    Teacher teacher=new Teacher();
                    teacher.setId(rs1.getInt(1));
                    teacher.setName(rs1.getString(2));
                    teacher.setEmail(rs1.getString(3));
                    teacherList.add(teacher);
                }

                ResultSet rs = st.executeQuery("select * from student ");
                while (rs.next()) {
                    Student student = new Student();
                    student.setRollNo(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setEmail(rs.getString(3));
                    studentList.add(student);
                }
                for(int i=0; i<teacherList.size();i++){
                    Teacher t1=teacherList.get(i);
                    t1.setStudent(studentList.get(i));
                }
            }

            catch (Exception e) {
                System.out.println(e);
            }
            return teacherList;
        }


    @Override
    public boolean deleteAll(){
        boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
            Statement st = con.createStatement();
            int count1 = st.executeUpdate("delete from teacher");
            if ( count1>0){
                result = true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    }


