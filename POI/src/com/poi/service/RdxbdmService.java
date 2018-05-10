package com.poi.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poi.bean.Rdxbdm;
import com.poi.dao.RdxbdmDao;
import com.poi.utils.ExcelReader;
@Service
public class RdxbdmService {
	@Autowired
	private RdxbdmDao rdxbdmDao;
	
	public void insertDb() {
		 // TODO Auto-generated method stub
        try {
            //根据流
            InputStream is = new FileInputStream("e:\\111.xlsx");
            List<Rdxbdm> list = (List<Rdxbdm>) ExcelReader.getList(is);
            //根据文件路径
            //List<User> list = (List<User>) ExcelReader.getList("d:\\user.xlsx");
            for (int i = 0; i < list.size(); i++) {
            	Rdxbdm rdxbdm = list.get(i);
            	rdxbdmDao.insert(rdxbdm);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
}
