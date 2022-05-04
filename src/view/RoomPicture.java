package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.CombatCommand;

@SuppressWarnings("serial")
public class RoomPicture extends JPanel implements GameObserver {

	ImageIcon picture;
	JLabel picLabel;
	MUDFrame _dadFrame;

	public RoomPicture(String path, MUDFrame j) {
		picture = new ImageIcon(path);
		_dadFrame = j;
		init();
	}
	
	public void init()
	{
		this.setBackground(new Color(72, 60, 50));
		this.setSize(new Dimension(1141, 835));
		this.setLocation(new Point(755, 45));
		picLabel = new JLabel(picture);
		this.add(picLabel);
	}
	
	//changes picture
	public void changePicture(String path) {
		picture = new ImageIcon(path);
		picLabel.setIcon(picture);
	}

	@Override
	public void combat(CombatCommand combatCommand) {}

	@Override
	public void image(String id) {
		changePicture("res/media/Room_" + id + ".jpg");
		if (id.equals("754") || id.equals("944"))
		{
			_dadFrame.enableBar(false);
			new MemoryGame1(_dadFrame);
		}
		
		if (id.equals("912") || id.equals("943"))
		{
			_dadFrame.enableBar(false);
			new RescueWendy1(_dadFrame);
		}
		
		if (id.equals("1"))
		{
			StdAudio.stop();
			StdAudio.loopInBackground("res/media/dreamTheme.wav");
		}
		
		if (id.equals("11"))
		{
			StdAudio.stop();
			StdAudio.loopInBackground("res/media/forestTheme.wav");
		}
		
		if (id.equals("15"))
		{
			_dadFrame.enableBar(true);
		}
		
		if (id.equals("43"))
		{
			StdAudio.stop();
			StdAudio.loopInBackground("res/media/townTheme.wav");
		}
		
		if (id.equals("740"))
		{
			StdAudio.stop();
			StdAudio.loopInBackground("res/media/castleTheme.wav");
		}
		
		if (id.equals("907"))
		{
			_dadFrame.enableBar(false);
			StdAudio.stop();
			StdAudio.loopInBackground("res/media/bossTheme.wav");
		}
		
		if (id.equals("914"))
		{
			StdAudio.stop();
			StdAudio.loopInBackground("res/media/castleTheme.wav");
		}
		
		if (id.equals("940"))
		{
			_dadFrame.enableBar(true);
		}
	}

	@Override
	public void deleteButton() {}
}
