package base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class BasePanel extends JPanel{
	
	public BasePanel bpCenter;
	public BasePanel bpLeft;
	public BasePanel bpRight;
	public BasePanel bpTop;
	public BasePanel bpBottom;

	public BasePanel() {
		super(new BorderLayout());
	}
	
	public BasePanel setFlowLayoutCenter() {
		super.setLayout(new FlowLayout(FlowLayout.CENTER));
		return this;
	}
	
	public BasePanel addChild() {
		bpCenter = new BasePanel();
		bpLeft = new BasePanel();
		bpRight = new BasePanel();
		bpTop = new BasePanel();
		bpBottom = new BasePanel();
		
		super.add(bpCenter, BorderLayout.CENTER);
		super.add(bpLeft, BorderLayout.WEST);
		super.add(bpRight, BorderLayout.EAST);
		super.add(bpTop, BorderLayout.NORTH);
		super.add(bpBottom, BorderLayout.SOUTH);
		
		return this;
	}
}
