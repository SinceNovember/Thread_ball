package qiuqiu;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class ballListener extends MouseAdapter implements Runnable,KeyListener{
	private ballmain bb;
	private ArrayList<ball> list;
	private volatile boolean pauseFlag=true,stopFlag=true;
	private Random random=new Random();
	public ballListener(ballmain bb,ArrayList<ball> list ){
		this.bb=bb;
		this.list=list;
	}
	public void mouseClicked(MouseEvent e){
		int x=e.getX();
		int y=e.getY();
		ball b=new ball(x, y,10,10, new Color(random.nextInt(225),random.nextInt(225),random.nextInt(225)), 25);
		list.add(b);
		System.out.println("size"+list.size());
	}
	public void run(){
		while(stopFlag)
		{
			if(pauseFlag)
			{
				bb.repaint();
				try
				{
					Thread.sleep(80);
				}catch(InterruptedException e1){
					e1.printStackTrace();
				}
			}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
