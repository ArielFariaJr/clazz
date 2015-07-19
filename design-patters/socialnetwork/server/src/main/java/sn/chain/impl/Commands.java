package sn.chain.impl;

import java.util.ArrayList;
import java.util.List;

public class Commands {
	
	private List<String> commands = new ArrayList<>();
	
	public Commands(){
		
		commands.add("/api");
		commands.add("/");
		commands.add("/auth");
		commands.add("/api/auth");
		commands.add("/validate");
	}

	public List<String> getCommands() {
		return commands;
	}

}
