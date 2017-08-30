package qiuqiu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class ball {
	private int x,y,movex,movey;
	private Color color;
	private int size;
	public ball(int x, int y, int movex, int movey, Color color, int size) {
		super();
		this.x = x;
		this.y = y;
		this.movex = movex;
		this.movey = movey;
		this.color = color;
		this.size = size;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getMovex() {
		return movex;
	}
	public void setMovex(int movex) {
		this.movex = movex;
	}
	public int getMovey() {
		return movey;
	}
	public void setMovey(int movey) {
		this.movey = movey;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void move(){
		x+=movex;
		y+=movey;
	}
	public void drawball(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, size, size);
	}
	public void collision(Graphics g ,ballmain bb,ArrayList<ball> list){
		if(x+size>=bb.getWidth()||x<=0){
			movex=-movex;
		}
		if(y+size>=bb.getHeight()||y<=25){
			movey=-movey;
		}
		for(int i=0;i<list.size();i++){
			ball b=(ball)list.get(i);
			if(b!=this){
				int xx=Math.abs(this.x-b.x);
				int yy=Math.abs(this.y-b.y);
				int xy=(int)Math.sqrt(xx*xx+yy*yy);
				int tempx=0;
				int tempy=0;
				if(xy<=(this.size/2+b.size/2)){
					tempx=this.movex;
					tempy=this.movey;
					this.movex=b.movex;
					this.movey=b.movey;
					b.movex=tempx;
					b.movey=tempy;
				}
				
			}
		}
	}
	

}
