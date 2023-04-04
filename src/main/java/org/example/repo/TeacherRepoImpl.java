package org.example.repo;

import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TeacherRepoImpl {
    public void insertsingle( Teacher teacher);

    public Teacher selectsingle( int id,int rollno);
     public Teacher updatesingle(Teacher teacher);
    public boolean deletesingle(int id,int rollno);
    public List<Teacher> selectall();
    public boolean deleteAll();

}
