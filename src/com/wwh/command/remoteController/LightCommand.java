package com.wwh.command.remoteController;

import com.wwh.command.remoteController.devices.Light;

public class LightCommand implements Command{
	Light light;
	
	public LightCommand(Light light) {
		super();
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}
}
