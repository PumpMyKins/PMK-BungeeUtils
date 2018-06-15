package fr.pmk_bungeeutils.security.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class LinkCommand extends Command {

	public LinkCommand(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		// TODO Auto-generated method stub

		System.out.println(args[0]);
		System.out.println(args[1]);
		
		if(args.length == 1) {
			
			
			
		}else {
			return;
		}
		
	}

}
