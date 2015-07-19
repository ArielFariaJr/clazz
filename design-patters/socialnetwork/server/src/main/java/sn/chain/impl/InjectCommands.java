package sn.chain.impl;

import java.util.ArrayList;
import java.util.List;

public class InjectCommands {

	private List<String> commands = new ArrayList<>();
	
	public InjectCommands(){
		
		commands.add("select");
		commands.add("drop");
		commands.add("insert");
		commands.add("delete");
		commands.add(";");
		commands.add("--");
		commands.add("xp_");
	}

	public List<String> getCommands() {
		return commands;
	}

}
