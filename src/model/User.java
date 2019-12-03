package model;

import java.io.Serializable;

public class User implements Serializable{
		
		private static final long serialVersionUID = 1L;	

		private String username;
		private String password;

		public User() {
			
		}
		
		public User(String _username, String _password) {
			super();
			this.username = _username;
			this.password = _password;
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
}