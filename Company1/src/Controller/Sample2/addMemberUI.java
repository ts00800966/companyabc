package Controller.Sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addMemberUI extends JFrame {

	private JPanel contentPane;
	private JTextField NameTxt;
	private JTextField UsernameTxt;
	private JTextField PasswordTxt;
	private JTextField AddressTxt;
	private JTextField MobileTxt;
	private JTextField PhoneTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMemberUI frame = new addMemberUI();
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
	public addMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 414, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名:");
		lblNewLabel.setBounds(63, 39, 46, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setBounds(63, 64, 46, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼:");
		lblNewLabel_2.setBounds(63, 89, 46, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址:");
		lblNewLabel_3.setBounds(63, 114, 46, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("手機:");
		lblNewLabel_4.setBounds(63, 139, 46, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("電話:");
		lblNewLabel_5.setBounds(63, 164, 46, 15);
		panel.add(lblNewLabel_5);
		
		NameTxt = new JTextField();
		NameTxt.setBounds(96, 36, 96, 21);
		panel.add(NameTxt);
		NameTxt.setColumns(10);
		
		UsernameTxt = new JTextField();
		UsernameTxt.setColumns(10);
		UsernameTxt.setBounds(96, 61, 96, 21);
		panel.add(UsernameTxt);
		
		PasswordTxt = new JTextField();
		PasswordTxt.setColumns(10);
		PasswordTxt.setBounds(96, 86, 96, 21);
		panel.add(PasswordTxt);
		
		AddressTxt = new JTextField();
		AddressTxt.setColumns(10);
		AddressTxt.setBounds(96, 111, 96, 21);
		panel.add(AddressTxt);
		
		MobileTxt = new JTextField();
		MobileTxt.setColumns(10);
		MobileTxt.setBounds(96, 136, 96, 21);
		panel.add(MobileTxt);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setColumns(10);
		PhoneTxt.setBounds(96, 161, 96, 21);
		panel.add(PhoneTxt);
		
		JButton CeckBut = new JButton("確定");
		CeckBut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.username-->getText
				 * 2.帳號判斷-->queryusername():boolean
				 * 3.true-->重複-->addError
				 * 4.false-->接收所有資料-->new member-->add()-->addSuccess
				 */
				String name= NameTxt.getText();
				String username=UsernameTxt.getText();
				String password=PasswordTxt.getText();
				String address=AddressTxt.getText();
				String mobile=MobileTxt.getText();
				String phone=PhoneTxt.getText();
				if(new implMember().queryUser(username))
				{
					addError a=new addError();
					a.show();
					dispose();
				}
				else
				{
					member m =new member(name,username,password,address,mobile,phone);
					new implMember().add(m);
					addSuccessUI l=new addSuccessUI();
					l.show();
					dispose();
				}
				
			}
		});
		CeckBut.setBounds(76, 208, 87, 23);
		panel.add(CeckBut);
	}

}
