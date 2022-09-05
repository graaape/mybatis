package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
//    获取老师
    public List<Teacher>getTeacherList();
//    获取指定老师下所有学生的信息及老师自己的信息
    public Teacher getTeacher(@Param("tid") int id);
    public Teacher getTeacher2(@Param("tid") int id);
}
