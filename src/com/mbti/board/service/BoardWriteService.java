package com.mbti.board.service;

import com.mbti.board.dao.BoardDAO;
import com.mbti.board.vo.BoardVO;
import com.mbti.main.controller.Service;

public class BoardWriteService implements Service {
	
	//writrForm -> write -> BoardWriteService -> Init
	//실행은 서버가 시작될 때 시작된다
	private BoardDAO dao;

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.write((BoardVO) obj);
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao=(BoardDAO) dao;		
	}

}
