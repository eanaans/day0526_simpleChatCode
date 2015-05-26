package net.hb.day26;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Note extends Frame implements Runnable, ActionListener, WindowListener {

	private Button btnsend = new Button(" 전 송 ");
	private Button btnexit = new Button(" 종 료 ");
	private TextField tf = new TextField(20);
	private TextArea ta = new TextArea();
	private Panel pan  = new Panel();;
	private Label info = new Label("입력: ");
	private Font font = new Font("궁서체", Font.BOLD, 32);

	public Note() {
		// step1 판넬에 info, tf, btnsend, btnexit붙이기
		pan.add(this.info);
		pan.add(tf);
		pan.add(btnsend);
		pan.add(btnexit);
		
		// step2 ta를 중앙에 붙이기
		ta.setFont(font);
		this.add("Center", ta);
		this.add("South", pan);
		
		// step3 add() 매소드로 화면만들기
		this.setTitle("make chat room");
		this.setBackground(Color.green);
		this.setBounds(200, 200, 400, 500);
		this.setVisible(true);
		
		// step4 이벤트 액션처리하도록 컴포넌트에 add~Listener
		addWindowListener(this);
		btnsend.addActionListener(this);
		tf.addActionListener(this);
		this.btnexit.addActionListener(this);
		this.addWindowListener(this);
	}// end note constructor

	public static void main(String[] args) {
		Note pad = new Note();
	}// end main

	@Override
	public void run() {

	}

	@Override
	public void actionPerformed(ActionEvent e) { // 버튼 메뉴 입력란
		if (e.getSource() == btnsend) {
			message();
		}else if (e.getSource() == btnexit) {
			exit();
		}else if (e.getSource() == tf) {
			message();
		}else{

		}
	}// end actionPerformed (e)

	public void message(){
		String data= tf.getText();
		ta.append(data+"\n");
		tf.setText(""); // clear text field
		tf.requestFocus(); // forcus in text field
	}// end message
	
	public void exit(){
		System.out.println("quit button");
		System.exit(1);
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		exit();
	}// end windowClosing

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

}// end class
