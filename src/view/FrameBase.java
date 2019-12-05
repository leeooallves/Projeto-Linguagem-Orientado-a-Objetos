package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import util.ConexaoBD;

@SuppressWarnings("serial")
public class FrameBase extends JFrame implements VisualWindow {

	public static PanelBase panelBase;
	public static CardLayout c1;
	public JMenuBar menuBar;
	public JMenu menuOpc;
	public JMenuItem menuSobre, menuExit;

	public FrameBase() {
		setLayout();
		setComponents();
		setEvents();
		repaintAll();
		new ConexaoBD();
	}

	public void setLayout() {
		setTitle("Agenda de Cães Adotados");
		// setResizable(false);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/iconFrame.png")));
	}

	public void setComponents() {
		menuBar = new JMenuBar();
		menuOpc = new JMenu("Opções");
		menuSobre = new JMenuItem("Sobre");
		menuExit = new JMenuItem("Sair");

		menuBar.setBackground(Color.WHITE);
		menuBar.setOpaque(true);
		menuOpc.add(menuSobre);
		menuOpc.add(menuExit);
		menuBar.add(menuOpc);

		add(menuBar, BorderLayout.NORTH);
		panelBase = new PanelBase();
		c1 = new CardLayout();
		c1 = (CardLayout) panelBase.getLayout();
		add(panelBase, BorderLayout.CENTER);

	}

	@Override
	public void setEvents() {

		menuSobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Todos os Direitos Reservados");

			}
		});

		menuExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fecharJanela();

			}
		});

	}

	public static void showPanels(int panelBaseConstants, Object o) {
		switch (panelBaseConstants) {
		case 1:
			c1.show(panelBase, "displaymain");
			break;
		case 2:
			c1.show(panelBase, "addform");
			break;
		default:
			break;
		}

	}

	private void repaintAll() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				repaint();
				pack();
				setSize(800, 600);
			}
		});
	}

	public static void fecharJanela() {
		System.exit(0);
	}

}
