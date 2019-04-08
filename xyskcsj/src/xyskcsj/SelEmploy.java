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
		// ����
		jp1 = new JPanel();
		jl = new JLabel("����Ա���ţ�");
		jtf = new JTextField(20);
		jb = new JButton("��ѯ");

		// �Բ�ѯ��ť����
		jb.addActionListener(this);

		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb);

		// �в�
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
			// ���ҳɹ����±�
			jt.setModel(em);
		}

	}

}
