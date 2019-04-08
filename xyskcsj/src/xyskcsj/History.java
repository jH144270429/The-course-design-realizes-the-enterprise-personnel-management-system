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
		// ����
		jp = new JPanel();
		jl1 = new JLabel("Ա��������ʷ��¼", JLabel.CENTER);
		jl1.setFont(new Font("����", Font.BOLD, 30));

		jp.add(jl1);
		// �в�
		am = new AppraisalModel();
		String[] paras = { "1" };
		am.queryHistory("select * from History where 1 = ?", paras);
		jt = new JTable(am);
		jsp = new JScrollPane(jt);

		// �ϲ�
		jp2 = new JPanel();
		jb1 = new JButton("���");
		jb2 = new JButton("ˢ��");

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
			// ɾ����ʷ��¼ �����±�
			am = new AppraisalModel();
			String[] paras = { "1" };
			am.updAppraisal("delete History where 1 = ?", paras);
			am.queryHistory("select * from History where 1 = ?", paras);
			this.jt.setModel(am);
		} else if (e.getSource() == jb2) {
			// ˢ�±��
			am = new AppraisalModel();
			String[] paras = { "1" };
			am.queryHistory("select * from History where 1 = ?", paras);
			this.jt.setModel(am);
		}

	}

}