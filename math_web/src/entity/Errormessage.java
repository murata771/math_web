package entity;

import java.io.Serializable;

public class Errormessage implements Serializable{
 private String errormessage;
 private int errorflag;
 public int getErrorflag() {
	return errorflag;
}

public void setErrorflag(int errorflag) {
	this.errorflag = errorflag;
}

public Errormessage() {}

public Errormessage(String errormessage) {
	super();
	this.errormessage = errormessage;
}

public String getErrormessage() {
	return errormessage;
}

public void setErrormessage(String errormessage) {
	this.errormessage = errormessage;
}
 
 
}
