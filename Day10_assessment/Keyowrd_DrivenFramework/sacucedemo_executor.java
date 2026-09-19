package Keyowrd_DrivenFramework;

public class sacucedemo_executor {

	saucedemo_implementation k = new saucedemo_implementation();
	
	public void executor(String keyword)
	{
		if(keyword.equals("LAUNCH_BROWSER"))
			k.launch();
		else if(keyword.equals("OPEN_URL"))
			k.url();
		else if(keyword.equals("USERNAME_TEXT"))
			k.username_tf();
		else if(keyword.equals("PASSWORD_TEXT"))
			k.password_tf();
		else if(keyword.equals("LOGIN"))
			k.login_btn();
		else if(keyword.equals("CLOSE_BROWSER"))
			k.close();
	}
}