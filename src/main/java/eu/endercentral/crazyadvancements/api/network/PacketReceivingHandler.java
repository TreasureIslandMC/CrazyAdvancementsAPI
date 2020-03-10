package eu.endercentral.crazyadvancements.api.network;

import net.minecraft.server.v1_15_R1.PacketPlayInAdvancements;
import org.bukkit.entity.Player;

public interface PacketReceivingHandler {
	boolean handle(Player p, PacketPlayInAdvancements packet);
}
