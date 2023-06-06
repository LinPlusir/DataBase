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
import dao.PostDao;
import entity.Post;

public class PostAddInterFrame extends JInternalFrame {
	private JTextField post_nameTxt;
	private JLabel post_name;
	private JLabel post_salary;
	private JTextArea post_salaryTxt;
	
	private DBUtil dbUtil=new DBUtil();
	private PostDao postDao=new PostDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostAddInterFrame frame = new PostAddInterFrame();
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
	public PostAddInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("岗位添加");
		setBounds(100, 100, 653, 431);
		
		post_name = new JLabel("岗位名称");
		post_name.setFont(new Font("宋体", Font.PLAIN, 20));
		
		post_nameTxt = new JTextField();
		post_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		post_nameTxt.setColumns(10);
		
		post_salary = new JLabel("岗位薪资");
		post_salary.setFont(new Font("宋体", Font.PLAIN, 20));
		
		post_salaryTxt = new JTextArea();
		post_salaryTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postAddActionPerformed(); 
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
							.addComponent(post_name, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(post_nameTxt, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(post_salary, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
								.addComponent(post_salaryTxt, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))))
					.addGap(113))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(post_name)
						.addComponent(post_nameTxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(post_salary, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(post_salaryTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	//岗位添加
	private void postAddActionPerformed() {
		// TODO 自动生成的方法存根
		String post_name=this.post_nameTxt.getText();
		String post_salary=this.post_salaryTxt.getText();
		
		if(StringUtil.isEmpty(post_name))
		{
			JOptionPane.showMessageDialog(null,"岗位名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(post_salary))
		{
			JOptionPane.showMessageDialog(null,"岗位薪资不能为空！");
			return;
		}
		
		Post post=new Post(post_name,post_salary);
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addnum=postDao.add(con, post);
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
		this.post_nameTxt.setText("");
		this.post_salaryTxt.setText("");
	}
}
