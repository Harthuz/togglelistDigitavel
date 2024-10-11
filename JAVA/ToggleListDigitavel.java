import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToggleListDigitavel extends JFrame {

    private JTextField searchField;
    private JList<String> itemList;
    private DefaultListModel<String> listModel;
    private JButton toggleButton;
    private JPanel listPanel;

    public ToggleListDigitavel() {
        // Configuração da Janela
        setTitle("Toggle List Digitável");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Campo de pesquisa
        searchField = new JTextField(20);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterList();
            }
        });

        // Modelo da lista
        listModel = new DefaultListModel<>();
        listModel.addElement("A 1");
        listModel.addElement("A 2");
        listModel.addElement("B 3");
        listModel.addElement("B 4");
        listModel.addElement("C 5");
        listModel.addElement("C 6");


        // Lista que exibe os itens
        itemList = new JList<>(listModel);

        // Painel para lista
        listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.add(new JScrollPane(itemList), BorderLayout.CENTER);
        listPanel.setVisible(false); // Inicialmente escondido

        // Botão de toggle para mostrar/ocultar a lista
        toggleButton = new JButton("Selecionar Item");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPanel.setVisible(!listPanel.isVisible());
            }
        });

        // Adicionar componentes à janela
        add(toggleButton, BorderLayout.NORTH);
        add(searchField, BorderLayout.CENTER);
        add(listPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Método para filtrar os itens da lista
    private void filterList() {
        String filter = searchField.getText().toLowerCase();
        DefaultListModel<String> filteredModel = new DefaultListModel<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            String item = listModel.getElementAt(i);
            if (item.toLowerCase().contains(filter)) {
                filteredModel.addElement(item);
            }
        }
        itemList.setModel(filteredModel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToggleListDigitavel();
            }
        });
    }
}
