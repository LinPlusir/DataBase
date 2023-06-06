package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Util.DBUtil;
import Util.StringUtil;
import dao.PostDao;
import entity.Post;

public class PostManagerInterFrame extends JInternalFrame {
	private JTable post_table;

	private DBUtil dbUtil=new DBUtil();
	private PostDao postDao=new PostDao();
	private JTextField s_post_nameTxt;
	private JTextField post_idTxt;
	private JTextField post_nameTxt;
	private JTextArea post_salaryTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostManagerInterFrame frame = new PostManagerInterFrame();
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
	public PostManagerInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("岗位维护");
		setBounds(100, 100, 722, 577);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(scrollPane))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(62, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("编号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		post_idTxt = new JTextField();
		post_idTxt.setEditable(false);
		post_idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("岗位名称");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		post_nameTxt = new JTextField();
		post_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		post_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("岗位薪资");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		post_salaryTxt = new JTextArea();
		post_salaryTxt.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postDeleteActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(post_idTxt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(post_nameTxt, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
							.addGap(43))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(post_salaryTxt, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(post_nameTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(post_idTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)
							.addComponent(lblNewLabel_1)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(post_salaryTxt, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("岗位名称");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		s_post_nameTxt = new JTextField();
		s_post_nameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		s_post_nameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查 询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_post_nameTxt, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_post_nameTxt, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		post_table = new JTable();
		post_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				postTableMousePressed(e);
			}
		});
		post_table.setFont(new Font("宋体", Font.PLAIN, 15));
		post_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5C97\u4F4D\u7F16\u53F7", "\u5C97\u4F4D\u540D\u79F0", "\u5C97\u4F4D\u85AA\u8D44"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(post_table);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Post());
	}
	
	
	//删除事件处理
	private void postDeleteActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String post_id=this.post_idTxt.getText();
		if(StringUtil.isEmpty(post_id))
		{
			JOptionPane.showMessageDialog(null,"请选择要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该条记录吗？");
		if(n==0)
		{
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int num=postDao.delete(con, post_id);
				{
					if(num==1)
					{
						JOptionPane.showMessageDialog(null,"删除成功！");
						this.resetNull();
						this.fillTable(new Post());
					}
					else {
						JOptionPane.showMessageDialog(null,"删除失败！");
					}
				}
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null,"删除失败！");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		}
	}

	//修改事件处理
	private void postUpdateActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String post_id=this.post_idTxt.getText();
		String post_name=this.post_nameTxt.getText();
		String post_desc=this.post_salaryTxt.getText();
		
		if(StringUtil.isEmpty(post_id))
		{
			JOptionPane.showMessageDialog(null,"请选择要修改的记录！");
			return;
		}
		if(StringUtil.isEmpty(post_name))
		{
			JOptionPane.showMessageDialog(null,"岗位名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(post_desc))
		{
			JOptionPane.showMessageDialog(null,"岗位功能不能为空！");
			return;
		}
		
		Post post=new Post(Integer.parseInt(post_id), post_name, post_desc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int num=postDao.update(con, post);
			if(num==1)
			{
				JOptionPane.showMessageDialog(null,"修改成功！");
				this.resetNull();
				this.fillTable(new Post());
			}
			else {
				JOptionPane.showMessageDialog(null,"修改失败！");
			}
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}

	//表格点击事件
	private void postTableMousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		int row=this.post_table.getSelectedRow();
		this.post_idTxt.setText((String) this.post_table.getValueAt(row, 0));
		this.post_nameTxt.setText((String) this.post_table.getValueAt(row,1));
		this.post_salaryTxt.setText((String) this.post_table.getValueAt(row, 2));
	}

	//查询事件处理
	private void postSearchActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String s_post_name=this.s_post_nameTxt.getText();
		Post post=new Post();
		post.setPost_name(s_post_name);
		this.fillTable(post);
		
	}
	//初始化表格
	private void fillTable(Post post)
	{
		DefaultTableModel dtm=(DefaultTableModel)this.post_table.getModel();
		dtm.setRowCount(0);
		Connection con=null;

		try {
			con=dbUtil.getCon();
			ResultSet rs=postDao.list(con,post);
			while(rs.next())
			{
				Vector v=new Vector<>();
				v.add(rs.getString("post_id"));
				v.add(rs.getString("post_name"));
				v.add(rs.getString("post_salary"));
				dtm.addRow(v);
			}
		}catch(Exception e){
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
	
	
	//置空表单
	private void resetNull() {
		this.post_idTxt.setText("");
		this.post_nameTxt.setText("");
		this.post_salaryTxt.setText("");
		
	}
}
