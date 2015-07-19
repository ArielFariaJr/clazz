package sn.chain.impl;

import java.util.List;

import xingu.lang.SorryException;

public class AvailableCommand extends Chain{

	private List<String> listOfCommands;
	public  boolean      ok = false;
	
	public AvailableCommand() {
		super(IDchain.availableCommand);
	
	}

	@Override
	protected void efetuarCheck(String path) {

		Commands command = new Commands();
		
		listOfCommands = command.getCommands();
		
		for(String item: listOfCommands){
			
			if(path.equals(item)){
				ok = true;
			}
			
		}
		
		if(!ok){
			throw new SorryException("Sorry, this command is not available to be executed yet :(");
		}
	
	}

}
