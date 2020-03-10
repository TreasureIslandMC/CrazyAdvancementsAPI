package eu.endercentral.crazyadvancements.implementation.advancement;

import net.minecraft.server.v1_15_R1.AdvancementFrameType;

/**
 * @author sarhatabaot
 */
public enum CrazyAdvancementFrame {
	TASK(AdvancementFrameType.TASK),
	GOAL(AdvancementFrameType.GOAL),
	CHALLENGE(AdvancementFrameType.CHALLENGE)
	;

	private AdvancementFrameType nms;

	CrazyAdvancementFrame(AdvancementFrameType nms) {
		this.nms = nms;
	}

	public AdvancementFrameType getNMS() {
		return nms;
	}
}
