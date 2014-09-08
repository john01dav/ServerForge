package src.john01dav.serverforge.api;
import net.minecraft.command.ICommand;

public class NativeCommandWrapper implements ServerForgeCommand{
    private ICommand command;

    public NativeCommandWrapper(ICommand command){
        this.command = command;
    }

    @Override
    public void onCommand(CommandSender sender, String[] args){
        command.processCommand(sender.forgeSender, args);
    }

    public String getName(){
        return command.getCommandName();
    }

    public String getUsage(CommandSender sender){
        return command.getCommandUsage(sender.forgeSender);
    }

}
