package sn.chain.impl;

import java.util.List;

import xingu.lang.SorryException;

public class InjectCheck extends Chain {

	private List<String> listOfInjectCommands;
	public boolean ok = false;

	public InjectCheck() {
		super(IDchain.injectCheck);
	}

	@Override
	protected void efetuarCheck(String url) {

		cleanSpecialCaracter(url);
		cleanMaliciousWords(url);

	}

	private String cleanSpecialCaracter(String url) {

		url.replace("'", "\"");

		return url;
	}

	private void cleanMaliciousWords(String url) {

		InjectCommands inj = new InjectCommands();

		listOfInjectCommands = inj.getCommands();

		for (String item : listOfInjectCommands) {

			if (url.toLowerCase().contains(item)) {
				ok = true;
			}
		}

		if (ok) {
			throw new SorryException("Sorry, but a malicious command was detected, are you a hacker?");
		}
	}

}
