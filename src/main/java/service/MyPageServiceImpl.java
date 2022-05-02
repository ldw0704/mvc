package service;

import domain.LoginVO;
import domain.MyPageDTO;
import mapper.MyPageMapper;

public class MyPageServiceImpl implements MyPageService{

	public LoginVO read(MyPageDTO dto) {		
		return new MyPageMapper().read(dto);
	}

}
