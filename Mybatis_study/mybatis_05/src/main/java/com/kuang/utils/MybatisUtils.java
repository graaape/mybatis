package com.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory --->sqlSession
public class MybatisUtils {
    //提升作用域
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource="mybatis_config.xml";
        try {
            InputStream inputStream= Resources.getResourceAsStream(resource);
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //从SqlSessionFactory获得SqlSession实例
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }
}
