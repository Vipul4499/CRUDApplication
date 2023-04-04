package org.example.service;

import org.example.model.Teacher;
import org.example.repo.TeacherRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements TeacherServicesImpl {
    @Autowired
    TeacherRepoImpl repo;
    @Override
    public void insertsingle( Teacher teacher){
        repo.insertsingle(teacher);
    }
    @Override
   public void insertMultipal( List<Teacher> teacherList){
       for(int i=0;i<teacherList.size();i++){
           repo.insertsingle( teacherList.get(i));
       }
    }
    @Override
    public Teacher selectsingle( int id,int rollno){
        return repo.selectsingle(id, rollno);
    }
    @Override
    public List<Teacher> selectMultiple(List<Integer> id,List<Integer> rollNos){
        List<Teacher> teacherstudentList = new ArrayList<>();
        for (int i = 0; i < id.size(); i++) {
            Teacher s1= repo.selectsingle(id.get(i),rollNos.get(i));
            teacherstudentList.add(s1);
        }
        return teacherstudentList;
    }

    @Override
    public List<Teacher> selectall(){
        return repo.selectall();
    }
    @Override
    public void updatesingle( Teacher teacher){
        repo.updatesingle(teacher);
    }
    public List<Teacher> updateMultipal(List<Teacher> teachers){
        List<Teacher> teacherstudentList = new ArrayList<>();
        for(int i=0; i< teachers.size(); i++){
           Teacher s1 =repo.updatesingle(teachers.get(i));
            teacherstudentList.add(s1);
        }
        return teacherstudentList;
    }
    @Override
    public boolean deletesingle(int id,int rollno){
        return repo.deletesingle(id,rollno);
    }
    @Override
   public List<Boolean> deleteMultipal(List<Integer> id, List<Integer> rollnos){

        List<Boolean> teacherList = new ArrayList<>();
        for(int i = 0; i < id.size(); i++)
        {
            Boolean b1 = repo.deletesingle(id.get(i),rollnos.get(i));
            teacherList.add(b1);
        }
        return teacherList;
    }
    @Override
    public boolean deleteAll(){
        return repo.deleteAll();
    }


}
