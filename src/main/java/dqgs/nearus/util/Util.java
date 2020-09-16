package dqgs.nearus.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Util {

    public static int onlinePlayers() {
        int online = 0;
        for (Player player : getServer().getOnlinePlayers()) {
            online++;
        }
        return online;
    }

    public static String messages(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
