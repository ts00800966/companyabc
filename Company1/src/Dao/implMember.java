package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.member;

public class implMember implements memberDao{


	public static void main (String[] args) {
		//新增
		//member m=new member("ABC","red","000","台北","44","123");	
		//new implMember().add(m);
		
		//查看All1 All2 記憶體位置
		//System.out.println(new implMember().queryAll1());
		//System.out.println(new implMember().queryAll2());
		
		//查詢全部
		/*
		List<member> list=new implMember().queryAll2();
		for(member o:list)
		{
			System.out.println(o.getId()+
					"\t"+o.getName()+
					"\t"+o.getUsername()+
					"\t"+o.getPassword()+
					"\t"+o.getAddress()+
					"\t"+o.getMobile()+
					"\t"+o.getPhone());
		}
		System.out.println(l.size());
		*/
		
		//篩選ID
		//System.out.println(new implMember().queryId(3));
		//篩選帳密
		//System.out.println(new implMember().queryMember("ee", "123"));
		
		//修改
		/*
		member m=new implMember().queryId(5);
		m.setPassword("Awe123");
		new implMember().update(m);
		*/
		
		//刪除
		//new implMember().delete(8);
		
		//新增查詢
		System.out.println(new implMember().queryUser("cc"));
		
	}

	@Override
	public void add(member m) {
		Connection conn =DbConnection.getDB();
		String SQL="insert into member(name,username,password,address,mobile,phone) "
				+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps =conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//查詢方法1
	@Override
	public String queryAll1() {
		Connection conn=DbConnection.getDB();
		String SQL = "select * from member";
		String show="";
		
		try {
			PreparedStatement ps =conn.prepareStatement(SQL);//撈資料庫
			ResultSet rs =ps.executeQuery();//撈完整包交給ResultSet處理
			while(rs.next())//有資料新增到show，沒有就false停止新增
			{
				show =show+"id:"+rs.getInt("id")+
						"\t名:"+rs.getString("name")+
						"\t帳號:"+rs.getString("username")+
						"\t密碼:"+rs.getString("password")+
						"\t地址:"+rs.getString("address")+
						"\t手機:"+rs.getString("mobile")+
						"\t電話:"+rs.getString("phone")+"\n";
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return show;
	}

	//查詢方法2(list)
	@Override
	public List<member> queryAll2() {
		Connection conn=DbConnection.getDB();
		String SQL = "select * from member";
		List<member> list=new ArrayList();
		
		try {
			PreparedStatement ps =conn.prepareStatement(SQL);
			ResultSet rs =ps.executeQuery();//撈完整包交給ResultSet處理
			while(rs.next())
			{
				member m = new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//撈資料庫
		return list;
	}

	@Override
	public member queryId(int id) {
		/*
		 * 1.連線->Connection
		 * 2.撈SQL-->where id=?
		 * 3.setInt(第幾欄位, value);
		 * 4.ResultSet
		 * 5.if->rs.next()
		 * 6.true-->rs-->new member()
		 * 7.false-->null
		 */
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where id=?";
		member m =null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public member queryMember(String username, String password) {
		/*
		 * 1.先連線-->Connection
		 * 2.SQL-->where username=? and password=?
		 * 3.setString
		 * 4.ResultSet
		 * 5.if(rs.next())
		 * 6.true--->new member()-->rs填入
		 * 7.false-->null
		 */
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=? and password=?";
		member m =null;
		
		try {
			PreparedStatement ps =conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void update(member m) {
		/*
		 * 1.先連線
		 * 2.SQL-->update 全部內容 where id=?
		 * 3.preparedStatement執行
		 */
		Connection conn=DbConnection.getDB();
		String SQL="update member set name=?,username=?,password=?,address=?,mobile=?,phone=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			ps.setInt(7, m.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		/*
		 * 1.連線
		 * 2.sql-->where id=?
		 * 3.prep-->執行 
		 */
		Connection conn=DbConnection.getDB();
		String SQL ="delete from member where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean queryUser(String username) {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=?";
		boolean m=false;
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) m=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return m;
	}

}
