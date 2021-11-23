package booksys.presentation;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import booksys.application.domain.Booking;
 
class MenuDialog extends Dialog{
    int count = 0;
    String show = "";
    int allPrice=0;
    int num=0;
    protected boolean   confirmed ;
    List menuName=new ArrayList();
 
    MenuDialog(Frame owner,String title){
    	this(owner,title,null);
    }
    
    
  MenuDialog(Frame owner, String title, Booking booking) {
 
	  super(owner, title, true) ;
        // �����δ�
        // ������ ������
	  
	  addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			  confirmed = false ;
			  MenuDialog.this.hide() ;
			}
		      }) ;
	  

        setBounds(0, 0, 625, 625);
    
 
        // ��Ʈ
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // ����
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(255, 255, 255));
        pNorth.setLayout(null);
        pNorth.setSize(0, 500);
        pNorth.setFont(font);
 
        // �迭 ���� �κ�
        String menu[] = { "PASTA", "STEAK", "PILAU", "SALAD", "A_COURSE", "B_COURSE", "C_COURSE", "D_COURSE" };
        int price[] = { 15000, 45000, 13000, 9900, 70000, 80000, 90000, 120000 };
        JButton bt[] = new JButton[menu.length];
        TextField suja[] = new TextField[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length];
        JButton ok[] = new JButton[menu.length];
        Label l[] = new Label[menu.length];
        ImageIcon icon[] = new ImageIcon[menu.length];
 
        // ��ư ���� �κ�
        for (int i = 0; i < menu.length; i++) {
 
            // �ܹ��� ��ư
            bt[i] = new JButton(menu[i]);
            if (i < 4) {
                bt[i].setBounds(25 + i * 150, 50, 100, 70);
            } else {
                bt[i].setBounds(25 + (i - 4) * 150, 250, 100, 70);
            }
            icon[i] = new ImageIcon(i + ".png");
            bt[i].setIcon(icon[i]);
 
            // ���� txt ��ư
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 80, 40, 20);
 
            // "-" ��ư
            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" ��ư
            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // ����
            l[i] = new Label(price[i] + "��");
            l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 55, 100, 20);
 
            // Ȯ�� ��ư
            ok[i] = new JButton("Ȯ��");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
 
            pNorth.add(bt[i]);
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(l[i]);
            pNorth.add(ok[i]);
        }
 
        // �߾�
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);
        ta.setFont(font1);
 
        // ����
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(255, 255, 255));
 
        Button bt1 = new Button("�ֹ�����");
        Button bt2 = new Button("�ʱ�ȭ");
        Button bt3 = new Button("�ݱ�");
        pSouth.add(bt1);
        pSouth.add(bt2);
        pSouth.add(bt3);
        // �ֹ���ư
        bt1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, ta.getText() + " �ֹ��Ǿ����ϴ�. \n�̿����ּż� �����մϴ�.");
                for (int i = 0; i < menu.length; i++) {
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
 
                }
         
               
                MenuDialog.this.hide();
            }
        });
 
        // �ʱ�ȭ ��ư
        bt2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < menu.length; i++) {
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    ta.setText("   ��ǰ��        �ܰ�        ����        �հ�\n\n");
 
                }
                
                System.out.println(allPrice);
            }
        });
 
 
        //bt3 �ݱ��ư
        
        bt3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDialog.this.hide();
            }
        });
 
 

 
     
        // �̺�Ʈ��
        for (int i = 0; i < menu.length; i++) {
            int j = i;
 
            // �ܹ��� ��ư �̺�Ʈ
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minus[j].setEnabled(true);
                    plus[j].setEnabled(true);
                    bt[j].setEnabled(false);
                    ok[j].setEnabled(true);
 
                    count = 0;
                }
            });
 
            // "-" ��ư �̺�Ʈ
            minus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        suja[j].setText(count + "");
                        ok[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });
            
            // "+" ��ư �̺�Ʈ
            plus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    suja[j].setText(count + "");
                    ok[j].setEnabled(true);
                    if (count > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });
            
            //Ȯ�� ��ư �̺�Ʈ
            ok[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    show = bt[j].getActionCommand();
                    ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
                            + "��" + "\n");
               
                    menuName.add(show+"x"+count+"_");
                    allPrice+=(price[j]*count);
                    ok[j].setEnabled(false);
                }
            });
 
        }
 
        // ����
        // ������Ʈ
        add(pNorth, BorderLayout.NORTH);
        add(ta, BorderLayout.CENTER);
        add(pSouth, BorderLayout.SOUTH);
        setVisible(true);
    }
}


