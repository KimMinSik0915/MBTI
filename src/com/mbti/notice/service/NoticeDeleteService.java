package com.mbti.notice.service;

import com.mbti.notice.dao.NoticeDAO;
import com.mbti.main.controller.Service;

public class NoticeDeleteService implements Service{

	//dao가 필요하다. 밖에서 생성한 후 넣어준다. - 1. 생성자. 2. setter()
	private NoticeDAO dao;
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (NoticeDAO) dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete((Long) obj);
	}

}
