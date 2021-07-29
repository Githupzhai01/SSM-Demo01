package com.service;

import com.domain.Notice;
import com.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    public List<Notice> NoticeSel(){
        List<Notice> notices = noticeMapper.selectByExample(null);
        return notices;
    }

    //单个删除
    public void DelNo(int noid){
        noticeMapper.deleteByPrimaryKey(noid);
    }

    //添加公告信息
    public void AddNotice(String notice){
        Notice notice1=new Notice();
        Date date=new Date();
        notice1.setNotime(date);
        notice1.setNoname(notice);
        noticeMapper.insertSelective(notice1);
    }
}
