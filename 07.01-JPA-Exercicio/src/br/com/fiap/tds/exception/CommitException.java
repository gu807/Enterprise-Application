package br.com.fiap.tds.exception;

public class CommitException extends Exception {

	public CommitException() {
		super("erro no commit");
	}
	
	public CommitException(String msg) {
		super(msg);
	}
	
}
