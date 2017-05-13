package com.wwh.command.TaskScheduling;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageCommand implements Command{

	String imagePath1,imagePath2,imagePath3;
	
	public ImageCommand(String imagePath1, String imagePath2, String imagePath3) {
		super();
		this.imagePath1 = imagePath1;
		this.imagePath2 = imagePath2;
		this.imagePath3 = imagePath3;
	}

	@Override
	public void execute() {
		mergePicture(imagePath1,imagePath2,imagePath3);
	}
	
	public void mergePicture(String imagePath1,String imagePath2,String imagePath3){
		try
	     {
	       File fileOne = new File(imagePath1);
	       BufferedImage ImageOne = ImageIO.read(fileOne);
	       int widthOne = ImageOne.getWidth();//ͼƬ���
	       int heightOne = ImageOne.getHeight();//ͼƬ�߶�
	       //��ͼƬ�ж�ȡRGB
	       int[] ImageArrayOne = new int[widthOne*heightOne];
	       ImageArrayOne = ImageOne.getRGB(0,0,widthOne,heightOne,ImageArrayOne,0,widthOne);
	       //�Եڶ���ͼƬ����ͬ�Ĵ���
	       File fileTwo = new File(imagePath2);
	       BufferedImage ImageTwo = ImageIO.read(fileTwo);
	       int widthTwo = ImageTwo.getWidth();//ͼƬ���
	       int heightTwo = ImageTwo.getHeight();//ͼƬ�߶�
	       int[] ImageArrayTwo = new int[widthTwo*heightTwo];
	       ImageArrayTwo = ImageTwo.getRGB(0,0,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);
	       //������ͼƬ
	       BufferedImage ImageNew = new BufferedImage(widthOne+widthTwo,heightOne,BufferedImage.TYPE_INT_RGB);
	       ImageNew.setRGB(0,0,widthOne,heightOne,ImageArrayOne,0,widthOne);//������벿�ֵ�RGB
	       ImageNew.setRGB(widthOne,0,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);//�����Ұ벿�ֵ�RGB
	       File outFile = new File(imagePath3);
	       ImageIO.write(ImageNew, "jpg", outFile);//дͼƬ
	     }
	     catch(Exception e)
	     {
	       e.printStackTrace();
	     }
	}

}
