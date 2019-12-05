package control;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.Contato;
import util.DAO;
import view.DisplayMain;

public class DisplayMainController {

	public static void excluir() {

		if (DisplayMain.tabela.getSelectedRow() != -1) {
			Contato contato = new Contato();
			DAO contDao = new DAO();
			contato.setId((int) DisplayMain.tabela.getValueAt(DisplayMain.tabela.getSelectedRow(), 0));
			contDao.excluir(contato);
			visualizar();
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um contato para excluir");
		}

	}

	public static void visualizar() {
		DefaultTableModel modelo = (DefaultTableModel) DisplayMain.tabela.getModel();
		DisplayMain.tabela.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		modelo.setNumRows(0);
		DAO contatoDao = new DAO();
		for (Contato c : contatoDao.visualizar()) {
			modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getTelefone(), c.getEnde(), c.getNum(),
					c.getBairro(), c.getCidade(), c.getUf(), c.getCaoAdotado() });
		}

	}

	public static void buscar(String nome) {
		DefaultTableModel modelo = (DefaultTableModel) DisplayMain.tabela.getModel();
		DisplayMain.tabela.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		modelo.setNumRows(0);
		DAO contatoDao = new DAO();
		for (Contato c : contatoDao.buscar(nome)) {
			modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getTelefone(), c.getEnde(), c.getNum(),
					c.getBairro(), c.getCidade(), c.getUf(), c.getCaoAdotado() });
		}
	}

	

	

	

	
}
