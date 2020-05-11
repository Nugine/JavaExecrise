package ums.gui;

import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ums.dao.UserDao;
import ums.entity.User;


public class DeleteDialog extends JDialog{
	private UserDao userDao; 
	
	private JLabel labelEmail = new JLabel("  用户email");
	private JTextField userEmail = new JTextField(20);		
	private JButton buttonRemove = new JButton("删除用户");
	
	private int windowHeight = 150;  //窗口高度		
	private int windowWidth = 400;   //窗口宽度
	
	public DeleteDialog(JFrame parent, String msg, UserDao userDao){
		super(parent,msg,true);
		this.userDao = userDao;
	}
	
	public void showMe(JFrame parent){
		Panel pCenter=new Panel();
		Panel pSouth=new Panel();
		pSouth.add(buttonRemove);
		
		pCenter.add(labelEmail);
		pCenter.add(userEmail);
		pCenter.add(pSouth);
		add(pCenter);
		
		buttonRemove.addActionListener(new ButtonRemoveHandler());		
		
		//计算对话框的显示位置
		setPosition(parent);		
		setVisible(true);
		validate();		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
			
	private void setPosition(JFrame parent){
		//计算对话框的显示位置
		int parentX = parent.getX();
		int parentY = parent.getY();	
		int parentWidth = parent.getWidth();
		int parentHeight = parent.getHeight();
		int dialogX = parentX + (parentWidth-windowWidth)/2;
		int dialogY = parentY + (parentHeight-windowHeight)/2+40;
		this.setBounds(dialogX,dialogY,windowWidth,windowHeight);
	}
	
	private class ButtonRemoveHandler implements ActionListener{  //删除按钮的事件监听器
		public void actionPerformed(ActionEvent e){
			if(userEmail.getText()==null || userEmail.getText().length()==0){  
				JOptionPane.showMessageDialog( null, "请输入要删除用户的email", "提示" ,JOptionPane.PLAIN_MESSAGE );			
			}else{			
				User user = userDao.delete(userEmail.getText());
				if(user!=null){
					JOptionPane.showMessageDialog( null, "用户已删除", "提示" ,JOptionPane.PLAIN_MESSAGE );
					userEmail.setText(null);
				}else{
					JOptionPane.showMessageDialog( null, "该用户不存在", "提示" ,JOptionPane.PLAIN_MESSAGE );
				}				
			}
		}
	}
}