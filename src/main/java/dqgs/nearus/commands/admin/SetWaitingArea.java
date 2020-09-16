package dqgs.nearus.commands.admin;

import dqgs.nearus.util.WaitingArea;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetWaitingArea implements Listener, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (command.getName().equalsIgnoreCase("SetWaitingArea")){
                WaitingArea waitingArea = new WaitingArea();
                Player player = (Player) sender;
                waitingArea.setWaitingArea(player);
                player.sendMessage("§4§lThe waiting area has been set.");
            }
        }
        return false;
    }
}
