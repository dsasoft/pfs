package br.com.dsasoft.pfs.model;

public enum CenterType {

		INCOME("revenue"),		OUTCOME("cost");
	
		String value;
		
		private CenterType(String value){
			this.value = value;
		}
		
		public String getValue(){
			return value;
		}
}
