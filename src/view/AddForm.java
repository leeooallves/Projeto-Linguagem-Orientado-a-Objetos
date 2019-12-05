package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import control.AddFormController;

@SuppressWarnings("serial")
public class AddForm extends JPanel implements VisualWindow {

	private Font titulo = new Font("SansSerif", Font.BOLD, 40);

	private JLabel jlTitulo;
	private JLabel jlImagem;
	public static JLabel jlNome;
	public static JTextField jtNome;
	public static JLabel jlTel;
	public static JTextField jtTel;
	public static JLabel jlEnd;
	public static JTextField jtEnd;
	public static JLabel jlNum;
	public static JTextField jtNum;
	public static JLabel jlBairro;
	public static JTextField jtBairro;
	public static JLabel jlCidade;
	public static JTextField jtCidade;
	public static JLabel jlUf;
	public static JTextField jtUf;
	public static JLabel jlCaoAdotado;
	public static JTextArea jtCaoAdotado;

	public static JButton jbOk;
	public static JButton jbVoltar;

	public AddForm() {
		setLayout();
		setComponents();
		setEvents();

	}

	public void setLayout() {
		setSize(800, 600);
		setLayout(null);
		setVisible(true);
		setBackground(Color.WHITE);
	}

	public void setComponents() {
		jlTitulo = new JLabel("Cadastro");
		jlImagem = new JLabel();
		jlNome = new JLabel("Nome");
		jtNome = new JTextField();
		jlTel = new JLabel("Telefone");
		jtTel = new JTextField();
		jlEnd = new JLabel("Endereço");
		jtEnd = new JTextField();
		jlNum = new JLabel("Nº");
		jtNum = new JTextField();
		jlBairro = new JLabel("Bairro");
		jtBairro = new JTextField();
		jlCidade = new JLabel("Cidade");
		jtCidade = new JTextField();
		jlUf = new JLabel("UF");
		jtUf = new JTextField();
		jlCaoAdotado = new JLabel("Características do Cão Adotado");
		jtCaoAdotado = new JTextArea();
		jbOk = new JButton();
		jbVoltar = new JButton();

		jlTitulo.setFont(titulo);

		jlImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconFrame.png")));
		jbOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconOk.png")));
		jbVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconCance.png")));
		jbOk.setBackground(Color.WHITE);
		jbVoltar.setBackground(Color.WHITE);
		jtCaoAdotado.setBorder(BorderFactory.createTitledBorder(""));
		jtCaoAdotado.setBorder(BorderFactory.createEtchedBorder());
		jtCaoAdotado.setOpaque(true);

		jlImagem.setBounds(75, 20, 90, 90);
		jlTitulo.setBounds(260, 10, 300, 100);
		jlNome.setBounds(60, 120, 50, 30);
		jtNome.setBounds(150, 120, 270, 30);
		jlTel.setBounds(435, 120, 50, 30);
		jtTel.setBounds(500, 120, 150, 30);
		jlEnd.setBounds(60, 170, 55, 30);
		jtEnd.setBounds(150, 170, 350, 30);
		jlNum.setBounds(520, 170, 50, 30);
		jtNum.setBounds(550, 170, 100, 30);
		jlBairro.setBounds(60, 220, 55, 30);
		jtBairro.setBounds(150, 220, 150, 30);
		jlCidade.setBounds(320, 220, 50, 30);
		jtCidade.setBounds(380, 220, 150, 30);
		jlUf.setBounds(570, 220, 30, 30);
		jtUf.setBounds(600, 220, 50, 30);
		jlCaoAdotado.setBounds(60, 270, 200, 30);
		jtCaoAdotado.setBounds(60, 310, 590, 100);

		jbOk.setBounds(60, 470, 100, 40);
		jbVoltar.setBounds(650, 470, 100, 40);

		add(jlImagem);
		add(jlTitulo);
		add(jlNome);
		add(jtNome);
		add(jlTel);
		add(jtTel);
		add(jlEnd);
		add(jtEnd);
		add(jlNum);
		add(jtNum);
		add(jlBairro);
		add(jtBairro);
		add(jlCidade);
		add(jtCidade);
		add(jlUf);
		add(jtUf);
		add(jlCaoAdotado);
		add(jtCaoAdotado);
		add(jbOk);
		add(jbVoltar);

	}

	public void setEvents() {
		jbOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddFormController.salvar();
			}
		});

		jtNum.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				validaNumero(jtNum);
			}
		});
		jbVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.showPanels(PanelBase.DISPLAY_MAIN, null);

			}
		});
	}

	public void validaNumero(JTextField Numero) {
		@SuppressWarnings("unused")
		long valor;
		if (Numero.getText().length() != 0) {
			try {
				valor = Long.parseLong(Numero.getText());
			} catch (NumberFormatException ex) {
				jtNum.setText("");
				JOptionPane.showMessageDialog(null, "Esse Campo só aceita números", "Informação",
						JOptionPane.INFORMATION_MESSAGE);
				Numero.grabFocus();
				
			}
		}
	}
	
	
}
