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
		//北部
		jp = new JPanel();
		jl1 = new JLabel("全体员工",JLabel.CENTER);
		jl1.setFont(new Font("黑体", Font.BOLD, 30));
        jp.add(jl1);

        //中部
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