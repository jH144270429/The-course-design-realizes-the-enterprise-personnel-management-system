package xyskcsj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdDialog extends JDialog implements ActionListener {
	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7;
	JButton jb1, jb2;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7;
	JPanel jp1, jp2, jp3;

	public UpdDialog(EmployModel em, int rowNums) {
		jl1 = new JLabel("工号:");
		jl2 = new JLabel("姓名:");
		jl3 = new JLabel("性别:");
		jl4 = new JLabel("出生年月:");
		jl5 = new JLabel("部门:");
		jl6 = new JLabel("职位:");
		jl7 = new JLabel("工资:");

		jtf1 = new JTextField(20);
		jtf2 = new JTextField(30);
		jtf3 = new JTextField(30);
		jtf4 = new JTextField(30);
		jtf5 = new JTextField(30);
		jtf6 = new JTextField(30);
		jtf7 = new JTextField(30);

		// 初始化jtextfield数据
		jtf1.setText((String) em.getValueAt(rowNums, 0));
		jtf1.setEditable(false);
		jtf2.setText((String) em.getValueAt(rowNums, 1));
		jtf3.setText((String) em.getValueAt(rowNums, 2));
		jtf4.setText((String) em.getValueAt(rowNums, 3));
		jtf5.setText((String) em.getValueAt(rowNums, 4));
		jtf6.setText((String) em.getValueAt(rowNums, 5));
		jtf7.setText((String) em.getValueAt(rowNums, 6));

		jb1 = new JButton("修改");
		jb2 = new JButton("取消");

		// 对两个按钮监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		// 设置布局
		jp1.setLayout(new GridLayout(7, 1));
		jp2.setLayout(new GridLayout(7, 1));

		// 添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);

		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);

		jp3.add(jb1);
		jp3.add(jb2);

		this.add(jp1, BorderLayout.WEST);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);

		this.setSize(300, 250);
		this.setVisible(true);
		this.setLocation(200, 200);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb1) {
			// 修改员工信息的 sql 语句，paras 为待注入的值
			String sql = "update Employinfo set "
					+ "Ename = ?,Sex = ?,Birthday = ?, DeptNo = ?, Ejob = ? ,Sal=? where Empno = ?";

			String[] paras = { jtf2.getText(), jtf3.getText(), jtf4.getText(),
					jtf5.getText(), jtf6.getText(), jtf7.getText(),
					jtf1.getText() };

			EmployModel temp = new EmployModel();
			// 如果修改语句运行成功 则弹出“修改成功”对话框
			if (temp.updEmploy(sql, paras)) {
				JOptionPane.showMessageDialog(this, "修改成功");
			}
			this.dispose();

		} else if (e.getSource() == jb2) {
			// 关闭对话框
			this.dispose();
		}

	}

}