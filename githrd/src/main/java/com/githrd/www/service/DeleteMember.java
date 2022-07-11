package com.githrd.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.githrd.www.dao.*;
import com.githrd.www.vo.*;

@Service
public class DeleteMember {
	@Autowired
	MemberDao mDao;
	
	@Transactional
	public void delMember(MemberVO mVO) {
		// 할일
		// (자동) 삭제될 데이터 백업하고
		mDao.backupBoard(mVO);
		//mDao.backupReBoard(mVO);
		mDao.backupMember(mVO.getId());
		
		// 데이터 삭제하고
		//mDao.delMemb(mVO.getId());
	}
}
