package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList =mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void getUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(2);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res=mapper.addUser(new User(4,"小红","11111"));
            if(res>0){
                System.out.println("插入成功");
            }
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void updateUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res=mapper.updateUser(new User(4,"小红","10000"));
            if(res>0){
                System.out.println("修改成功");
            }
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res = mapper.deleteUser(4);
            if(res>0){
                System.out.println("删除成功");
            }
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
