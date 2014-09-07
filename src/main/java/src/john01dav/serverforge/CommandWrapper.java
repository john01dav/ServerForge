package src.john01dav.serverforge;
import net.minecraft.command.*;
import src.john01dav.serverforge.api.*;

import java.util.ArrayList;
import java.util.List;

public class CommandWrapper implements ICommand{
    private String name;
    private ServerForgeCommand command;

    public CommandWrapper(String name, ServerForgeCommand command){
        this.name = name;
        this.command = command;
    }

    @Override
    public String getCommandName(){
        return name;
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_){
        return "/" + name;
    }

    @Override
    public List getCommandAliases(){
        return new ArrayList<String>();
    }

    @Override
    public void processCommand(ICommandSender forgeSender, String[] args){
        CommandSender sender = new CommandSender(forgeSender);
        command.onCommand(sender, args);
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
