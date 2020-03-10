package eu.endercentral.crazyadvancements.implementation.advancement;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.endercentral.crazyadvancements.api.network.AdvancementPacketReceiver;
import eu.endercentral.crazyadvancements.api.network.PacketReceivingHandler;
import eu.endercentral.crazyadvancements.implementation.CrazyAdvancements;
import eu.endercentral.crazyadvancements.implementation.NameKey;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import eu.endercentral.crazyadvancements.api.events.AdvancementScreenCloseEvent;
import eu.endercentral.crazyadvancements.api.events.AdvancementTabChangeEvent;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageToMessageDecoder;
import net.minecraft.server.v1_15_R1.NetworkManager;
import net.minecraft.server.v1_15_R1.Packet;
import net.minecraft.server.v1_15_R1.PacketPlayInAdvancements;
import net.minecraft.server.v1_15_R1.PacketPlayInAdvancements.Status;

public class CrazyAdvancementPacketReceiver implements AdvancementPacketReceiver {
	
	private static HashMap<String, ChannelHandler> handlers = new HashMap<>();
	private static Field channelField;
	
	{
		for(Field f : NetworkManager.class.getDeclaredFields()) {
			if(f.getType().isAssignableFrom(Channel.class)) {
				channelField = f;
				channelField.setAccessible(true);
				break;
			}
		}
	}

	@Override
	public ChannelHandler listen(final Player p, final PacketReceivingHandler handler) {
		Channel ch = getNettyChannel(p);
		ChannelPipeline pipe = ch.pipeline();
		
		ChannelHandler handle = new MessageToMessageDecoder<Packet>() {
			@Override
			protected void decode(ChannelHandlerContext chc, Packet packet, List<Object> out) throws Exception {
				
				if(packet instanceof PacketPlayInAdvancements) {
					if(!handler.handle(p, (PacketPlayInAdvancements) packet)) {
						out.add(packet);
					}
					return;
				}
				
				out.add(packet);
			}
		};
		pipe.addAfter("decoder", "endercentral_crazy_advancements_listener_" + hashCode(), handle);
		
		
		return handle;
	}
	@Override
	public Channel getNettyChannel(Player p) {
	    NetworkManager manager = ((CraftPlayer)p).getHandle().playerConnection.networkManager;
	    Channel channel = null;
	    try {
	        channel = (Channel) channelField.get(manager);
	    } catch (IllegalArgumentException | IllegalAccessException e) {
	        e.printStackTrace();
	    }
	    return channel;
	}

	@Override
	public boolean close(Player p, ChannelHandler handler) {
	    try {
	        ChannelPipeline pipe = getNettyChannel(p).pipeline();
	        pipe.remove(handler);
	        return true;
	    } catch(Exception e) {
	        return false;
	    }
	}

	@Override
	public Map<String, ChannelHandler> getHandlers() {
		return handlers;
	}

	@Override
	public void initPlayer(Player p) {
		handlers.put(p.getName(), listen(p, (p1, packet) -> {

			if(packet.c() == Status.OPENED_TAB) {
				NameKey name = new NameKey(packet.d());
				AdvancementTabChangeEvent event = new AdvancementTabChangeEvent(p1, name);
				Bukkit.getPluginManager().callEvent(event);

				if(event.isCancelled()) {
					CrazyAdvancements.clearActiveTab(p1);
					return false;
				} else {
					if(!event.getTabAdvancement().equals(name)) {
						CrazyAdvancements.setActiveTab(p1, event.getTabAdvancement());
					} else {
						CrazyAdvancements.setActiveTab(p1, name, false);
					}
				}
			} else {
				AdvancementScreenCloseEvent event = new AdvancementScreenCloseEvent(p1);
				Bukkit.getPluginManager().callEvent(event);
			}


			return true;
		}));
	}
	
}