package view;

import java.awt.CardLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBase extends JPanel implements VisualWindow {

	AddForm addForm;
	DisplayMain displayMain;
	public static final int DISPLAY_MAIN = 1;
	public static final int ADD_FORM = 2;

	public PanelBase() {
		setLayout();
		setComponents();
		setEvents();
	}

	@Override
	public void setLayout() {
		setLayout(new CardLayout());

	}

	@Override
	public void setComponents() {
		addForm = new AddForm();
		displayMain = new DisplayMain();

		add(displayMain, "displaymain");
		add(addForm, "addform");

	}

	@Override
	public void setEvents() {
		// TODO Auto-generated method stub

	}

}
