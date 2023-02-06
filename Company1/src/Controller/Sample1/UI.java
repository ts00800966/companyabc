package Controller.Sample1;

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
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;
	private JTextField EditName;
	private JTextField DelID;
	private JTextField EditAddress;
	private JTextField EditID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 257, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名:");
		lblNewLabel.setBounds(20, 42, 46, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setBounds(20, 81, 46, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼:");
		lblNewLabel_1_1.setBounds(20, 119, 46, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("地址:");
		lblNewLabel_1_2.setBounds(20, 157, 46, 15);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("手機:");
		lblNewLabel_1_2_1.setBounds(20, 196, 46, 15);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("電話:");
		lblNewLabel_1_2_1_1.setBounds(20, 232, 46, 15);
		panel.add(lblNewLabel_1_2_1_1);
		
		name = new JTextField();
		name.setBounds(61, 39, 186, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(61, 78, 186, 21);
		panel.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(61, 116, 186, 21);
		panel.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(61, 154, 186, 21);
		panel.add(address);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(61, 193, 186, 21);
		panel.add(mobile);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(61, 229, 186, 21);
		panel.add(phone);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("會員資料管理");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_3.setBounds(69, 7, 115, 22);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(277, 10, 382, 443);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea ShowTxt = new JTextArea();
		ShowTxt.setBounds(10, 134, 362, 280);
		panel_1.add(ShowTxt);
		
		
		
		
		
		EditName = new JTextField();
		EditName.setColumns(10);
		EditName.setBounds(140, 44, 63, 21);
		panel_1.add(EditName);
		
		JLabel lblNewLabel_2 = new JLabel("姓名:");
		lblNewLabel_2.setBounds(111, 47, 46, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("地址:");
		lblNewLabel_1_2_1_2.setBounds(206, 47, 46, 15);
		panel_1.add(lblNewLabel_1_2_1_2);
		
		DelID = new JTextField();
		DelID.setColumns(10);
		DelID.setBounds(140, 77, 63, 21);
		panel_1.add(DelID);
		
		JLabel lblNewLabel_1_3 = new JLabel("ID:");
		lblNewLabel_1_3.setBounds(117, 80, 36, 15);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel LabSize = new JLabel("");
		LabSize.setBounds(10, 424, 118, 15);
		panel_1.add(LabSize);

		
		
		
		JButton newBut = new JButton("新增");
		newBut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.UI接收 getText
				 * 2.new member()
				 * 3.add(m)
				 */
				String Name=name.getText();
				String UserName=username.getText();
				String PassWord=password.getText();
				String Address=address.getText();
				String Mobile=mobile.getText();
				String Phone=phone.getText();
				
				member m= new member(Name,UserName,PassWord,Address,Mobile,Phone);
				
				new implMember().add(m);
				
				List<member> list=new implMember().queryAll2();
				ShowTxt.setText(new implMember().queryAll1());
				LabSize.setText("共"+list.size()+"筆");
				
			}
		});
		newBut.setBounds(81, 292, 87, 23);
		panel.add(newBut);
		
		JButton SelectBut = new JButton("查詢(全部)");
		SelectBut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.show.setText-->queryAll1():String
				 */
				List<member> list=new implMember().queryAll2();
				ShowTxt.setText(new implMember().queryAll1());
				LabSize.setText("共"+list.size()+"筆");
			}
		});
		SelectBut.setBounds(10, 10, 97, 23);
		panel_1.add(SelectBut);
		
		EditAddress = new JTextField();
		EditAddress.setColumns(10);
		EditAddress.setBounds(237, 44, 63, 21);
		panel_1.add(EditAddress);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("ID:");
		lblNewLabel_1_3_1.setBounds(306, 47, 36, 15);
		panel_1.add(lblNewLabel_1_3_1);
		
		EditID = new JTextField();
		EditID.setColumns(10);
		EditID.setBounds(324, 44, 36, 21);
		panel_1.add(EditID);
		
		JButton UpdateBut = new JButton("修改");
		UpdateBut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.nameUpdate,addressUpdate ,updateId-->getText
				 * 2.updateId-->轉成int--->queryId(id)-->member m
				 * 3.m.setName(),m.setAddress()
				 * 4.update(m)
				 */
				String Nname =EditName.getText();
				String Addres = EditAddress.getText();
				int ID =Integer.parseInt(EditID.getText());
				
				member m=new implMember().queryId(ID);
				m.setName(Nname);
				m.setAddress(Addres);
				new implMember().update(m); 
				
				List<member> list=new implMember().queryAll2();
				ShowTxt.setText(new implMember().queryAll1());
				LabSize.setText("共"+list.size()+"筆");
			}
		});
		UpdateBut.setBounds(10, 43, 97, 23);
		panel_1.add(UpdateBut);
		
		JButton DelBut = new JButton("刪除");
		DelBut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID =Integer.parseInt(DelID.getText());
				new implMember().delete(ID);;
				
				List<member> list=new implMember().queryAll2();
				ShowTxt.setText(new implMember().queryAll1());
				LabSize.setText("共"+list.size()+"筆");
			}
		});
		DelBut.setBounds(10, 76, 97, 23);
		panel_1.add(DelBut);
		
		
	}
}
