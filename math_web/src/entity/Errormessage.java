package entity;

import java.io.Serializable;

public class Errormessage implements Serializable{
 private String errormessage;
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
