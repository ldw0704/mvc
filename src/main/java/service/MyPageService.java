package service;

import domain.LoginVO;
import domain.MyPageDTO;

public interface MyPageService {
	
	public abstract LoginVO read(MyPageDTO dto);
	public LoginVO read(String uid);

	public void update(LoginVO vo);
	
	public void insert(LoginVO vo);
}
