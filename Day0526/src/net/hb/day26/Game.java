package net.hb.day26;

import java.awt.Frame;
import java.util.Scanner;

public class Game extends Frame implements Runnable{
	public static void main(String[] args) {

		Game gm = new Game();
		Thread tr = new Thread(gm);
		//무한루프 처리  run함수는 start()에소드로 호출
		tr.start();
		
		int dan =3;
		Scanner stdin = new Scanner(System.in);
		System.out.print("\n input 구구단 입력?");
		dan = stdin.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + "*"+ i + "="+ (dan *i));
		}
		gm.jumsu();//
		System.out.print("\n =========== last line 영수증 출력================= ");
	}// main end

	public void run() {
		int su = 0;
		while (true) {
			try {
				su++;
				System.out.print(su + "\t");// 일꾼이 미네랄캐는 작업
				if (su % 5 == 0)
					System.out.println();
				Thread.sleep(200);
			} catch (Exception ex) {
			}
		}// while end
	}// end run

	public void jumsu() {
		System.out.println("\n국어 영어 총점 2초후 출력");
		try {
			Thread.sleep(2000);
		} catch (Exception ex) {
		}// end try
		int kor = 85, eng = 90, sum = 0;
		sum = kor + eng;
		System.out.println("\n국어=" + kor);
		System.out.println("영어=" + eng);
		System.out.println("총점=" + sum);
	}// chongjum

}
