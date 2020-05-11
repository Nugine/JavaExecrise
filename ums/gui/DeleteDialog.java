package ums.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ums.dao.UserDao;
import ums.entity.User;

public class DeleteDialog extends JDialog {
    /**
     * Generated by VSCode
     */
    private static final long serialVersionUID = 4684663828380732485L;

    private final UserDao userDao;

    private final JLabel labelEmail = new JLabel("用户 Email");
    private final JTextField textFieldUserEmail = new JTextField(20);
    private final JButton buttonRemove = new JButton("删除用户");

    private final int windowHeight = 150;
    private final int windowWidth = 400;

    private final JFrame parent;

    public DeleteDialog(final JFrame parent, final String msg, final UserDao userDao) {
        super(parent, msg, true);

        this.parent = parent;
        this.userDao = userDao;

        final JPanel panel = new JPanel();
        panel.add(labelEmail);
        panel.add(textFieldUserEmail);
        panel.add(buttonRemove);
        this.add(panel);

        buttonRemove.addActionListener(new ButtonRemoveHandler());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        this.setPosition();
        this.validate();
    }

    private void setPosition() {
        // 计算对话框的显示位置
        final int parentX = parent.getX();
        final int parentY = parent.getY();
        final int parentWidth = parent.getWidth();
        final int parentHeight = parent.getHeight();
        final int dialogX = parentX + (parentWidth - windowWidth) / 2;
        final int dialogY = parentY + (parentHeight - windowHeight) / 2 + 40;
        this.setBounds(dialogX, dialogY, windowWidth, windowHeight);
    }

    private class ButtonRemoveHandler implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            final String userEmail = textFieldUserEmail.getText();

            if (userEmail == null || userEmail.isEmpty()) {
                JOptionPane.showMessageDialog(null, "请输入要删除用户的 Email", "提示", JOptionPane.PLAIN_MESSAGE);
                return;
            }

            final User user = userDao.deleteByEmail(textFieldUserEmail.getText());

            if (user == null) {
                JOptionPane.showMessageDialog(null, "该用户不存在", "提示", JOptionPane.PLAIN_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(null, "用户已删除", "提示", JOptionPane.PLAIN_MESSAGE);
            textFieldUserEmail.setText(null);
        }
    }
}
