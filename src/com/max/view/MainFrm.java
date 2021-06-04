package com.max.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table_1=null;

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
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4EFB\u52A1\u7BA1\u7406.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u67E5\u770B\u6240\u6709");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u65B0\u589E\u9879\u76EE");
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_1 = new JMenu("\u4EBA\u5458");
		mnNewMenu_1.setBackground(Color.WHITE);
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0\u7FA4\u7EC4.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5BA2\u6237");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u81EA\u7531\u5DE5\u4F5C\u8005");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("\u4E2A\u4EBA");
		mnNewMenu_2.setBackground(Color.WHITE);
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u901A\u8BAF\u5F55.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F");
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u65F6\u95F4\u8868");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_5 = new JMenu("\u65E5\u5FD7");
		mnNewMenu_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5BC6\u8BED.png")));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u672A\u5B8C\u6210\u529F\u80FD");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UndoneFrm undoneFrm= new UndoneFrm();
				undoneFrm.setVisible(true);
				table_1.add(undoneFrm);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "要退出系统吗？QAQ");
				if (result==0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem.setBackground(Color.WHITE);
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u673A.png")));
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table_1 = new JDesktopPane();
		table_1.setBorder(null);
		table_1.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 1534, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 769, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
