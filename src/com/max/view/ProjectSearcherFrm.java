package com.max.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.max.dao.ProjectDao;
import com.max.model.Project;
import com.maxwell.util.DbUtil;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectSearcherFrm extends JInternalFrame {
	private JTable p_table;
	private DbUtil dbUtil =new DbUtil();
	private ProjectDao projectDao =new ProjectDao();
	private JTextField p_searchtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectSearcherFrm frame = new ProjectSearcherFrm();
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
	public ProjectSearcherFrm() {
		setBackground(Color.WHITE);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u67E5\u770B\u6240\u6709");
		setBounds(100, 100, 828, 533);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u641C\u7D22\u9879\u76EE\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		
		p_searchtxt = new JTextField();
		p_searchtxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectSearchActionPerformed(e);
			}
		});
		p_searchtxt.setColumns(10);
		
		JButton p_seachButton = new JButton("\u641C\u7D22");
		p_seachButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectSearchActionPerformed(e);
			}
		});
		p_seachButton.setIcon(new ImageIcon(ProjectSearcherFrm.class.getResource("/images/\u641C\u7D22.png")));
		p_seachButton.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(134)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(p_searchtxt, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(p_seachButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(p_seachButton)
						.addComponent(lblNewLabel)
						.addComponent(p_searchtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		
		p_table = new JTable();
		p_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u516C\u53F8/\u4E2A\u4EBA\u540D\u79F0", "\u9879\u76EE\u540D\u79F0", "\u9879\u76EE\u63CF\u8FF0", "\u62DB\u8058\u4EBA\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		p_table.getColumnModel().getColumn(0).setPreferredWidth(37);
		p_table.getColumnModel().getColumn(1).setPreferredWidth(95);
		p_table.getColumnModel().getColumn(1).setMinWidth(20);
		p_table.getColumnModel().getColumn(2).setPreferredWidth(62);
		p_table.getColumnModel().getColumn(3).setPreferredWidth(184);
		p_table.getColumnModel().getColumn(3).setMinWidth(30);
		p_table.getColumnModel().getColumn(4).setPreferredWidth(61);
		scrollPane.setViewportView(p_table);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Project());

	}
	

	private void ProjectSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String p_search=this.p_searchtxt.getText();
		Project project=new Project();
		project.setP_name(p_search);
		this.fillTable(project);
	}

	/**
	 * 初始化填充表格
	 * @param project
	 */
	
	private void fillTable(Project project) {
		DefaultTableModel dtm=(DefaultTableModel)p_table.getModel();
		dtm.setRowCount(0);//清空表格
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=projectDao.list(con,project);
			while (rs.next()) {
				Vector vec=new Vector();
				vec.add(rs.getString("p_id"));
				vec.add(rs.getString("p_wname"));
				vec.add(rs.getString("p_name"));
				vec.add(rs.getString("p_dsp"));
				vec.add(rs.getString("p_sit"));
				dtm.addRow(vec);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
}
