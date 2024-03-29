package com.max.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.max.dao.WorkerDao;
import com.max.model.Worker;
import com.maxwell.util.DbUtil;

public class WorkerSearchFrm extends JInternalFrame {
	private DbUtil dbUtil =new DbUtil();
	private WorkerDao workerDao =new WorkerDao();
	private JTextField w_searchtxt;
	private JTable w_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkerSearchFrm frame = new WorkerSearchFrm();
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
	public WorkerSearchFrm() {
		setBackground(Color.WHITE);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u81EA\u7531\u5DE5\u4F5C\u8005");
		setBounds(100, 100, 828, 533);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u641C\u7D22\u81EA\u7531\u5DE5\u4F5C\u8005\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		
		w_searchtxt = new JTextField();
		/*w_searchtxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerSearchActionPerformed(e);
			}
		});*/
		w_searchtxt.setColumns(10);
		
		JButton w_seachButton = new JButton("\u641C\u7D22");
		w_seachButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerSearchActionPerformed(e);
			}
		});
		w_seachButton.setIcon(new ImageIcon(WorkerSearchFrm.class.getResource("/images/\u641C\u7D22.png")));
		w_seachButton.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(134)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(w_searchtxt, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(w_seachButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(w_seachButton)
						.addComponent(lblNewLabel)
						.addComponent(w_searchtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		
		w_table = new JTable();
		w_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u4E13\u4E1A\u9886\u57DF", "\u7535\u8BDD\u53F7\u7801", "QQ\u53F7", "\u5FAE\u4FE1\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(w_table);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Worker());

	}
	

	private void WorkerSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String search=this.w_searchtxt.getText();
		System.out.println(search); 
		Worker worker=new Worker();
		worker.setW_pro(search);
		this.fillTable(worker);
	}

	/**
	 * 初始化填充表格
	 * @param worker
	 * 
	 */
	
	private void fillTable(Worker worker) {
		DefaultTableModel dtm=(DefaultTableModel)w_table.getModel();
		dtm.setRowCount(0);//清空表格
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=workerDao.list(con,worker);
			while (rs.next()) {
				Vector vec=new Vector();
				vec.add(rs.getString("w_id"));
				vec.add(rs.getString("w_name"));
				vec.add(rs.getString("w_pro"));
				vec.add(rs.getString("w_phone"));
				vec.add(rs.getString("w_qq"));
				vec.add(rs.getString("w_wechat"));
				vec.add(rs.getString("w_flag"));
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
