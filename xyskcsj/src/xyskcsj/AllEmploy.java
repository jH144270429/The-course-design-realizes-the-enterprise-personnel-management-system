package xyskcsj;
import java.awt.*;

import javax.swing.*;

public class AllEmploy extends Panel{
	EmployModel em;
	JTable jt;
	JScrollPane jsp;
    JLabel jl1;
    JPanel jp;
	public AllEmploy()
	{
		//����
		jp = new JPanel();
		jl1 = new JLabel("ȫ��Ա��",JLabel.CENTER);
		jl1.setFont(new Font("����", Font.BOLD, 30));
        jp.add(jl1);

        //�в�
		em = new EmployModel();
		String []paras ={"1"};
		em.queryEmploy("select * from Employinfo where 1 = ?", paras);		
		jt = new JTable(em);		
		jsp = new JScrollPane(jt);		
		
		this.setLayout(new BorderLayout());
	    this.add(jp,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.CENTER);
	}
		
}