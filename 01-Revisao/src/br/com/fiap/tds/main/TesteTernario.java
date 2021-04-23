package br.com.fiap.tds.main;

public class TesteTernario {
	
	public static void main(String[] args) {
		
		
		int x = 10;
		
		if(x > 10)
			System.out.println("maior q 10");
		else
			System.out.println("menor q 10");
	
		//Ternário
		System.out.println(x>10?"maior q 10":"menor ou igual a 10");
	
	
	
	}

}
