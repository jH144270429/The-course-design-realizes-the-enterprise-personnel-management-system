package xyskcsj;

import javax.swing.*;
import java.awt.*;
public class CardEmploy extends Panel{
	
	CardLayout c;
    //查询表
	SelEmploy selE;
	//添加表
	AddEmploy addE;

    //修改员工信息表
    ReviseEmploy revE;
    
    //删除员工表格
    DelEmploy delE;
    
    //所有员工信息
    AllEmploy allE;
    
    //员工考核表
    Examine exaE;
    
    //历史记录界面
    History His;
    public CardEmploy()
    {
    	//查询员工表
    	selE = new SelEmploy();
		
		//添加员工表
		addE = new AddEmploy();
    	
    	//修改员工信息
    	revE = new ReviseEmploy();
    	
        //删除员工表格
    	delE = new DelEmploy();
    	
        //所有员工信息
    	allE =new AllEmploy();
    	
        //员工考核表
        exaE = new Examine();
        //历史记录界面
        His = new History();
        
        
        JPanel jp = new JPanel();
        
    	//定义cardemploy面板  为卡片布局
        //把各个面板加入到C的卡片布局中
    	c = new CardLayout();
    	this.setLayout(c);
    	this.add(selE,"1");
    	this.add(addE,"2");
    	this.add(revE,"3");
    	this.add(delE,"4");
    	
    	this.add(allE,"5");
    	this.add(exaE,"6");
    	this.add(His,"7");
    }
}