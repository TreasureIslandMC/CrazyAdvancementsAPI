package eu.endercentral.crazyadvancements.api.network;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import org.bukkit.entity.Player;

import java.util.Map;

public interface AdvancementPacketReceiver {
	ChannelHandler listen(final Player p, final PacketReceivingHandler handler);

	Channel getNettyChannel(Player p);

	boolean close(Player p, ChannelHandler handler);

	Map<String, ChannelHandler> getHandlers();

	void initPlayer(Player p);
}
