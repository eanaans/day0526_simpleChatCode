package net.hb.day26;

import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class ClientTest extends Frame implements Runnable, ActionListener {
	private Socket sc = null;
	private String host = "203.236.209.122";
	private int port = 8000;
	private String user = "nishio";

	private TextField tf = new TextField(30);
	private TextArea ta = new TextArea();
	private Label info = new Label("input: ");
	private Button btnsend = new Button("send");
	private Button btnend = new Button("quit");
	private Panel pan = new Panel();

	public ClientTest() {
		ta.setFont(new Font("궁서체", Font.BOLD, 26));
		pan.add(info);
		pan.add(tf);
		pan.add(btnsend);
		pan.add(btnend);

		this.add("Center", ta);
		this.add("South", pan);

		tf.addActionListener(this);
		btnsend.addActionListener(this);
		btnend.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(1);
			}
		});

		this.setBounds(300, 200, 500, 650);
		this.setVisible(true);
	} // end

	public void connect() {
		try {
			sc = new Socket(host, port);
			ta.setText("서버접속 성공....");

			Thread tr = new Thread(this);
			tr.start();
		} catch (Exception ex) {
			sc = null;
		}
	} // end

	public void run() {
		String str;
		try {
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((str = br.readLine()) != null) {
				ta.append("\n" + str + "\n");
			}
		} catch (Exception ex) {
			ta.append("서버이상");
			sc = null;
		}
	} // run end=========================================================

	public void actionPerformed(ActionEvent ae) {
		try {
			if (ae.getSource() == tf || ae.getSource() == btnsend) {
				String str = tf.getText();
				OutputStream os = sc.getOutputStream();
				PrintWriter pw = new PrintWriter(os, true);
				pw.println(user + "] " + str);
				ta.append("\n[보냄] " + str);
				tf.setText("");
				tf.requestFocus();
			}

			if (ae.getSource() == btnend) {
				System.exit(1);
			}
		} catch (Exception ex) {
		}
	} // actionPerforemed end==============================================

	public static void main(String[] args) {
		ClientTest ct = new ClientTest();
		ct.connect();
	} // main end

} // class End
