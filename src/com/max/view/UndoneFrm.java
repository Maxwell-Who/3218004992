package com.max.view;
/**
 * 这是用来放未完成功能的 比如那啥生成日志 既然没有要求 那我就不写了  = =
 */
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;

public class UndoneFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UndoneFrm frame = new UndoneFrm();
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
	public UndoneFrm() {
		setTitle("\u672A\u5B8C\u6210\u529F\u80FD");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("     \u4F60\u4E4B\u6240\u4EE5\u770B\u5230\u8FD9\u884C\u5B57\uFF0C\u662F\u56E0\u4E3A\u6211\u6765\u4E0D\u53CA\u505A\u8FD9\u4E2A\u529F\u80FD\u4E86\uFF0C\u975E\u5E38\u62B1\u6B49 QAQ");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBackground(Color.WHITE);
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);

	}

}
