package br.com.fiap.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Definir o lugar que a anota��o pode ser utilizada
//FIELD -> ATRIBUTOS
@Target(ElementType.FIELD)

//@Target( { ElementType.FIELD, ElementType.METHOD } )

//Definir at� quando a anota��o estar� presente
//SOURCE -> At� o codigo (.java)
//CLASS -> at� o bytecode (.class) default
//RUNTIME -> at� a execu��o

@Retention(RetentionPolicy.RUNTIME)
public @interface Coluna {

	String nome();
	String tipo();
	boolean pk() default false;
	int tamanho() default 255;
	
	
	
}

