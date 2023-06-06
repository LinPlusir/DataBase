package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Util.DBUtil;
import Util.StringUtil;
import dao.UserDao;
import entity.User;

public class RegFrame extends JFrame {

	private JPanel login_background;
	private JTextField usernameTxt;
	
	private DBUtil dbUtil=new DBUtil();
	private UserDao userDao=new UserDao();
	private JPasswordField passwordTxt;
	private JPasswordField re_passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegFrame frame = new RegFrame();
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
	public RegFrame() {
		setTitle("员工信息管理系统V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 562);
		login_background = new JPanel();
		login_background.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(login_background);
		login_background.setLayout(null);
		
		JLabel username = new JLabel("用户名");
		username.setBounds(581, 219, 75, 33);
		username.setFont(new Font("宋体", Font.PLAIN, 22));
		login_background.add(username);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(682, 219, 189, 33);
		login_background.add(usernameTxt);
		usernameTxt.setColumns(10);
		
		JLabel password = new JLabel("密码");
		password.setBounds(591, 262, 59, 33);
		password.setFont(new Font("宋体", Font.PLAIN, 22));
		login_background.add(password);
		
		JLabel re_password = new JLabel("确认密码");
		re_password.setBounds(559, 305, 97, 33);
		re_password.setFont(new Font("宋体", Font.PLAIN, 22));
		login_background.add(re_password);
		
		JButton btnNewButton = new JButton("立 即 注 册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regActionPerformed(e);
			}
		});
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.setBounds(597, 370, 274, 42);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		login_background.add(btnNewButton);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(682, 264, 189, 33);
		login_background.add(passwordTxt);
				
		re_passwordTxt = new JPasswordField();
		re_passwordTxt.setBounds(682, 307, 189, 33);
		login_background.add(re_passwordTxt);
		
		JLabel lblNewLabel = new JLabel("background");
		lblNewLabel.setIcon(new ImageIcon(RegFrame.class.getResource("/image/register2.jpg")));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(0, -9, 998, 562);
		login_background.add(lblNewLabel);
		
		
		this.setLocationRelativeTo(null);
	}
	//注册时间处理
	private void regActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String username=this.usernameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		String re_password=new String(this.re_passwordTxt.getPassword());

		if(StringUtil.isEmpty(username))
		{
			JOptionPane.showMessageDialog(null,"用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password))
		{
			JOptionPane.showMessageDialog(null,"密码不能为空！");
			return;
		}
		if(StringUtil.isEmpty(re_password))
		{
			JOptionPane.showMessageDialog(null,"确认密码不能为空！");
			return;
		}
		if(password.equals(re_password)) {
			Connection con=null;
			User user=new User(username,password); 
			
			try {
				con=dbUtil.getCon();
				int addnum=userDao.addUser(con, user);
				if(addnum==1) {
					JOptionPane.showMessageDialog(null,"注册成功！");
				}
				else {
					JOptionPane.showMessageDialog(null,"注册失败！");
				}
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				}catch (Exception e2){
					e2.printStackTrace();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"两次密码不一致！");
			return;
		}
	}
}
