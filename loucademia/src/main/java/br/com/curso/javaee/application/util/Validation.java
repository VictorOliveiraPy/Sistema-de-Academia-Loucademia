package br.com.curso.javaee.application.util;

public class Validation {
	
	
	
	public static void assertNotEmpty(Object obj) {
		if (obj instanceof String) {
			String s = (String) obj;
			if (StringUtils.IsEmpty(s)) {
				throw new ValidationException("O texto não pode ser nulo");
			}
		}
		
		
		if (obj == null) {
			throw new ValidationException("Valor não pode ser nulo");
		}
		
	}

}
