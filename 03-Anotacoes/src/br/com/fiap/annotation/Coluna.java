package br.com.fiap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Definir o lugar que a anotação pode ser utilizada
//FIELD -> ATRIBUTOS
@Target(ElementType.FIELD)

//@Target( { ElementType.FIELD, ElementType.METHOD } )

//Definir até quando a anotação estará presente
//SOURCE -> Até o codigo (.java)
//CLASS -> até o bytecode (.class) default
//RUNTIME -> até a execução

@Retention(RetentionPolicy.RUNTIME)
public @interface Coluna {

	String nome();
	String tipo();
	boolean pk() default false;
	int tamanho() default 255;
	
	
	
}

