package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import control.AddFormController;
import control.DisplayMainController;
import model.Contato;

@SuppressWarnings("serial")
public class DisplayMain extends JPanel implements VisualWindow {

	private Font titulo;
	private JLabel jlTitulo;
	private JLabel jlImagem;
	public static JButton btNovo;
	public static JButton btPesquisar;
	public static JButton btEditar;
	public static JButton btExcluir;
	public static JTextField jtNomePesquisar;
	public static JLabel lblStatus;
	public Contato contato = new Contato();
	private JScrollPane scroll = new JScrollPane();
	public static JTable tabela = new JTable();

	public DisplayMain() {
		setLayout();
		setComponents();
		setEvents();
	}

	public void setLayout() {

		setSize(800, 600);
		setLayout(null);
		setBackground(Color.white);
		setVisible(true);

	}

	public void setComponents() {
		titulo = new Font("SansSerif", Font.BOLD, 30);
		jlImagem = new JLabel();
		jlTitulo = new JLabel("Agenda de Contatos de Cães Adotados");
		btNovo = new JButton();
		btEditar = new JButton();
		btExcluir = new JButton();
		btPesquisar = new JButton();
		jtNomePesquisar = new JTextField();
		lblStatus = new JLabel();

		jlImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconFrame.png")));
		btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconPesq.png")));
		btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconNovo.png")));
		btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconEdit.png")));
		btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconExcluir.png")));

		jlTitulo.setFont(titulo);
		btNovo.setBackground(Color.WHITE);
		btPesquisar.setBackground(Color.WHITE);
		btEditar.setBackground(Color.WHITE);
		btExcluir.setBackground(Color.WHITE);
		scroll.setViewportView(tabela);
		tabela.setBackground(Color.WHITE);

		jlImagem.setBounds(75, 20, 90, 90);
		jlTitulo.setBounds(150, 10, 650, 100);
		btNovo.setBounds(45, 100, 90, 50);
		btEditar.setBounds(45, 230, 90, 50);
		btExcluir.setBounds(45, 360, 90, 50);
		jtNomePesquisar.setBounds(160, 110, 440, 30);
		btPesquisar.setBounds(630, 100, 110, 50);
		lblStatus.setBounds(65, 450, 50, 50);
		scroll.setBounds(160, 160, 580, 350);

		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroll.setViewportView(tabela);

		tabela.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "id", "nome", "telefone", "endereço",
				"numero", "bairro", "cidade", "uf", "descrição" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		add(jlImagem);
		add(jlTitulo);
		add(btNovo);
		add(btEditar);
		add(btExcluir);
		add(jtNomePesquisar);
		add(btPesquisar);
		add(scroll);
		add(lblStatus);
		DisplayMainController.visualizar();
	}

	@Override
	public void setEvents() {
		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.showPanels(PanelBase.ADD_FORM, null);

			}
		});

		btPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DisplayMainController.buscar(jtNomePesquisar.getText());
			}
		});

		jtNomePesquisar.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				nomePesquisar(evt);
			}

			private void nomePesquisar(KeyEvent evt) {
				DisplayMainController.buscar(jtNomePesquisar.getText());

			}

		});

		btEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FrameBase.showPanels(PanelBase.ADD_FORM, null);
				
				AddFormController.editar();
			}
		});
		btExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DisplayMainController.excluir();
			}
		});

	}
}
