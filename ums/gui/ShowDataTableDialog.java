package ums.gui;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import ums.entity.User;
import ums.util.UserTableModel;

public class ShowDataTableDialog extends JDialog {
	/**
	 * Generated by VSCode
	 */
	private static final long serialVersionUID = -965888570630889640L;

	private int windowHeight = 300;
	private int windowWidth = 450;

	private JTable table;

	public ShowDataTableDialog(JFrame parent, String msg, List<User> users) {
		super(parent, "用户列表", true);

		// 创建 TableModel
		UserTableModel model = new UserTableModel(users);

		// 为 JTable 设置 TableModel
		table = new JTable();
		table.setModel(model);
	}

	public void showMe(JFrame parent) {
		// 设置列宽
		table.getColumn("序号").setPreferredWidth(30);
		table.getColumn("Email").setPreferredWidth(100);
		table.getColumn("用户名").setPreferredWidth(60);
		table.getColumn("性别").setPreferredWidth(60);
		table.getColumn("爱好").setPreferredWidth(200);

		// 关闭 JTable 的自动调整功能
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// 将 JTable 加入滚动条面板
		JScrollPane pane = new JScrollPane(table);

		// 将滚动条加入窗口
		this.add(pane);

		// 计算对话框的显示位置
		setPosition(parent);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	private void setPosition(JFrame parent) {
		// 计算对话框的显示位置
		int parentX = parent.getX();
		int parentY = parent.getY();
		int parentWidth = parent.getWidth();
		int parentHeight = parent.getHeight();
		int dialogX = parentX + (parentWidth - windowWidth) / 2;
		int dialogY = parentY + (parentHeight - windowHeight) / 2 + 40;
		this.setBounds(dialogX, dialogY, windowWidth, windowHeight);
	}
}
