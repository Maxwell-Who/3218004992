package com.max.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.max.dao.ScheduleDao;
import com.max.model.Schedule;
import com.maxwell.util.DbUtil;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.event.ActionEvent;

public class ScheduleFrm extends JInternalFrame {
	private JTable s_table;
	private DbUtil dbUtil =new DbUtil();
	private ScheduleDao scheduleDao =new ScheduleDao();
	private JTextField s_searchtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleFrm frame = new ScheduleFrm();
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
	public ScheduleFrm() {
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 535, 425);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u67E5\u627E\u7A7A\u95F2\u65F6\u95F4\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		
		s_searchtxt = new JTextField();
		s_searchtxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleSearchActionPerformed(e);
			}
		});
		s_searchtxt.setColumns(10);
		
		JButton s_Button = new JButton("\u641C\u7D22");
		s_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleSearchActionPerformed(e);
			}
		});
		s_Button.setIcon(new ImageIcon(ScheduleFrm.class.getResource("/images/\u641C\u7D22.png")));
		s_Button.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_searchtxt, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_Button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
					.addGap(63))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_searchtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_Button))
					.addGap(39)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
		);
		
		s_table = new JTable();
		s_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5DE5\u4F5C\u8005\u540D\u79F0", "\u5DE5\u4F5C\u65F6\u95F4", "\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(s_table);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new Schedule());

	}
	
	private void ScheduleSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		String s_search=this.s_searchtxt.getText();
		//System.out.println(s_search); 
		Schedule schedule = new Schedule();
		schedule.setS_time(s_search);
		this.fillTable(schedule);
	}

	private void fillTable(Schedule schedule) {
		DefaultTableModel dtm=(DefaultTableModel)s_table.getModel();
		dtm.setRowCount(0);//清空表格
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=scheduleDao.list(con,schedule);
			while (rs.next()) {//进行遍历
				Vector vec=new Vector();
				vec.add(rs.getString("s_name"));
				vec.add(rs.getString("s_time"));
				vec.add(rs.getString("s_mark"));
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
