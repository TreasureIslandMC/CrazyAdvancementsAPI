package eu.endercentral.crazyadvancements.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import eu.endercentral.crazyadvancements.implementation.advancement.CrazyAdvancement;
import eu.endercentral.crazyadvancements.implementation.manager.CrazyAdvancementManager;

public class CriteriaRevokeEvent extends Event {
	
	public static final HandlerList handlers = new HandlerList();
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	
	private final CrazyAdvancementManager manager;
	private final CrazyAdvancement advancement;
	private final String[] criteria;
	private final Player player;
	
	public CriteriaRevokeEvent(CrazyAdvancementManager manager, CrazyAdvancement advancement, String[] criteria, Player player) {
		this.manager = manager;
		this.advancement = advancement;
		this.criteria = criteria;
		this.player = player;
	}
	
	/**
	 * 
	 * @return The Manager this event has been fired from
	 */
	public CrazyAdvancementManager getManager() {
		return manager;
	}
	
	/**
	 * 
	 * @return Advancement
	 */
	public CrazyAdvancement getAdvancement() {
		return advancement;
	}
	
	/**
	 * 
	 * @return Revoked Criteria
	 */
	public String[] getCriteria() {
		return criteria;
	}
	
	/**
	 * 
	 * @return Reciever
	 */
	public Player getPlayer() {
		return player;
	}
	
	
	
}