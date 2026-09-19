package keyword_Driven_FrameWork;

import Keyowrd_DrivenFramework.sacucedemo_executor;

public class saucedemo_main_program {

	public static void main(String[] args) {
		
		sacucedemo_executor e = new sacucedemo_executor();
		
		e.executor("LAUNCH_BROWSER");
		e.executor("OPEN_URL");
		e.executor("USERNAME_TEXT");
		e.executor("PASSWORD_TEXT");
		e.executor("LOGIN");
		e.executor("CLOSE_BROWSER");
	}
}
