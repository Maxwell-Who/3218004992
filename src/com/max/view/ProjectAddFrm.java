package com.max.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.max.dao.ProjectDao;
import com.max.model.Project;
import com.maxwell.util.DbUtil;
import com.maxwell.util.StringUtil;

public class ProjectAddFrm extends JInternalFrame {
	private JTextField p_wnametxt;
	private JTextField p_nametxt;
	private JTextField p_sittxt;
	private JTextArea p_dsptxt;
	private DbUtil dbUtil =new DbUtil();
	private ProjectDao projectDao =new ProjectDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectAddFrm frame = new ProjectAddFrm();
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
	public ProjectAddFrm() {
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setIconifiable(true);
		setTitle("\u65B0\u589E\u9879\u76EE");
		setBounds(100, 100, 487, 327);
		
		JLabel lblNewLabel = new JLabel("\u516C\u53F8/\u4E2A\u4EBA\u540D\u79F0");
		
		JLabel lblNewLabel_1 = new JLabel("\u9879\u76EE\u540D\u79F0");
		
		JLabel lblNewLabel_2 = new JLabel("\u9879\u76EE\u63CF\u8FF0");
		
		JLabel lblNewLabel_3 = new JLabel("\u8058\u7528\u4EBA\u6570");
		
		p_wnametxt = new JTextField();
		p_wnametxt.setColumns(10);
		
		p_nametxt = new JTextField();
		p_nametxt.setColumns(10);
		
		p_sittxt = new JTextField();
		p_sittxt.setColumns(10);
		
		p_dsptxt = new JTextArea();
		p_dsptxt.setBackground(Color.WHITE);
		p_dsptxt.setLineWrap(true);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.setIcon(new ImageIcon(ProjectAddFrm.class.getResource("/images/\u5220\u9664.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ProjectAddFrm.class.getResource("/images/\u7F16\u8F91.png")));
		btnNewButton_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(p_dsptxt)
								.addComponent(p_nametxt)
								.addComponent(p_wnametxt, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
								.addComponent(p_sittxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(127, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(83))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(p_wnametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(p_nametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(p_dsptxt, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(p_sittxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		p_dsptxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false)); //设置边框

	}
	
	/**
	 * 新增项目
	 * @param e
	 */
	private void addActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String p_wname=this.p_wnametxt.getText();
		String p_name=this.p_nametxt.getText();
		String p_dsp=this.p_dsptxt.getText();
		String p_sit=this.p_sittxt.getText();
		if(StringUtil.isEmpty(p_name)) {
			JOptionPane.showMessageDialog(null, "项目名称不可为空 O ^ O ");
			return;
		}
		Project project = new Project(p_wname, p_name, p_dsp, p_sit);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n = projectDao.add(con, project);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "新增项目成功！ = w = ");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "新增项目失败！ Q A Q ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "新增项目失败！ Q A Q ");
			// TODO: handle exception
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置文本框内容
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	private void resetValue() {
		this.p_nametxt.setText("");
		this.p_wnametxt.setText("");
		this.p_dsptxt.setText("");
		this.p_sittxt.setText("");
	}
	
}
