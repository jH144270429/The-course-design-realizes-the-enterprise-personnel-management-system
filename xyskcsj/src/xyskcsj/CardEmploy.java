package xyskcsj;

import javax.swing.*;
import java.awt.*;
public class CardEmploy extends Panel{
	
	CardLayout c;
    //��ѯ��
	SelEmploy selE;
	//��ӱ�
	AddEmploy addE;

    //�޸�Ա����Ϣ��
    ReviseEmploy revE;
    
    //ɾ��Ա�����
    DelEmploy delE;
    
    //����Ա����Ϣ
    AllEmploy allE;
    
    //Ա�����˱�
    Examine exaE;
    
    //��ʷ��¼����
    History His;
    public CardEmploy()
    {
    	//��ѯԱ����
    	selE = new SelEmploy();
		
		//���Ա����
		addE = new AddEmploy();
    	
    	//�޸�Ա����Ϣ
    	revE = new ReviseEmploy();
    	
        //ɾ��Ա�����
    	delE = new DelEmploy();
    	
        //����Ա����Ϣ
    	allE =new AllEmploy();
    	
        //Ա�����˱�
        exaE = new Examine();
        //��ʷ��¼����
        His = new History();
        
        
        JPanel jp = new JPanel();
        
    	//����cardemploy���  Ϊ��Ƭ����
        //�Ѹ��������뵽C�Ŀ�Ƭ������
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