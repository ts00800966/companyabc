package Dao;

import java.util.List;

import Model.member;

public interface memberDao {
	//新增
	//void add(String name,String username,String password,String address,String phone,String mobile);
	void add(member m);//inject注入 相當於上一段宣告DB所有項目
	
	//查詢
	String queryAll1(); //查詢全部
	List<member> queryAll2(); //查詢全部<List>
	member queryId(int id);//查詢篩選IP
	member queryMember(String username,String password);//查詢篩選帳號密碼
	
	//新增查詢帳號
	boolean queryUser(String username);
	
	//修改
	void update(member m);
	
	//刪除
	void delete(int id);
	
	
}
