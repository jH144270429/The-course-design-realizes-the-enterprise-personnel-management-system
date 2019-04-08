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
		jl1 = new JLabel("����:");
		jl2 = new JLabel("����:");
		jl3 = new JLabel("�Ա�:");
		jl4 = new JLabel("��������:");
		jl5 = new JLabel("����:");
		jl6 = new JLabel("ְλ:");
		jl7 = new JLabel("����:");

		jtf1 = new JTextField(20);
		jtf2 = new JTextField(30);
		jtf3 = new JTextField(30);
		jtf4 = new JTextField(30);
		jtf5 = new JTextField(30);
		jtf6 = new JTextField(30);
		jtf7 = new JTextField(30);

		// ��ʼ��jtextfield����
		jtf1.setText((String) em.getValueAt(rowNums, 0));
		jtf1.setEditable(false);
		jtf2.setText((String) em.getValueAt(rowNums, 1));
		jtf3.setText((String) em.getValueAt(rowNums, 2));
		jtf4.setText((String) em.getValueAt(rowNums, 3));
		jtf5.setText((String) em.getValueAt(rowNums, 4));
		jtf6.setText((String) em.getValueAt(rowNums, 5));
		jtf7.setText((String) em.getValueAt(rowNums, 6));

		jb1 = new JButton("�޸�");
		jb2 = new JButton("ȡ��");

		// ��������ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		// ���ò���
		jp1.setLayout(new GridLayout(7, 1));
		jp2.setLayout(new GridLayout(7, 1));

		// ������
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
			// �޸�Ա����Ϣ�� sql ��䣬paras Ϊ��ע���ֵ
			String sql = "update Employinfo set "
					+ "Ename = ?,Sex = ?,Birthday = ?, DeptNo = ?, Ejob = ? ,Sal=? where Empno = ?";

			String[] paras = { jtf2.getText(), jtf3.getText(), jtf4.getText(),
					jtf5.getText(), jtf6.getText(), jtf7.getText(),
					jtf1.getText() };

			EmployModel temp = new EmployModel();
			// ����޸�������гɹ� �򵯳����޸ĳɹ����Ի���
			if (temp.updEmploy(sql, paras)) {
				JOptionPane.showMessageDialog(this, "�޸ĳɹ�");
			}
			this.dispose();

		} else if (e.getSource() == jb2) {
			// �رնԻ���
			this.dispose();
		}

	}

}