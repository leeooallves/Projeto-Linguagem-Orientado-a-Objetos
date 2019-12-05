package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class Splash extends JWindow {

	JProgressBar barra;
	private int w, h, z, x, y;
	private JLabel jlTexto;
	private JLabel image;
	private Font fonte;

	public Splash() throws InterruptedException {
		this.getToolkit();
		w = Toolkit.getDefaultToolkit().getScreenResolution();
		this.getToolkit();
		h = Toolkit.getDefaultToolkit().getScreenResolution();
		z = 2;
		x = (w - 521) / z;
		y = (h - 335) / z;

		image = new JLabel();
		jlTexto = new JLabel("<html>Agenda de Contatos <br>   de Cães Adotados");
		fonte = new Font("SansSerif", Font.CENTER_BASELINE, 30);

		image.setIcon(new ImageIcon(getClass().getResource("/icones/iconSplash.png")));
		image.setBounds(30, 30, 256, 256);
		jlTexto.setBounds(310, 30, 205, 200);
		jlTexto.setFont(fonte);
		
		this.setLayout(null);
		this.add(image);
		this.add(jlTexto);
		this.setLocation(new Point(x, y));
		this.setSize(521, 335);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		
		
		barra = new JProgressBar();
		barra.setBackground(Color.WHITE);
		barra.setBounds(0, 315, 521, 20);
		barra.setStringPainted(true);
		// barra.setToolTipText(arg0);

		add(barra);

		new Thread() {
			public void run() {
				for (int i = 0; i <= 100; i++) {
					try {
						barra.setValue(i);
						sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}.start();
		Thread.sleep(5000);
		this.setVisible(false);

		new FrameBase();	

	}

}