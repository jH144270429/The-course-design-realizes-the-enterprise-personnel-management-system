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
		// ����
		jl1 = new JLabel("ɾ��Ա��", JLabel.CENTER);
		jl1.setFont(new Font("����", Font.BOLD, 30));
		jp2 = new JPanel();
		jp2.add(jl1);

		// �в�
		em = new EmployModel();
		String[] paras = { "1" };
		em.queryEmploy("select * from Employinfo where 1 = ?", paras);
		jt = new JTable(em);
		jsp = new JScrollPane(jt);

		// �ϲ�
		jp1 = new JPanel();
		jb1 = new JButton("ɾ��");
		jb2 = new JButton("ȡ��");

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
			// �����û����е���
			int rowNum = this.jt.getSelectedRow();
			if (rowNum == -1) {
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return;
			}
			// �õ�ѧ�����
			String Empno = (String) em.getValueAt(rowNum, 0);

			// ɾ����¼��sql���
			String sql = "delete from Employinfo where Empno = ?";
			String[] paras = { Empno };
			EmployModel temp = new EmployModel();
			temp.updEmploy(sql, paras);

			// ɾ��Ա���ɹ��󣬸���Ա����
			em = new EmployModel();
			String[] paras1 = { "1" };
			em.queryEmploy("select * from Employinfo where 1 = ?", paras1);
			jt.setModel(em);
}
	}
	}