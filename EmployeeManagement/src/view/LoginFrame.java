package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Util.DBUtil;
import Util.StringUtil;
import dao.UserDao;
import entity.User;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel login_background;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JComboBox powerJCB;
	
	private DBUtil dbUtil=new DBUtil();
	private UserDao userDao=new UserDao();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("员工信息管理系统V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 562);
		login_background = new JPanel();
		login_background.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(login_background);
		login_background.setLayout(null);
		
		JLabel username = new JLabel("账号");
		username.setBounds(629, 186, 59, 33);
		username.setFont(new Font("宋体", Font.PLAIN, 22));
		login_background.add(username);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(714, 188, 189, 33);
		login_background.add(usernameTxt);
		usernameTxt.setColumns(10);
		
		JLabel password = new JLabel("密码");
		password.setBounds(629, 256, 59, 33);
		password.setFont(new Font("宋体", Font.PLAIN, 22));
		login_background.add(password);
		
		JLabel power = new JLabel("权限");
		power.setBounds(629, 320, 59, 33);
		power.setFont(new Font("宋体", Font.PLAIN, 22));
		login_background.add(power);
		
		powerJCB = new JComboBox();
		powerJCB.setBounds(714, 320, 189, 33);
		powerJCB.setFont(new Font("宋体", Font.PLAIN, 22));
		powerJCB.setModel(new DefaultComboBoxModel(new String[] {"员工", "管理员"}));
		login_background.add(powerJCB);
		
		JButton btnNewButton = new JButton("登   录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.setBounds(629, 392, 274, 33);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		login_background.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("立即注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegFrame().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(806, 436, 97, 23);
		login_background.add(btnNewButton_1);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(714, 256, 189, 33);
		login_background.add(passwordTxt);
		
		JLabel lblNewLabel = new JLabel("background");
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/loginback.jpg")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(0, -22, 1000, 562);
		login_background.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);
		
	}
		//登陆事件处理
	private void loginActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String username=this.usernameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
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
		String power=null;
		String juris=(String) this.powerJCB.getSelectedItem();
		User user=new User(username, password, power);
		Connection con=null;
		if(juris.equals("管理员")) {
			user.setPower("管理员");
			try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if(currentUser!=null)
			{
				dispose();
				new AdminMainFrame().setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,"用户名或密码错误！");
			}
		}catch(Exception e1)
		{
			e1.printStackTrace();
			
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
			
		}else if(juris.equals("员工")) {
			user.setPower("员工");
			try {
				con=dbUtil.getCon();
				User currentUser=userDao.login(con, user);
				if(currentUser!=null)
				{
					dispose();
					new UserMainFrame().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"用户名或密码错误！");
				}
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				}catch(Exception e2)
				{
					e2.printStackTrace();
				}
			}			
		}
	}
}
