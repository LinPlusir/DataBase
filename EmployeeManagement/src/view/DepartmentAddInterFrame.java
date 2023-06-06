package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Util.DBUtil;
import Util.StringUtil;
import dao.DepartmentDao;
import entity.Department;

public class DepartmentAddInterFrame extends JInternalFrame {
	private JTextField depart_nameTxt;
	private JLabel depart_name;
	private JLabel function;
	private JTextArea functionTxt;
	
	private DBUtil dbUtil=new DBUtil();
	private DepartmentDao departmentDao=new DepartmentDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentAddInterFrame frame = new DepartmentAddInterFrame();
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
	public DepartmentAddInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("部门添加");
		setBounds(100, 100, 655, 431);
		
		depart_name = new JLabel("部门名称");
		depart_name.setFont(new Font("宋体", Font.PLAIN, 20));
		
		depart_nameTxt = new JTextField();
		depart_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		depart_nameTxt.setColumns(10);
		
		function = new JLabel("部门功能");
		function.setFont(new Font("宋体", Font.PLAIN, 20));
		
		functionTxt = new JTextArea();
		functionTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentAddActionPerformed();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(130)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(depart_name, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(depart_nameTxt, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(function, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
								.addComponent(functionTxt, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))))
					.addGap(113))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(depart_name)
						.addComponent(depart_nameTxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(function, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(functionTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	private void departmentAddActionPerformed() {
		// TODO 自动生成的方法存根
		String depart_name=this.depart_nameTxt.getText();
		String function=this.functionTxt.getText();
		
		if(StringUtil.isEmpty(depart_name))
		{
			JOptionPane.showMessageDialog(null,"部门名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(function))
		{
			JOptionPane.showMessageDialog(null,"部门功能不能为空！");
			return;
		}
		
		Department department=new Department(depart_name,function);
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addnum=departmentDao.add(con, department);
			if(addnum==1)
			{
				JOptionPane.showMessageDialog(null,"添加成功！");
				resetNull();
			}
			else {
				JOptionPane.showMessageDialog(null,"添加失败！");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	//	重置事件处理
	private void resetActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		resetNull();
	}
	public void resetNull() {
		this.depart_nameTxt.setText("");
		this.functionTxt.setText("");
	}
}
