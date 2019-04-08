package xyskcsj;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class History extends Panel implements ActionListener {
	AppraisalModel am;
	JTable jt;
	JScrollPane jsp;
	JLabel jl1;
	JPanel jp, jp1, jp2;
	JButton jb1, jb2;

	public History() {
		// 北部
		jp = new JPanel();
		jl1 = new JLabel("员工考核历史记录", JLabel.CENTER);
		jl1.setFont(new Font("黑体", Font.BOLD, 30));

		jp.add(jl1);
		// 中部
		am = new AppraisalModel();
		String[] paras = { "1" };
		am.queryHistory("select * from History where 1 = ?", paras);
		jt = new JTable(am);
		jsp = new JScrollPane(jt);

		// 南部
		jp2 = new JPanel();
		jb1 = new JButton("清空");
		jb2 = new JButton("刷新");

		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp2.add(jb1);
		jp2.add(jb2);
		this.setLayout(new BorderLayout());
		this.add(jp, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			// 删除历史记录 并更新表
			am = new AppraisalModel();
			String[] paras = { "1" };
			am.updAppraisal("delete History where 1 = ?", paras);
			am.queryHistory("select * from History where 1 = ?", paras);
			this.jt.setModel(am);
		} else if (e.getSource() == jb2) {
			// 刷新表格
			am = new AppraisalModel();
			String[] paras = { "1" };
			am.queryHistory("select * from History where 1 = ?", paras);
			this.jt.setModel(am);
		}

	}

}