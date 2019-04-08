package xyskcsj;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.event.*;

public class Manager extends JFrame implements TreeSelectionListener {
	JPanel jp;
	JSplitPane js;
	JScrollPane jsp;
	JTree tree;
	DefaultMutableTreeNode root, t1, t2, t1_1, t1_2, t1_3, t1_4, t1_5, t2_1,
			t2_2;

	CardEmploy ae;
	EmployModel em;

	public static void main(String[] args) {
		Manager manager = new Manager();
	}

	public Manager() {
		// �����ĸ�����㸳ֵ
		root = new DefaultMutableTreeNode("���¹���ϵͳ");

		t1 = new DefaultMutableTreeNode("������Ϣ����");
		t1_1 = new DefaultMutableTreeNode("��ѯԱ��");
		t1_2 = new DefaultMutableTreeNode("���Ա��");
		t1_3 = new DefaultMutableTreeNode("�޸�Ա����Ϣ");
		t1_4 = new DefaultMutableTreeNode("ɾ��Ա������");
		t1_5 = new DefaultMutableTreeNode("��ѯȫ��Ա��");

		t2 = new DefaultMutableTreeNode("��Ա���˹���");
		t2_1 = new DefaultMutableTreeNode("��Ա����");
		t2_2 = new DefaultMutableTreeNode("������ʷ��ѯ");

		t1.add(t1_1);
		t1.add(t1_2);
		t1.add(t1_3);
		t1.add(t1_4);
		t1.add(t1_5);

		t2.add(t2_1);
		t2.add(t2_2);

		root.add(t1);
		root.add(t2);

		tree = new JTree(root);
		// �������м���

		tree.addTreeSelectionListener(this);

		// ʵ����CardEmploy��� ���ӵ�jsplitpane�ı�
		ae = new CardEmploy();

		js = new JSplitPane();
		js.setLeftComponent(tree);
		js.setRightComponent(ae);

		this.getContentPane().add(js);
		this.setTitle("���¹���ϵͳ");
		this.setVisible(true);
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void valueChanged(TreeSelectionEvent e) {

		// ��ȡ����������
		DefaultMutableTreeNode dpath = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		// ͨ�������ͬ����л���ͬ����
		if (dpath.equals(t1_1)) {
			ae.c.show(ae, "1");
		} else if (dpath.equals(t1_2)) {
			ae.c.show(ae, "2");
		} else if (dpath.equals(t1_3)) {
			ae.c.show(ae, "3");
		} else if (dpath.equals(t1_4)) {
			ae.c.show(ae, "4");
		} else if (dpath.equals(t1_5)) {
			ae.c.show(ae, "5");
		} else if (dpath.equals(t2_1)) {
			ae.c.show(ae, "6");
		} else if (dpath.equals(t2_2)) {
			ae.c.show(ae, "7");
		}
	}

}	
