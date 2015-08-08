package br.com.dsasoft.pfs.model;

public interface AccessObject {

	public String getIdentifier();

	public String getKeyPass();

	public String getRecoverKeyPassEmail();

	// --

	public void getIdentifier(String identifier);

	public void getKeyPass(String keyPass);

	public void getRecoverKeyPassEmail(String recoverKeyPassEmail);

}
