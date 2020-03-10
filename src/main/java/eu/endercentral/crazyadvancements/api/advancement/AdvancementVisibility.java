package eu.endercentral.crazyadvancements.api.advancement;

import java.util.Arrays;

import eu.endercentral.crazyadvancements.implementation.advancement.CrazyAdvancement;
import org.bukkit.entity.Player;

public abstract class AdvancementVisibility {

	public static final AdvancementVisibility ALWAYS = new AdvancementVisibility("ALWAYS") {

		@Override
		public boolean isVisible(Player player, CrazyAdvancement advancement) {
			return true;
		}
	};

	public static final AdvancementVisibility PARENT_GRANTED = new AdvancementVisibility("PARENT_GRANTED") {

		@Override
		public boolean isVisible(Player player, CrazyAdvancement advancement) {
			if (advancement.isGranted(player)) return true;
			CrazyAdvancement parent = advancement.getParent();

			return parent == null || parent.isGranted(player);
		}
	};
	public static final AdvancementVisibility VANILLA = new AdvancementVisibility("VANILLA") {

		@Override
		public boolean isVisible(Player player, CrazyAdvancement advancement) {
			if (advancement.isGranted(player)) return true;

			CrazyAdvancement parent = advancement.getParent();

			if (parent != null && !parent.isGranted(player)) {
				CrazyAdvancement grandParent = parent.getParent();

				return grandParent == null || grandParent.getParent() == null || grandParent.isGranted(player);
			}

			return true;
		}
	};

	public static final AdvancementVisibility HIDDEN = new AdvancementVisibility("HIDDEN") {

		@Override
		public boolean isVisible(Player player, CrazyAdvancement advancement) {
			return advancement.isGranted(player);
		}
	};

	private final String name;

	public AdvancementVisibility() {
		name = "CUSTOM";
	}

	private AdvancementVisibility(String name) {
		this.name = name;
	}

	/**
	 * @param player      Player to check
	 * @param advancement Advancement to check
	 * @return true if advancement should be visible
	 */
	public abstract boolean isVisible(Player player, CrazyAdvancement advancement);

	/**
	 * @return true if advancement should always be visible if any child should be visible, defaults to true
	 */
	public boolean isAlwaysVisibleWhenAdvancementAfterIsVisible() {
		return true;
	}

	/**
	 * @return Custom Name, only for pre-defined visibilities: {@link #ALWAYS}, {@link #PARENT_GRANTED}, {@link #VANILLA}, {@link #HIDDEN}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Parses a visibility
	 *
	 * @param name Visibility Name
	 * @return A visibility with a matching {@link #getName()} or {@link #VANILLA}
	 */
	public static AdvancementVisibility parseVisibility(String name) {
		for (AdvancementVisibility visibility : Arrays.asList(ALWAYS, PARENT_GRANTED, VANILLA, HIDDEN)) {
			if (visibility.getName().equalsIgnoreCase(name)) {
				return visibility;
			}
		}
		return VANILLA;
	}

}