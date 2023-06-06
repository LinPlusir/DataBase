package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AdminMainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainFrame frame = new AdminMainFrame();
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
	@SuppressWarnings("removal")
	public AdminMainFrame() {
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		setTitle("员工信息管理系统v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 743);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("部门管理");
		mnNewMenu.setSelectedIcon(null);
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("部门添加");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentAddInterFrame departmentAddInterFrame=new DepartmentAddInterFrame();
				departmentAddInterFrame.setVisible(true);
				table.add(departmentAddInterFrame);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("部门维护");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentManagerInterFrame departmentManagerInterFrame=new DepartmentManagerInterFrame();
				departmentManagerInterFrame.setVisible(true);
				table.add(departmentManagerInterFrame);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("岗位添加");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostAddInterFrame postAddInterFrame=new PostAddInterFrame();
				postAddInterFrame.setVisible(true);
				table.add(postAddInterFrame);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("岗位维护");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostManagerInterFrame postManagerInterFrame=new PostManagerInterFrame();
				postManagerInterFrame.setVisible(true);
				table.add(postManagerInterFrame);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("员工信息管理");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("基本信息录入");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffAddInterFrame staffAddInterFrame=new StaffAddInterFrame();
				staffAddInterFrame.setVisible(true);
				table.add(staffAddInterFrame);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("基本信息维护");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffManagerInterFrame staffManagerInterFrame=new StaffManagerInterFrame();
				staffManagerInterFrame.setVisible(true);
				table.add(staffManagerInterFrame);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		contentPane.add(table,BorderLayout.CENTER);
		final JLabel background=new JLabel();
		
		URL resource=this.getClass().getResource("/image/back.jpg");
		final ImageIcon icon=new ImageIcon(resource);
		
		icon.setImage(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		background.setIcon(icon);
		background.setBounds(0,0,this.getWidth(),this.getHeight());
		table.add(background,new Integer(Integer.MIN_VALUE));
		
		getContentPane().addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				int width=e.getComponent().getWidth();
				int height=e.getComponent().getHeight();
				icon.setImage(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
				background.setBounds(0,0,width,height);
			}
		});
	}
}
