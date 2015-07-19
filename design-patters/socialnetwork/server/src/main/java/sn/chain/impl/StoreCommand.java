package sn.chain.impl;

public class StoreCommand extends Chain {

	public StoreCommand() {
		super(IDchain.storeCommand);
	}

	@Override
	protected void efetuarCheck(String path) {
		
		System.out.println("Mapped command: " + path);
		
	}

}
