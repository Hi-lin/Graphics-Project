import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import javax.sound.sampled.*;
import java.awt.Toolkit;
import java.net.*;

public class boblabst
{
	static File file; 
    static AudioInputStream stream; 
    static Clip music; 
	public static void main(String...args) throws Exception
	{
/*		file = new File("song.wav");
		stream = AudioSystem.getAudioInputStream(file);
		music = AudioSystem.getClip();
		music.open(stream);
		music.start(); //Start the music
		music.loop(Clip.LOOP_CONTINUOUSLY);*/
		JFrame j = new JFrame();  //JFrame is the window; window is a depricated class
		MyPanelb m = new MyPanelb();
		j.setSize(m.getSize());
		j.add(m); //adds the panel to the frame so that the picture will be drawn
			      //use setContentPane() sometimes works better then just add b/c of greater efficiency.

		j.setVisible(true); //allows the frame to be shown.



}
}

class MyPanelb extends JPanel implements ActionListener, MouseListener, KeyListener
{
	
	private Timer time;
	private int x,y;
	private int add;
	private int dir = 1;
	private int dir1 = 1;
			int lat = 565;
			int blobx = 1000;
			int bloby=  600;
			int dim = 1;
			int dir2 = 1;
			int pigx = 600;
			boolean beam = false;
			int cook = 0;

	
	MyPanelb()
	{
		time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
		setSize(2000, 1500);
		setVisible(true); //it's like calling the repaint method.
		time.start();
		add=1;
		x = 600;
		y= 600;
		addKeyListener(this);
		setFocusable(true);
		addMouseListener(this);
	
	} 
	
		public void paintComponent(Graphics g)
	{
		if(dim==1){
			drawOver(g,x,y);
		}
		else
		drawBob(g,x,y);
		//End Crystals
		Image crystal;
		try
		{
			crystal = ImageIO.read(new File("crystal.png"));
			g.drawImage(crystal, 480, 300, null);
			g.drawImage(crystal, 880, 350, null);
			g.drawImage(crystal, 1380, 275, null);
		}
		catch(Exception e)	{}
Image opm;
		try
		{
			opm = ImageIO.read(new File("opm.png"));
			g.drawImage(opm, 1135, 395, null);
		}
		catch(Exception e)	{}

	}
	
