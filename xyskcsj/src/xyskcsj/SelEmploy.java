package xyskcsj;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SelEmploy extends Panel implements ActionListener {
	EmployModel em;
	JLabel jl;
	JTextField jtf;
	JButton jb;
	JTable jt;
	JScrollPane jsp;
	JPanel jp1;

	public SelEmploy() {
		// 北部
		jp1 = new JPanel();
		jl = new JLabel("输入员工号：");
		jtf = new JTextField(20);
		jb = new JButton("查询");

		// 对查询按钮监听
		jb.addActionListener(this);

		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb);

		// 中部
		em = new EmployModel();
		String[] paras = { "1" };
		em.queryEmploy("select * from Employinfo where 1 = ?", paras);
		jt = new JTable(em);
		jsp = new JScrollPane(jt);

		this.setLayout(new BorderLayout());
		this.add(jp1, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb) {
			String name = this.jtf.getText().trim();
			String sql = "select * from Employinfo where Empno = ?";
			String[] paras = { name };
			em = new EmployModel();
			em.queryEmploy(sql, paras);
			// 查找成功更新表
			jt.setModel(em);
		}

	}

}
