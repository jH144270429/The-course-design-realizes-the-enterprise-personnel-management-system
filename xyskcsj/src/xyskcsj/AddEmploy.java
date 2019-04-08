package xyskcsj;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class AddEmploy extends Panel implements ActionListener {
	JLabel jl, jl1, jl2, jl3, jl4, jl5, jl6, jl7;
	JButton jb1, jb2;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7;
	JPanel jp1, jp2, jp3, jp4;
	EmployModel em;

	public AddEmploy() {

		jl1 = new JLabel("工号:");
		jl2 = new JLabel("姓名:");
		jl3 = new JLabel("性别:");
		jl4 = new JLabel("出生年月:");
		jl5 = new JLabel("部门:");
		jl6 = new JLabel("职位:");
		jl7 = new JLabel("工资:");

		jtf1 = new JTextField(20);
		jtf2 = new JTextField(20);
		jtf3 = new JTextField(20);
		jtf4 = new JTextField(20);
		jtf5 = new JTextField(20);
		jtf6 = new JTextField(20);
		jtf7 = new JTextField(20);

		jb1 = new JButton("添加");
		jb2 = new JButton("取消");
		// 监听‘添加’ ‘取消’按钮
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp1 = new JPanel(new GridLayout(7, 1));
		jp2 = new JPanel(new GridLayout(7, 1));
		jp3 = new JPanel();

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

		jp4 = new JPanel(new BorderLayout());

		jp4.add(jp1, BorderLayout.WEST);
		jp4.add(jp2, BorderLayout.EAST);
		jp4.setSize(300, 300);

		this.setLayout(new FlowLayout());

		this.add(jp4);
		this.add(jp3);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			// 调用EmployModel 里的updEmploy 方法，实现对表格的添加
			String sql = "insert into Employinfo values(?,?,?,?,?,?,?)";
			String[] paras = { jtf1.getText(), jtf2.getText(), jtf3.getText(),
					jtf4.getText(), jtf5.getText(), jtf6.getText(),
					jtf7.getText() };
			em = new EmployModel();

			if (em.updEmploy(sql, paras)) {
				// 当添加新员工成功时，则弹出”添加成功“的对话框
				JOptionPane.showMessageDialog(this, "添加成功");
			} else if (!em.updEmploy(sql, paras)) {
				JOptionPane.showMessageDialog(this, "添加失败");
			}

			// 当新员工加入成功后，要把新加入员工的工号加到考核表

			AppraisalModel temp = new AppraisalModel();
			String sql1 = "insert into Appraisal(Empno) values(?)";
			String[] paras1 = { jtf1.getText() };
			temp.updAppraisal(sql1, paras1);
		}else if(e.getSource() == jb2){
			jtf1.setText("");
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");
			jtf6.setText("");
			jtf7.setText("");
		}

	}

}