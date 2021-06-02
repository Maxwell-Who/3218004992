package com.max.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrm() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);//设置窗体最大化
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/\u901A\u8BAF\u6A21\u5F0F.png")));
		setTitle("\u670D\u52A1\u51FA\u79DF\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 488);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u9879\u76EE");
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4EFB\u52A1\u7BA1\u7406.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_8 = new JMenu("\u65B0\u5EFA\u9879\u76EE");
		mnNewMenu.add(mnNewMenu_8);
		
		JMenu mnNewMenu_9 = new JMenu("\u9879\u76EE\u5206\u7C7B");
		mnNewMenu.add(mnNewMenu_9);
		
		JMenu mnNewMenu_10 = new JMenu("\u67E5\u627E\u9879\u76EE");
		mnNewMenu.add(mnNewMenu_10);
		
		JMenu mnNewMenu_1 = new JMenu("\u4EBA\u5458");
		mnNewMenu_1.setBackground(Color.WHITE);
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0\u7FA4\u7EC4.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_3 = new JMenu("\u5BA2\u6237");
		mnNewMenu_3.setBackground(Color.WHITE);
		mnNewMenu_1.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("\u81EA\u7531\u804C\u4E1A\u8005");
		mnNewMenu_4.setBackground(Color.WHITE);
		mnNewMenu_1.add(mnNewMenu_4);
		
		JMenu mnNewMenu_2 = new JMenu("\u65F6\u95F4\u8868");
		mnNewMenu_2.setBackground(Color.WHITE);
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u901A\u8BAF\u5F55.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_5 = new JMenu("\u65E5\u5FD7");
		mnNewMenu_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5BC6\u8BED.png")));
		menuBar.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("\u5B89\u5168\u65E5\u5FD7");
		mnNewMenu_6.setBackground(Color.WHITE);
		mnNewMenu_5.add(mnNewMenu_6);
		
		JMenu mnNewMenu_7 = new JMenu("\u5BA1\u8BA1\u65E5\u5FD7");
		mnNewMenu_7.setBackground(Color.WHITE);
		mnNewMenu_5.add(mnNewMenu_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 634, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 415, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
