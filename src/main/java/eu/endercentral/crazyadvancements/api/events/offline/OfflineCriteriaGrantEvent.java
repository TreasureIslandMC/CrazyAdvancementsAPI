package eu.endercentral.crazyadvancements.api.events.offline;

import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import eu.endercentral.crazyadvancements.implementation.advancement.CrazyAdvancement;
import eu.endercentral.crazyadvancements.implementation.manager.CrazyAdvancementManager;

public class OfflineCriteriaGrantEvent extends Event {
	
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
	private final UUID uuid;
	
	public OfflineCriteriaGrantEvent(CrazyAdvancementManager manager, CrazyAdvancement advancement, String[] criteria, UUID uuid) {
		this.manager = manager;
		this.advancement = advancement;
		this.criteria = criteria;
		this.uuid = uuid;
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
	 * @return Granted Criteria
	 */
	public String[] getCriteria() {
		return criteria;
	}
	
	/**
	 * 
	 * @return Reciever
	 */
	public UUID getUuid() {
		return uuid;
	}
	
	
	
}