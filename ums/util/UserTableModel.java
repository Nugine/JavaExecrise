package ums.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import ums.entity.User;

public class UserTableModel extends AbstractTableModel{
	private List<User> users;
	
	public UserTableModel(List users){
		this.users =users;	
	}

	public int getColumnCount() {
		return 5;		
	}

	public int getRowCount() {
		return users.size();
	}

	public Object getValueAt(int row, int col) {  //按指定的行、列取出数据
		User user = (User)users.get(row);
  	    switch(col){
			 case 0: return row+1+"";
			 case 1: return user.getEmail();  //email
			 case 2: return user.getUserName(); //姓名
			 case 3: return user.getSex();  //性别
			 case 4: return user.getHobbies(); //爱好
		 }
		 return null;
	}

	public String getColumnName(int col) {
		switch(col){
		 case 0: return "序号";
		 case 1: return "email";  //email
		 case 2: return "用户名"; //姓名
		 case 3: return "性别";  //性别
		 case 4: return "爱好"; //爱好
		}
		return null;
	}	
}
