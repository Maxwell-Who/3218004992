package com.max.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

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
		setBounds(100, 100, 450, 300);

	}

}
