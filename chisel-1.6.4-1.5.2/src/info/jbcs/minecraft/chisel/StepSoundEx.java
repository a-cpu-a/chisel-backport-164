package info.jbcs.minecraft.chisel;

import net.minecraft.src.StepSound;

public class StepSoundEx extends StepSound {
	String stepName;
	String placeName;
	
	public StepSoundEx(String name,String stepName,String placeName,float volume) {
		super(name, volume, 1.0f);
		
		this.stepName=stepName;
		this.placeName=placeName;
	}

	@Override
	public String getBreakSound() {
		return stepSoundName;
	}

	@Override
	public String getStepSound() {
		return stepName;
	}

	@Override
	public String getPlaceSound() {
		return placeName;
	}

}
