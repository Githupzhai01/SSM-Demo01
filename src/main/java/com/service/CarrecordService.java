package com.service;

import com.domain.*;
import com.mapper.CardrecordMapper;
import com.mapper.CarrecordMapper;
import com.mapper.PositionrecordMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CarrecordService {
    @Autowired
    CarrecordMapper carrecordMapper;
    @Autowired
    PositionrecordMapper positionrecordMapper;
    @Autowired
    CardrecordMapper cardrecordMapper;


    @Autowired
    SqlSession sqlSession;

    //查询停车信息的方法
    public List<Carrecord> SelectAll() {
//        CarrecordExample carrecordExample = new CarrecordExample();
//        carrecordExample.createCriteria().andCarstateEqualTo(0);
//        List<Carrecord> carrecordList = carrecordMapper.selectByExample(carrecordExample);
        List<Carrecord> carrecordList=carrecordMapper.selectByExample(null);
        return carrecordList;
    }

    //查询停车信息的方法
    public List<Carrecord> SelectAlls() {
        CarrecordExample carrecordExample = new CarrecordExample();
        carrecordExample.createCriteria().andCarstateEqualTo(0);
        List<Carrecord> carrecordList = carrecordMapper.selectByExample(carrecordExample);
//        List<Carrecord> carrecordList=carrecordMapper.selectByExample(null);
        return carrecordList;
    }


    //单个删除
    public void Delone(int rid) {
        carrecordMapper.deleteByPrimaryKey(rid);
    }

    //查询车牌是否重复
    public boolean CarNumber(String Carnumber) {
        CarrecordExample carrecordExample = new CarrecordExample();
        carrecordExample.createCriteria().andCarstateEqualTo(0).andCarnumberEqualTo(Carnumber);
        List<Carrecord> carrecordList = carrecordMapper.selectByExample(carrecordExample);
        if (carrecordList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    //添加车位信息
    public void AddCar(Carrecord carrecord) {
        Date date = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sim.format(date);
        carrecord.setIntimestring(strDate);
        carrecord.setIntime(date);
        carrecord.setParkprice("0");
        carrecord.setCarstate(0);
        carrecord.setCarstatedes("停车中");
        //修改车位状态

        int i = Integer.parseInt(carrecord.getPosition());
        Positionrecord positionrecord = positionrecordMapper.selectByPrimaryKey(i);
        positionrecord.setPositionstate(0);
        positionrecord.setPositionstatesdes("不可用");

        positionrecordMapper.updateByPrimaryKeySelective(positionrecord);
        carrecordMapper.insert(carrecord);
    }

    //取车查询信息
    public Carrecord SelCarId(int rid) {
        Carrecord carrecord = carrecordMapper.selectByPrimaryKey(rid);
        return carrecord;
    }

    public void UPD(Integer id) {
        Date date = new Date();
        Carrecord carrecord1 = carrecordMapper.selectByPrimaryKey(id);
        carrecord1.setOuttime(date);
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sim.format(date);
        carrecord1.setOuttimestring(strDate);
        CarrecordExample carrecordExample=new CarrecordExample();
        carrecordExample.createCriteria().andRidEqualTo(id);
        String carnumber = carrecordMapper.selectByExample(carrecordExample).get(0).getCarnumber();
        CardrecordExample cardrecordExample=new CardrecordExample();
        cardrecordExample.createCriteria().andCarnumberEqualTo(carnumber).andLevelEqualTo(1).andLveldesEqualTo("年卡用户").andOperatornameEqualTo("审核通过");
        List<Cardrecord> cardrecords = cardrecordMapper.selectByExample(cardrecordExample);
        if (cardrecords.size()==0){
            //用时间计算价格
            int hours = (int) (date.getTime() - carrecord1.getIntime().getTime()) / (1000 * 60 * 60);
            if (hours ==0) {
                hours = 1;
            }
            int MoneyEveryHour = 10;
            int price = hours * MoneyEveryHour;
            carrecord1.setParkprice(String.valueOf(price));
        }else{
            carrecord1.setParkprice("0");
        }
        carrecord1.setCarstate(1);
        carrecord1.setCarstatedes("已结束");
        Positionrecord positionrecord = new Positionrecord();
        positionrecord.setPositionstate(1);
        positionrecord.setPositionstatesdes("可用");
        positionrecord.setPid(Integer.parseInt(carrecord1.getPosition()));
//        PositionrecordExample positionrecordExample = new PositionrecordExample();
//        positionrecordExample.createCriteria().andPositionnameEqualTo(carrecord1.getPosition());
       //positionrecordMapper.updateByExampleSelective(positionrecord, positionrecordExample);
        positionrecordMapper.updateByPrimaryKeySelective(positionrecord);
        carrecordMapper.updateByPrimaryKeySelective(carrecord1);
    }

}
