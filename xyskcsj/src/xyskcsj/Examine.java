package xyskcsj;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.*;
import javax.swing.*;

public class Examine extends Panel implements ActionListener {
	JLabel jl1, jl2, jl3, jl4;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf1, jtf2;
	Choice ch;
	JButton jb1, jb2;
	JPanel jp1, jp2, jp3, jp4;
	AppraisalModel am;
	SqlHelper sqh;

	public Examine() {
		// ���� Ϊ��������
		jp4 = new JPanel();
		jl1 = new JLabel("Ա������", JLabel.CENTER);
		jl1.setFont(new Font("����", Font.BOLD, 30));
		jp4.add(jl1);

		// �в�

		am = new AppraisalModel();
		am.queryAppraisal("select E.Empno,E.Ename,A.Consequence,A.RegDate from "
				+ "Employinfo as E,Appraisal as A where E.Empno=A.Empno");
		jt = new JTable(am);
		jsp = new JScrollPane(jt);

		// ����jtable ������ʱ��ȡ��������� ��ͨ��������¼��� jtf1��jtf2 ��ֵ
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int rowNum = jt.getSelectedRow();
				jtf1.setText((String) am.getValueAt(rowNum, 0));
				jtf2.setText((String) am.getValueAt(rowNum, 1));

			}
		});

		jl2 = new JLabel("���ţ�");
		jl3 = new JLabel("������");
		jl4 = new JLabel("����");
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jtf1.setEditable(false);
		jtf2.setEditable(false);
		// ʵ����ѡ�����������ֵ
		ch = new Choice();
		ch.add("δ����");
		ch.add("���ϸ�");
		ch.add("�ϸ�");
		ch.add("����");

		jp1 = new JPanel();
		jp1.add(jl2);
		jp1.add(jtf1);
		jp1.add(jl3);
		jp1.add(jtf2);
		jp1.add(jl4);
		jp1.add(ch);

		jp2 = new JPanel(new BorderLayout());
		jp2.add(jsp, BorderLayout.CENTER);
		jp2.add(jp1, BorderLayout.SOUTH);

		// �ϲ�
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("ˢ��");
		jp3 = new JPanel();

		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp3.add(jb1);
		jp3.add(jb2);

		this.setLayout(new BorderLayout());
		this.add(jp4, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1) {
			String Empno = jtf1.getText();
			String Ename = jtf2.getText();
			String Consequence = ch.getSelectedItem();
			// �Ȼ�ȡ�ϴο��˼�¼

			String sql = "select Consequence from Appraisal where Empno =?";
			String[] paras = { Empno };

			String OldInfo = "";
			try {
				sqh = new SqlHelper();
				ResultSet rs = sqh.queryExecute(sql, paras);
				rs.next();
				OldInfo = rs.getString(1);
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				sqh.close();
			}

			// �Կ��˱�����޸� �޸Ŀ��˼�¼��sql���
			String sql1 = "update Appraisal set Consequence = ? where Empno =?";
			String[] paras1 = { Consequence, Empno };
			AppraisalModel temp = new AppraisalModel();
			if (temp.updAppraisal(sql1, paras1)) {
				JOptionPane.showMessageDialog(this, "���˳ɹ�");
			}

			// �ٰ�"�ϴο��˼�¼"�Լ�"���β�����¼" ���뵽 history����
			String sql2 = "insert into History(Empno,Ename,OldInfo,NewInfo) values(?,?,?,?)";
			String[] paras2 = { Empno, Ename, OldInfo, Consequence };
			AppraisalModel temp1 = new AppraisalModel();
			temp1.updAppraisal(sql2, paras2);

		} else if (e.getSource() == jb2) {
			// ˢ��Ա�����˱�
			am = new AppraisalModel();
			String[] paras3 = { "1" };
			am.queryAppraisal("select E.Empno,E.Ename,A.Consequence,A.RegDate from "
					+ "Employinfo as E,Appraisal as A where E.Empno=A.Empno");
			this.jt.setModel(am);
		}

	}

}