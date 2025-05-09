

import javax.swing.*;
import java.awt.*;

public class Frame_Base extends JFrame {
	private static Frame_Base instance;

	public Frame_Base(JPanel e) {
				//시스템 정보(화면 크기를 얻기 위한 Toolkit)
				Toolkit tk = Toolkit.getDefaultToolkit();//해상도

				//기본 JFrame 구조
				setTitle("맛집이(맛집 추천 프로그램)");
				setLayout(null);
				setBounds(((int) tk.getScreenSize().getWidth() / 3), 
						((int) tk.getScreenSize().getHeight()) / 2 - 400,
						415, 738);
				add(e);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
		//TODO Auto-generated constructor stub
	}
	public static void getInstance(JPanel e) {
		//static으로 선언했으므로 해당 메서드가 생성자보다도 먼저 호출된다
	instance = new Frame_Base(e);//생성자를 통해 기본 프레임 정의
	
	instance.getContentPane().removeAll();
	instance.getContentPane().add(e);
	
	instance.revalidate(); //레이아웃 관리자에게 레이아웃정보를 다시 계산하도록 지시
	instance.repaint(); //레이아웃을 새로 그린다
}//getInstance()
	//getInstance()
	public void dispose() {
		super.dispose();
	}
	
	public static void getDispose() {
		instance.dispose();
	}

	public static void getInstance(Frame_Login frame_Login) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getInstance'");
	}
	

}

