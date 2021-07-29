package com.service;

import com.domain.*;
import com.mapper.CardrecordMapper;
import com.mapper.CarrecordMapper;
import com.mapper.PositionrecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service(value = "cardrecordService")
public class CardrecordService {
    @Autowired
    CardrecordMapper cardrecordMapper;
    @Autowired
    CarrecordMapper carrecordMapper;
    @Autowired
    PositionrecordMapper positionrecordMapper;

    //查询是否是有车牌
    public boolean CarNumber(Cardrecord cardrecord) {
        CarrecordExample carrecordExample = new CarrecordExample();
        carrecordExample.createCriteria().andCarnumberEqualTo(cardrecord.getCarnumber());
        List<Carrecord> carrecordList = carrecordMapper.selectByExample(carrecordExample);
        if (carrecordList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    //添加年卡信息
    public void AddNew(Cardrecord cardrecord){
        Date date=new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 1);//增加一年
        cardrecord.setEndtime(cal.getTime());
        cardrecord.setCarnumber(cardrecord.getCarnumber());
        cardrecord.setUsername(cardrecord.getUsername());
        cardrecord.setPhone(cardrecord.getPhone());
        cardrecord.setStarttime(date);
        cardrecord.setOperatorname("审核中");
        cardrecord.setLevel(0);
        cardrecord.setLveldes("普通用户");

        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDatestart = sim.format(date);
        cardrecord.setStarttimestring(strDatestart);
        String strDateend = sim.format(cal.getTime());
        cardrecord.setEndtimestring(strDateend);
        cardrecordMapper.insertSelective(cardrecord);
    }
    public void UpdNew(Cardrecord cardrecord){
        Date date=new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 1);//增加一年
        cardrecord.setEndtime(cal.getTime());
        cardrecord.setCarnumber(cardrecord.getCarnumber());
        cardrecord.setUsername(cardrecord.getUsername());
        cardrecord.setPhone(cardrecord.getPhone());
        cardrecord.setStarttime(date);
        cardrecord.setOperatorname("审核中");
        cardrecord.setLevel(0);
        cardrecord.setLveldes("普通用户");

        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDatestart = sim.format(date);
        cardrecord.setStarttimestring(strDatestart);
        String strDateend = sim.format(cal.getTime());
        cardrecord.setEndtimestring(strDateend);
        CardrecordExample cardrecordExample=new CardrecordExample();
        cardrecordExample.createCriteria().andCarnumberEqualTo(cardrecord.getCarnumber());
        cardrecordMapper.updateByExampleSelective(cardrecord,cardrecordExample);
    }

    //查询审核中信息
    public List<Cardrecord> CardreSel(){
        CardrecordExample cardrecordExample=new CardrecordExample();
        cardrecordExample.createCriteria().andLevelEqualTo(0);
        List<Cardrecord> cardrecords=cardrecordMapper.selectByExample(cardrecordExample);
        return cardrecords;
    }

    //查询审核通过信息
    public List<Cardrecord> CardreSels(){
        CardrecordExample cardrecordExample=new CardrecordExample();
        cardrecordExample.createCriteria().andLevelEqualTo(1);
        List<Cardrecord> cardrecords=cardrecordMapper.selectByExample(cardrecordExample);
        return cardrecords;
    }

    //修改审核状态
    public void updCardre(Cardrecord cardrecord){
        cardrecord.setOperatorname("审核通过");
        cardrecord.setLevel(1);
        cardrecord.setLveldes("年卡用户");
        cardrecordMapper.updateByPrimaryKeySelective(cardrecord);
    }

    //删除审核状态的信息
    public void DelCardre(Integer cid){
        cardrecordMapper.deleteByPrimaryKey(cid);
    }

    //查看是否为年卡用户
    public void selectByCarNumber(String carNumber){
        CardrecordExample cardrecordExample=new CardrecordExample();
        cardrecordExample.createCriteria().andCarnumberEqualTo(carNumber);
        List<Cardrecord> cardrecords = cardrecordMapper.selectByExample(cardrecordExample);
        if (cardrecords.size()>0){

        }else {
            Cardrecord cardrecord=new Cardrecord();
            cardrecord.setCarnumber(carNumber);
            cardrecord.setLevel(0);
            cardrecord.setLveldes("普通用户");
            cardrecordMapper.insertSelective(cardrecord);
        }
    }


    public int selectNum(){
        CardrecordExample cardrecordExample=new CardrecordExample();
        cardrecordExample.createCriteria().andOperatornameEqualTo("审核通过");
        List<Cardrecord> cardrecords=cardrecordMapper.selectByExample(cardrecordExample);
        return cardrecords.size();
    }
    //查询月收入
    public int selectMoney(){
        List<Carrecord> carrecordList=carrecordMapper.selectByExample(null);
        int money=0;
        if(carrecordList.size()!=0) {
            for (Carrecord carrecord:carrecordList) {
                int mon= Integer.parseInt(carrecord.getParkprice());
                money= money+mon;
            }
        }
        return money;
    }

    //查询可用车位和已用车位
    public int selectCheWei(int type){
        if(type==1){
            PositionrecordExample positionrecordExample=new PositionrecordExample();
            positionrecordExample.createCriteria().andPositionstateEqualTo(1);
            return positionrecordMapper.selectByExample(positionrecordExample).size();
        }else{
            PositionrecordExample positionrecordExample=new PositionrecordExample();
            positionrecordExample.createCriteria().andPositionstateEqualTo(0);
            return positionrecordMapper.selectByExample(positionrecordExample).size();
        }
    }
}
