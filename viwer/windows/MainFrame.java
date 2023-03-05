package windows;

import java.awt.BorderLayout;

import javax.swing.JButton;

import base.BaseFrame;
import base.BasePanel;

public class MainFrame extends BaseFrame{

	private JButton centerB;
	private JButton bottomB;
	private JButton bottomB2;
	private BasePanel mainP;

	public MainFrame() {
		super("메인", 798, 577, null);
	}

	@Override
	public void setComp() {
		mainP = new BasePanel();
		centerB = new JButton("버튼");
		bottomB = new JButton("버튼");
		bottomB2 = new JButton("버튼");
	}

	@Override
	public void setDigin() {
		
		mainP.addChild();
		mainP.bpCenter.add(centerB);
		
		mainP.bpBottom.addChild();
		mainP.bpBottom.bpCenter.add(bottomB);
		mainP.bpBottom.bpBottom.add(bottomB2);
		

		super.add(mainP);
	}

	@Override
	public void setEvent() {
		
	}

}
