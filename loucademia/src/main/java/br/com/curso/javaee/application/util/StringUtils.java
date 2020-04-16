package br.com.curso.javaee.application.util;

public class StringUtils {
	
	public static  boolean IsEmpty(String s) {
		if(s == null) {
			return true;
		}
	return 	s.trim().length() == 0;
	}

			//Metodo para preencher com zeros a esquerda
	public static String leftZeroes(int value, int finalSize) {
			return String.format("%0" + finalSize + "d", value);
	}
	
	
	
		public static void main(String[] args) {
			
			String str = "null";
			
			boolean b = StringUtils.IsEmpty(str);
			System.out.println(b);
			
			int v = 100;
			System.out.println(StringUtils.leftZeroes(v, 8));
		}
}























