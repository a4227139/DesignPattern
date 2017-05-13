package com.wwh.command.remoteController;

import com.wwh.command.remoteController.devices.DVD;
/*
 * ���������н�����
 */
public class DVDCommand implements Command {

	DVD dvd;
	
	public DVDCommand(DVD dvd) {
		super();
		this.dvd = dvd;
	}

	@Override
	public void execute() {
		dvd.on();
		dvd.setDish("Beethoven");
		dvd.setVolume(10);
	}

	@Override
	public void undo() {
		dvd.off();
	}

}
