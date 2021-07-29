package com.service;


import com.domain.Msg;
import com.domain.User1;
import com.domain.User1Example;
import com.mapper.User1Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Service
public class User1Service {
    @Autowired
    User1Mapper user1Mapper;

    @Autowired
    SqlSession sqlSession;

    //两表查询数据
    public List<User1> WithD(){
        List<User1> user1s = user1Mapper.selectByExampleWithD(null);return user1s;
    }

    //查询数据
    public List<User1> selectAll(){
        List<User1> user1List = user1Mapper.selectByExample(null);
        return user1List;
    }

    //批量添加
    public void bathInsert(){
        User1Mapper mapper= sqlSession.getMapper(User1Mapper.class);
        for (int i=0; i<20;i++){
            String uid= UUID.randomUUID().toString().substring(0,5);
            mapper.insert(new User1(null,uid,"123","2018-12-31"));
        }
    }

    //修改时查询ID
    public User1 selupdId(int id){
        User1 user1 = user1Mapper.selectByPrimaryKey(id);
        return user1;
    }

    //修改方法
    public void UPD(User1 tblEmp){
        user1Mapper.updateByPrimaryKeySelective(tblEmp);
    }
    //单个添加
    public void add(User1 tblEmp){
        user1Mapper.insert(tblEmp);

    }

    //单个删除
    public void delOne(int userid){
        user1Mapper.deleteByPrimaryKey(userid);
    }

    //批量删除
    public void bathdelete(List<Integer> ids){
        User1Example example=new User1Example();
        example.createCriteria().andIdIn(ids);
        user1Mapper.deleteByExample(example);
    }
}
