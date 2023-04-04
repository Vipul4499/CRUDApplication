package org.example.service;

import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TeacherServicesImpl {
     public void insertsingle( Teacher teacher);
     public void insertMultipal( List<Teacher> teacherList);

      public Teacher selectsingle( int id,int rollno);
      public List<Teacher> selectMultiple(List<Integer> id,List<Integer> rollnos);
      public List<Teacher> selectall();
      public void updatesingle( Teacher teacher);
     public List<Teacher> updateMultipal(List<Teacher> teacherList);
     public boolean deletesingle(int id,int rollno);
     public List<Boolean> deleteMultipal(List<Integer> id, List<Integer> rollnos);

     public boolean deleteAll();
}
