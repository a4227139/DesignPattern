package com.wwh.command.remoteController;
/*
 * ����ģʽͨ���������װ�ɶ��󣬽���������Ķ���ͽ��ղ�ִ������Ķ�������
 * ���������н����ߣ����ڽ������ϰ�һ���ض��Ķ���
 */
public interface Command {

	public void execute();
	public void undo();
}
