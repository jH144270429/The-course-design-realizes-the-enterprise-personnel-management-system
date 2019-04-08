package xyskcsj;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReviseEmploy extends Panel implements ActionListener {
	JTable jt;
	JScrollPane jsp;
	JButton jb1, jb2;
	JPanel jp1,jp2;
	EmployModel em;
    JLabel jl1;
	public ReviseEmploy() {
		jl1 = new JLabel("修改员工信息",JLabel.CENTER);
		jl1.setFont(new Font("宋体", Font.BOLD, 28));
		jp2 = new JPanel();
		jp2.add(jl1);
		
		em = new EmployModel();
		String[] paras = { "1" };
		em.queryEmploy("select * from Employinfo where 1 = ?", paras);
		jt = new JTable(em);
		jsp = new JScrollPane(jt);
		jb1 = new JButton("修改");
		jb2 = new JButton("刷新");

		// 对两个按钮进行监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		this.setLayout(new BorderLayout());

		jp1 = new JPanel();

		jp1.add(jb1);
		jp1.add(jb2);

		this.add(jp2,BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
		this.add(jp1, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			int rowNum = this.jt.getSelectedRow();

			if (rowNum == -1) {
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}

			// 弹出修改对话框
			new UpdDialog(em, rowNum);

		} else if (e.getSource() == jb2) {
			// 刷新修改界面中的表格
			em = new EmployModel();
			String[] paras1 = { "1" };
			em.queryEmploy("select * from Employinfo where 1 = ?", paras1);
			jt.setModel(em);
		}

	}
}