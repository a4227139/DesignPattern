package com.wwh.command.remoteController;

import com.wwh.command.remoteController.devices.DVD;
import com.wwh.command.remoteController.devices.Light;
/*
 * 该例是模拟一个遥控器，遥控器上有8个按钮，其中7个是命令按钮，1个是撤销按钮。遥控器可以通过按按钮操作各个设备，也可以随时撤销上一步操作。
 * 通过命令对象，遥控器和各个设备是解耦合的。
 */
public class Main {

	public static void main(String[] args) {
		RemoteController remoteController=new RemoteController();
		Light roomLight=new Light();
		Light balconyLight=new Light();
		DVD dvd=new DVD();
		remoteController.setCommand(0, new LightCommand(roomLight));
		remoteController.setCommand(1, new LightCommand(balconyLight));
		remoteController.setCommand(2, new DVDCommand(dvd));
		remoteController.onButtonWasPushed(0);
		remoteController.onButtonWasPushed(1);
		remoteController.onButtonWasPushed(2);
		remoteController.undoButtonWasPushed();
		remoteController.undoButtonWasPushed();
		remoteController.undoButtonWasPushed();
		remoteController.undoButtonWasPushed();
		remoteController.onButtonWasPushed(2);
		remoteController.undoButtonWasPushed();
	}
}
