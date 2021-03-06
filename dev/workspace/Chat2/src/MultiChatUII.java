import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class MultiChatUII {

	private JPanel contentPane;
	
	protected JLabel chatLabel;
	protected JTextArea c_msgOut;
	protected JTextField msgInput;
	protected JButton sendButton;
	
	protected JLabel userLabel;
	protected JTextField idInput;
	protected JPanel loginPanel;
	protected JButton loginButton;
	protected JLabel idOutLabel;
	protected JPanel logoutPanel;
	protected JButton logoutButton;
	
	protected Container tab;
	protected CardLayout cardLayout;
	
	protected JLabel contactLabel;
	protected DefaultListModel<String> nameOutModel;
	protected JList<String> nameOut;
	protected JRadioButton secretRadio;
	
	protected JButton deleteButton;
	
	protected JButton exitButton;
	
	protected static String id;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiChatUII window = new MultiChatUII();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MultiChatUII() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 358);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane(c_msgOut, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setBounds(12, 27, 338, 253);
		contentPane.add(scrollPane1);
		
		c_msgOut = new JTextArea();
		c_msgOut.setFont(new Font("a시네마M", Font.PLAIN, 12));
		c_msgOut.setBackground(new Color(250, 235, 215));
		c_msgOut.setEditable(false);
		c_msgOut.setLineWrap(true); // 줄바꿈 ok
		c_msgOut.setWrapStyleWord(true); // 단어 단위 줄바꿈 ok
		scrollPane1.setViewportView(c_msgOut);
		
		chatLabel = new JLabel(" ~ 채팅방 ~");
		chatLabel.setFont(new Font("a시네마M", Font.PLAIN, 13));
		chatLabel.setBounds(12, 3, 77, 25);
		contentPane.add(chatLabel);
		
		msgInput = new JTextField();
		msgInput.setFont(new Font("a시네마M", Font.PLAIN, 12));
		msgInput.setBounds(12, 313, 277, 21);
		contentPane.add(msgInput);
		msgInput.setColumns(10);
		
		sendButton = new JButton("전송");
		sendButton.setFont(new Font("a시네마M", Font.PLAIN, 12));
		sendButton.setBounds(289, 312, 61, 23);
		contentPane.add(sendButton);
		
		userLabel = new JLabel(" ~ 사용자 ~\r\n");
		userLabel.setFont(new Font("a시네마M", Font.PLAIN, 13));
		userLabel.setBounds(374, 10, 116, 15);
		contentPane.add(userLabel);

		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(230, 230, 250));
		loginPanel.setBounds(374, 28, 116, 46);
		//contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		idInput = new JTextField();
		idInput.setFont(new Font("a시네마M", Font.PLAIN, 12));
		idInput.setBounds(0, 0, 116, 21);
		idInput.setColumns(10);
		loginPanel.add(idInput);
		
		loginButton = new JButton("로그인");
		loginButton.setFont(new Font("a시네마M", Font.PLAIN, 12));
		loginButton.setBounds(0, 23, 116, 23);
		loginPanel.add(loginButton);
		
		logoutPanel = new JPanel();
		logoutPanel.setBackground(new Color(230, 230, 250));
		logoutPanel.setBounds(374, 28, 116, 46);
		//contentPane.add(logoutPanel);
		logoutPanel.setLayout(null);

		idOutLabel = new JLabel();
		idOutLabel.setFont(new Font("a시네마M", Font.PLAIN, 12));
		idOutLabel.setBounds(0, 0, 116, 21);
		logoutPanel.add(idOutLabel);
		
		logoutButton = new JButton("로그아웃");
		logoutButton.setFont(new Font("a시네마M", Font.PLAIN, 12));
		logoutButton.setBounds(0, 23, 116, 23);
		logoutPanel.add(logoutButton);

		tab = new JPanel();
		cardLayout = new CardLayout(0, 0);
		
		tab.setLayout(cardLayout);
		tab.add(loginPanel, "login");
		tab.add(logoutPanel, "logout");
		
		add(tab);
		tab.setBounds(374, 28, 116, 46);
		
		contactLabel = new JLabel(" ~ 접속자 ~");
		contactLabel.setFont(new Font("a시네마M", Font.PLAIN, 13));
		contactLabel.setBounds(374, 96, 77, 15);
		contentPane.add(contactLabel);
		
		JScrollPane scrollpane2 = new JScrollPane(nameOut, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane2.setBounds(374, 114, 116, 120);
		contentPane.add(scrollpane2);
		
		nameOutModel = new DefaultListModel<>();
		nameOut = new JList<>(nameOutModel);
		nameOut.setFont(new Font("a시네마M", Font.PLAIN, 12));
		nameOut.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollpane2.setViewportView(nameOut);
		
//		secretRadio = new JRadioButton("귓속말");
//		secretRadio.setFont(new Font("a시네마M", Font.PLAIN, 12));
//		contactLabel.setBounds(374, 200, 77, 15);
//		contentPane.add(secretRadio);
		
		exitButton = new JButton("종료");
		exitButton.setFont(new Font("a시네마M", Font.PLAIN, 12));
		exitButton.setBounds(374, 311, 116, 23);
		contentPane.add(exitButton);
		
		deleteButton = new JButton("전체 기록 삭제");
		deleteButton.setFont(new Font("a시네마M", Font.PLAIN, 12));
		deleteButton.setBounds(374, 282, 116, 23);
		contentPane.add(deleteButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("귓속말");
		rdbtnNewRadioButton.setBackground(new Color(230, 230, 250));
		rdbtnNewRadioButton.setBounds(374, 240, 116, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		cardLayout.show(tab, "login");
		
		setResizable(false);
		setVisible(true);  // true여야 화면에 보임.
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void add(Container tab2) {
		// TODO Auto-generated method stub
		
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	private void setBounds(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}

	private void setContentPane(JPanel contentPane2) {
		// TODO Auto-generated method stub
		
	}
}
