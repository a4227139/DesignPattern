package com.wwh.command.remoteController;

import com.wwh.command.remoteController.devices.DVD;
import com.wwh.command.remoteController.devices.Light;
/*
 * ������ģ��һ��ң������ң��������8����ť������7�������ť��1���ǳ�����ť��ң��������ͨ������ť���������豸��Ҳ������ʱ������һ��������
 * ͨ���������ң�����͸����豸�ǽ���ϵġ�
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
