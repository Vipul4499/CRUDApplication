package org.example.controller;

import org.example.model.Teacher;
import org.example.service.TeacherServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherServicesImpl services;
    @RequestMapping("/insertsingle")
    @ResponseBody
    void insertsingle(@RequestBody Teacher teacher){
        services.insertsingle(teacher);
    }
    @RequestMapping("/insertMultipal")
    @ResponseBody
    void insertMultipal(@RequestBody List<Teacher> teacherList){
        services.insertMultipal(teacherList);
    }
    @RequestMapping("/selectsingle")
    @ResponseBody

    Teacher selectsingle(@RequestParam int id,int rollno){
        return services.selectsingle(id, rollno);
    }
    @RequestMapping("/selectMultipal")
    @ResponseBody
     List<Teacher> selectMultiple(List<Integer> id,List<Integer> rollnos){
        return services.selectMultiple(id,rollnos);
    }

    @RequestMapping("selectall")
    @ResponseBody
    List<Teacher> selectall(){
        return services.selectall();

    }
@RequestMapping("/update")
    @ResponseBody
    void updatesingle(@RequestBody Teacher teacher){
        services.updatesingle(teacher);
}
   @RequestMapping("updateMultipal")
   @ResponseBody
    void updateMultipal(@RequestBody List<Teacher> teacherList){
          services.updateMultipal(teacherList);
     }
@RequestMapping("/deletesingle")
    @ResponseBody
     boolean deletesingle(@RequestParam int id,int rollno){
     return services.deletesingle(id,rollno);
}
     @RequestMapping("/deleteMultipal")
     @ResponseBody
    List<Boolean> deleteMultipal(List<Integer> id, List<Integer> rollnos){
        return services.deleteMultipal(id, rollnos);

        }
@RequestMapping("/deleteall")
    @ResponseBody
 boolean deleteAll(){
        return services.deleteAll();
}

}