	public void drawOver(Graphics g, int x,int y){
		//portal
		repaint();
		Color day = new Color(24,24,200);
		g.setColor(day);
		g.fillRect(0,0,2000, 700);
		g.setColor(Color.green);
		g.fillRect(0, 700, 2000, 300);
		g.setColor(Color.yellow);
		g.fillRect(100+x, 100, 100, 100);
		//ufo
		g.setColor(Color.black);
		g.drawOval(y-75,0, 150, 150);
		g.setColor(Color.gray);
		Polygon ufo = new Polygon();
		ufo.addPoint(y+75, 75);
		ufo.addPoint(y-75, 75);
		ufo.addPoint(y-150, 125);
		ufo.addPoint(y-125, 125);
		ufo.addPoint(y-100, 150);
		ufo.addPoint(y+100, 150);
		ufo.addPoint(y+125, 125);
		ufo.addPoint(y+150, 125);
		g.fillPolygon(ufo);
		g.setColor(Color.yellow);
		g.fillOval(100+y, 105, 15, 15);
		g.fillOval(50+y, 105, 15, 15);
		g.fillOval(y, 105, 15, 15);
		g.fillOval(-50+y, 105, 15, 15);
		g.fillOval(-100+y, 105, 15, 15);
		g.setColor(Color.green);
		g.fillRect(y-20, 40, 40, 35);
		g.setColor(Color.black);
		g.drawLine(y-150, 125, y+150, 125);
		g.fillRect(y-15, 45, 10, 10);
		g.fillRect(y+5, 45, 10, 10);
		if(beam) {
			g.setColor(Color.magenta);
			g.fillRect(y-100, 150, 200, 550);
		}

		
		//pig
		Color t1 = new Color(233,116,81);
		Color t2 = new Color(210,43,43);
		Color t3 = new Color(196,30,58);
		if(cook<1000) {
		g.setColor(Color.pink);
		}
		else if(cook<2000) {
			g.setColor(t1);
		}
		else if(cook<3000) {
			g.setColor(t2);
		}
		else {
			g.setColor(t3);
		}
		g.fillRect(pigx-125, 525, 250, 125);
		g.fillRect(pigx-100,600, 25, 100);
		g.fillRect(pigx+75,600, 25, 100);
		Polygon phead = new Polygon();
		phead.addPoint(pigx+100*dir2, 495);
		phead.addPoint(pigx+100*dir2,600);
		phead.addPoint(pigx+175*dir2, 600);
		phead.addPoint(pigx+175*dir2, 590);
		phead.addPoint(pigx+200*dir2, 590);
		phead.addPoint(pigx+200*dir2, 545);
		phead.addPoint(pigx+175*dir2, 545);
		phead.addPoint(pigx+175*dir2, 495);
		g.fillPolygon(phead);
		g.setColor(Color.black);
		Polygon eye = new Polygon();
		eye.addPoint(pigx+140*dir2, 515);
		eye.addPoint(pigx+150*dir2, 515);
		eye.addPoint(pigx+150*dir2, 527);
		eye.addPoint(pigx+140*dir2, 527);
		g.fillPolygon(eye);
		
		
		
		//portal
		Color bedrock = new Color (60, 60, 60);
		g.setColor (bedrock);
		Polygon portal = new Polygon();
		portal.addPoint (750, 660);
		portal.addPoint (890, 660);
		portal.addPoint (870, 700);
		portal.addPoint (770, 700);
		g.fillPolygon (portal);
		bedrock = new Color (30, 30, 30);
		g.setColor (bedrock);
		g.fillRect (800, 580, 40, 80);
		Color particles = new Color (153,50,204);
		g.setColor (particles);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		

	}
	public void drawBob(Graphics g, int x, int y)
	{
		
		
		//Background
		Color bg = new Color(25,0,55);
		g.setColor(bg);
		g.fillRect (0, 0, 2000, 1600);
		
		//Island
		Color endstone = new Color (250,250,210);
		g.setColor(endstone);
		Polygon island = new Polygon();
		island.addPoint (200, 700);
		island.addPoint (1800, 700);
		island.addPoint (1400, 850);
		island.addPoint (1100, 900);
		island.addPoint (800, 850);
		island.addPoint (500, 900);
		g.fillPolygon(island);
		
		//Pillars
		Color obsidian = new Color (12, 4, 16);
		g.setColor(obsidian);
		g.fillRect (500, 400, 80, 300);
		g.fillRect (900, 450, 80, 250);
		g.fillRect (1400, 375, 80, 325);
		
		//Portal
		Color bedrock = new Color (60, 60, 60);
		g.setColor (bedrock);
		Polygon portal = new Polygon();
		portal.addPoint (750, 660);
		portal.addPoint (890, 660);
		portal.addPoint (870, 700);
		portal.addPoint (770, 700);
		g.fillPolygon (portal);
		bedrock = new Color (30, 30, 30);
		g.setColor (bedrock);
		g.fillRect (800, 580, 40, 80);
		Color particles = new Color (153,50,204);
		g.setColor (particles);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		g.fillRect ((int) (Math.random()*140 + 750), (int) (Math.random()*40 + 620), 2, 2);
		
		//Tank
		Color Cfront = new Color(80,100,80);
		g.setColor(Cfront);
		Polygon one = new Polygon();
		one.addPoint(-137*dir1+y, lat+20);
		one.addPoint(-37*dir1+y, lat+20);
		one.addPoint(-37*dir1+y, lat+40);
		one.addPoint(-137*dir1+y, lat+40);
		g.fillPolygon(one);
		Color Cbody = new Color(60,100,20);
		g.setColor(Cbody);
		Polygon two = new Polygon();
		two.addPoint(63*dir1+y, lat+37);
		two.addPoint(88*dir1+y, lat+37);
		two.addPoint(88*dir1+y, lat+75);
		two.addPoint(63*dir1+y, lat+75);
		g.fillPolygon(two);
		Polygon back = new Polygon();
		back.addPoint(63*dir1+y, lat);
		back.addPoint(63*dir1+y, lat + 37);
		back.addPoint(88*dir1+y, lat + 37);
		g.fillPolygon(back);
		Polygon three = new Polygon();
		three.addPoint(-37*dir1 + y,lat);
		three.addPoint(63*dir1 + y,lat);
		three.addPoint(63*dir1 + y,lat+75);
		three.addPoint(-37*dir1 + y,lat+75);
		g.fillPolygon(three);
		Polygon front = new Polygon();
		front.addPoint(-37*dir1+y, lat);
		front.addPoint(-37*dir1+y, lat + 75); 
		front.addPoint(-87*dir1+y, lat +75);
		g.fillPolygon(front);
		g.setColor(Cfront);
		g.fillOval(-(137+(dir1*5))*dir1+y, lat + 15, 10, 30);
		g.setColor(Color.black);
		g.fillRect(-87+y, lat + 75, 175, 60);
		g.fillOval(-112+y, lat + 75, 50, 60);
		g.fillOval(63+y, lat + 75, 50, 60);
		Color tireB = new Color(90,100,90);
		g.setColor(tireB);
		g.fillOval(-2+y, lat + 85, 30, 40);
		g.fillOval(73+y, lat + 85, 30, 40);
		g.fillRect(-87+y, lat + 85, 175, 40);
		g.setColor(Color.black);
		g.fillOval(-100+y, lat + 85, 40, 40);
		g.fillOval(-60+y, lat + 85, 40, 40);
		g.fillOval(-20+y, lat + 85, 40, 40);
		g.fillOval(20+y, lat + 85, 40, 40);
		g.fillOval(60+y, lat + 85, 40, 40);


		//Saitama
		Color cape = new Color (200, 200, 200);
		g.setColor(cape);
		Polygon cap = new Polygon();
		cap.addPoint(1160, 480);
		cap.addPoint(1220, 480);
		cap.addPoint(1270, 680);
		cap.addPoint(1110, 680);
		g.fillPolygon(cap);
		Color suit = new Color(249,224,117);
		g.setColor(suit);
		Polygon arm1 = new Polygon();
		arm1.addPoint(1220+(int)(15*Math.cos(x/5)), 480+(int)(15*Math.sin(x/5)));
		arm1.addPoint(1220-(int)(15*Math.cos(x/5)), 480-(int)(15*Math.sin(x/5)));
		arm1.addPoint(1220-(int)(15*Math.cos(x/5))+(int)(90*Math.cos(x/5+Math.PI/2)), 480-(int)(15*Math.sin(x/5))+(int)(90*Math.sin(x/5+Math.PI/2)));
		arm1.addPoint(1220+(int)(15*Math.cos(x/5))+(int)(90*Math.cos(x/5+Math.PI/2)), 480+(int)(15*Math.sin(x/5))+(int)(90*Math.sin(x/5+Math.PI/2)));
		g.fillPolygon(arm1);
		Polygon bod = new Polygon();
		bod.addPoint (1160, 480);
		bod.addPoint (1220, 480);
		bod.addPoint (1220, 580);
		bod.addPoint (1230, 670);
		bod.addPoint (1200, 670);
		bod.addPoint (1190, 580);
		bod.addPoint (1180, 670);
		bod.addPoint (1150, 670);
		bod.addPoint (1160, 580);
		bod.addPoint (1160, 520);
		bod.addPoint (1118,568);
		bod.addPoint (1100,550);
		g.fillPolygon(bod);
		g.setColor(Color.RED);
		g.fillOval((int)(90*Math.cos(x/5+Math.PI/2))+1205, (int)(90*Math.sin(x/5+Math.PI/2))+465, 30, 30);
		g.fillOval (1094, 544, 30, 30);
		Polygon lboot = new Polygon();
		lboot.addPoint (1150, 650);
		lboot.addPoint (1184, 650);
		lboot.addPoint (1178, 700);
		lboot.addPoint (1144, 700);
		g.fillPolygon (lboot);
		Polygon rboot = new Polygon();
		rboot.addPoint (1196,650);
		rboot.addPoint (1230, 650);
		rboot.addPoint (1236, 700);
		rboot.addPoint (1202, 700);
		g.fillPolygon(rboot);
		Color belt = new Color (20, 20, 20);
		g.setColor (belt);
		g.fillRect(1160, 560, 60, 15);
		Color zip = new Color (220, 220, 220);
		g.setColor (zip);
		g.fillRect (1188, 480, 4, 30);
		
		//Dragon
		g.setColor(Color.BLACK);
		Polygon head = new Polygon();
		head.addPoint(x+600*dir, 230);
		head.addPoint(x+600*dir, 210);
		head.addPoint(x+640*dir, 210);
		head.addPoint(x+640*dir, 225);
		head.addPoint(x+750*dir, 210);
		head.addPoint(x+760*dir, 245);
		head.addPoint(x+640*dir, 270);
		head.addPoint(x+710*dir, 300);
		head.addPoint(x+700*dir, 330);
		head.addPoint(x+600*dir, 290);
		g.fillPolygon(head);
		Polygon body = new Polygon();
		body.addPoint(x, 200);
		body.addPoint(x, 300);
		body.addPoint(x+300*dir, 300);
		body.addPoint(x+300*dir, 200);
		g.fillPolygon(body);
		Polygon neck = new Polygon();
		neck.addPoint(x+300*dir, 210);
		neck.addPoint(x+300*dir, 270);
		neck.addPoint(x+600*dir, 290);
		neck.addPoint(x+600*dir, 230);
		g.fillPolygon(neck);
		Polygon thing2 = new Polygon();
		thing2.addPoint(x-200*dir,220);
		thing2.addPoint(x-200*dir, 280);
		thing2.addPoint(x,280);
		thing2.addPoint(x,220);
		g.fillPolygon(thing2);
		Polygon tail = new Polygon();
		tail.addPoint(x-200*dir, 220);
		tail.addPoint(x-200*dir, 280);
		tail.addPoint(x-400*dir, 300);
		tail.addPoint(x-400*dir, 240);
		g.fillPolygon(tail);
		Polygon thing = new Polygon();
		thing.addPoint(x-600*dir, 240);
		thing.addPoint(x-600*dir, 300);
		thing.addPoint(x-400*dir, 300);
		thing.addPoint(x-400*dir, 240);
		g.fillPolygon(thing);
		Polygon leg = new Polygon();
		leg.addPoint(x+90*dir, 300);
		leg.addPoint(x+150*dir, 300);
		leg.addPoint(x+60*dir, 400);
		leg.addPoint(x, 400);
		g.fillPolygon(leg);
		g.setColor(Color.MAGENTA);
		Polygon eye = new Polygon();
		eye.addPoint(x+610*dir, 225);
		eye.addPoint(x+630*dir, 225);
		eye.addPoint(x+630*dir, 217);
		eye.addPoint(x+610*dir, 217);
		g.fillPolygon(eye);
		g.setColor(Color.gray);
		Polygon wingt = new Polygon();
		wingt.addPoint(x+300*dir, 230);
		wingt.addPoint(x+370*dir, 180);
		wingt.addPoint(x, 160);
		wingt.addPoint(x+350*dir, 180);
		wingt.addPoint(x, 180);
		wingt.addPoint(x+350*dir, 185);
		wingt.addPoint(x+270*dir, 230);
		g.fillPolygon(wingt);

	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (x >=1200)
			x=1;
		if(x<=0)
			x = 1200;
		x+=add;
		if(x==200 && y==200)
			add*=-1;
		if(x==10 && y==10)
			add*=-1;
		if (lat < 565){
			lat ++;
		}
		if(dim ==1) {
		int prob = (int)(Math.random()*100);
		if(pigx==1600||pigx==0)
			dir2*=(-1);
		if(prob==0) {
			dir2*=(-1);
		}
		pigx+=dir2*2;
		if(beam&&Math.abs(pigx-y)<225) {
			cook+=4;
		}
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			y-=3;
			dir1 = 1;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			y+=3;
			dir1 = -1;
		}
		if (lat == 565 && e.getKeyCode() == KeyEvent.VK_UP) {
			lat -= 100;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			beam = beam==false;
		}
		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>750&&e.getX()<890&&e.getY()>660&&e.getY()<700){
			dim*=(-1);
			cook = 0;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		dir*=(-1);
		add*=(-1);
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}






