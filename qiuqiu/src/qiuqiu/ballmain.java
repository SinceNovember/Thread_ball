package qiuqiu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JFrame;

public class ballmain extends JFrame{
	private Image image;
	private Graphics2D graphics2d;
	private ArrayList<ball> list;
	public static void main(String[] args) {
		ballmain b=new ballmain();
		b.InitUI();
	}
	public void InitUI(){
		list=new ArrayList<ball>();
		this.setTitle("Ball Ball Ball~~~");
		this.setDefaultCloseOperation(3);
		this.setSize(500, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		ballListener b1=new ballListener(this,list);
		this.addMouseListener(b1);
		this.addKeyListener(b1);
		b1.run();
		Thread thread=new Thread(b1);
		thread.start();
	}
	public void paint(Graphics g){
		image=this.createImage(this.getWidth(), this.getHeight());
		graphics2d=(Graphics2D) image.getGraphics();
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		for(int i=0;i<list.size();i++){
			ball b=(ball)list.get(i);
			b.move();
			b.drawball(graphics2d);
			b.collision(g, this, list);
		}
		g.drawImage(image, 0, 0, this);
	}

}
