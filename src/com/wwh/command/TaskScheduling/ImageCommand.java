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
	       int widthOne = ImageOne.getWidth();//图片宽度
	       int heightOne = ImageOne.getHeight();//图片高度
	       //从图片中读取RGB
	       int[] ImageArrayOne = new int[widthOne*heightOne];
	       ImageArrayOne = ImageOne.getRGB(0,0,widthOne,heightOne,ImageArrayOne,0,widthOne);
	       //对第二张图片做相同的处理
	       File fileTwo = new File(imagePath2);
	       BufferedImage ImageTwo = ImageIO.read(fileTwo);
	       int widthTwo = ImageTwo.getWidth();//图片宽度
	       int heightTwo = ImageTwo.getHeight();//图片高度
	       int[] ImageArrayTwo = new int[widthTwo*heightTwo];
	       ImageArrayTwo = ImageTwo.getRGB(0,0,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);
	       //生成新图片
	       BufferedImage ImageNew = new BufferedImage(widthOne+widthTwo,heightOne,BufferedImage.TYPE_INT_RGB);
	       ImageNew.setRGB(0,0,widthOne,heightOne,ImageArrayOne,0,widthOne);//设置左半部分的RGB
	       ImageNew.setRGB(widthOne,0,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);//设置右半部分的RGB
	       File outFile = new File(imagePath3);
	       ImageIO.write(ImageNew, "jpg", outFile);//写图片
	     }
	     catch(Exception e)
	     {
	       e.printStackTrace();
	     }
	}

}
