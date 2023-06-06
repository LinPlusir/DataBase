package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UserMainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainFrame frame = new UserMainFrame();
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
	public UserMainFrame() {
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		setTitle("员工信息管理系统v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 702);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("个人信息管理");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("基本信息维护");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonManagerInterFrame PersonManagerInterFrame=new PersonManagerInterFrame();
				PersonManagerInterFrame.setVisible(true);
				table.add(PersonManagerInterFrame);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
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
