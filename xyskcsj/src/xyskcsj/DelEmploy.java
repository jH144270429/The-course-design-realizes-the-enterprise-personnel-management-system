package xyskcsj;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DelEmploy extends Panel implements ActionListener {
	JTable jt;
	JScrollPane jsp;
	JButton jb1, jb2;
	JPanel jp1, jp2;
	JLabel jl1;
	EmployModel em;

	public DelEmploy() {
		// 北部
		jl1 = new JLabel("删除员工", JLabel.CENTER);
		jl1.setFont(new Font("黑体", Font.BOLD, 30));
		jp2 = new JPanel();
		jp2.add(jl1);

		// 中部
		em = new EmployModel();
		String[] paras = { "1" };
		em.queryEmploy("select * from Employinfo where 1 = ?", paras);
		jt = new JTable(em);
		jsp = new JScrollPane(jt);

		// 南部
		jp1 = new JPanel();
		jb1 = new JButton("删除");
		jb2 = new JButton("取消");

		jb1.addActionListener(this);

		jp1.add(jb1);
		jp1.add(jb2);

		this.setLayout(new BorderLayout());

		this.add(jp2, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
		this.add(jp1, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			// 返回用户点中的行
			int rowNum = this.jt.getSelectedRow();
			if (rowNum == -1) {
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			// 得到学生编号
			String Empno = (String) em.getValueAt(rowNum, 0);

			// 删除记录的sql语句
			String sql = "delete from Employinfo where Empno = ?";
			String[] paras = { Empno };
			EmployModel temp = new EmployModel();
			temp.updEmploy(sql, paras);

			// 删除员工成功后，更新员工表
			em = new EmployModel();
			String[] paras1 = { "1" };
			em.queryEmploy("select * from Employinfo where 1 = ?", paras1);
			jt.setModel(em);
}
	}
	}