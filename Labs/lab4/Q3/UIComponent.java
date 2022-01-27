package lab4.Q3;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


import lab4.Q3.model.DBMediator;
import lab4.Q3.model.DBModel;

public class UIComponent extends JFrame {
	GridBagConstraints gbc;
	GridBagLayout gbl;
	JLabel name, atricleID, atricleTitle, atricleDesc, atricleUV, articleDV,message,articleAuthor;
	JTextField inputID, inputTitle, inputDesc, inputUV, inputDV,inputAuthor;
	JButton save, search, update, delete;
	JTable table;
	ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
	ArrayList<String> column = new ArrayList<String>(List.of("I_D", "Title", "Description", "Author", "Upvotes","Downvotes"));
	DefaultTableModel tableModel;
	DBModel model = new DBModel();
	JComboBox box;
	ArrayList<JTextField> arguments;
	DBMediator dbm = new DBMediator();
	ArrayList<String> show;
	
	private UIComponent() {
		initializeComponents();

		addConstraints();

		eventListeners();
		setMinimumSize(new Dimension(400, 300));
		pack();
//		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void eventListeners() {
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputID.setEnabled(false);
				inputTitle.setEnabled(false);
				inputDesc.setEnabled(false);
				inputAuthor.setEnabled(false);
				inputUV.setEnabled(false);
				inputDV.setEnabled(false);
				save.setEnabled(false);
				search.setEnabled(false);
				update.setEnabled(false);
				delete.setEnabled(false);
				String selected = box.getItemAt(box.getSelectedIndex()).toString();
				if(selected.equalsIgnoreCase("Save")) {
					inputTitle.setEnabled(true);
					inputDesc.setEnabled(true);
					inputAuthor.setEnabled(true);
					save.setEnabled(true);
				}else if(selected.equalsIgnoreCase("Update")) {
					update.setEnabled(true);
					System.out.println(data);
				}else if(selected.equalsIgnoreCase("Search")) {
					inputID.setEnabled(true);
					inputTitle.setEnabled(true);
					inputDesc.setEnabled(true);
					inputAuthor.setEnabled(true);
					inputUV.setEnabled(true);
					search.setEnabled(true);
					inputDV.setEnabled(true);
				}else if(selected.equalsIgnoreCase("Delete")) {
					inputID.setEnabled(true);
					delete.setEnabled(true);
				}
			}
		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {		
				try {
					model.prepare();
					arguments = new ArrayList<>();
					arguments.add(inputTitle);
					arguments.add(inputDesc);
					arguments.add(inputAuthor);
					dbm.save(arguments,model);
					arguments = null;
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					model.prepare();
					arguments = new ArrayList<>();
					arguments.add(inputID);
					arguments.add(inputTitle);
					arguments.add(inputDesc);
					arguments.add(inputAuthor);
					arguments.add(inputUV);
					arguments.add(inputDV);
					data = new ArrayList<ArrayList<String>>();
					ResultSet result = dbm.select(arguments,model);
					while(result.next()){;
						show = new ArrayList<String>();
						show.add(result.getString("I_D"));
						show.add(result.getString("Title"));
						show.add(result.getString("Description"));
						show.add(result.getString("Author"));
						show.add(result.getString("upvotes"));
						show.add(result.getString("downvotes"));
						data.add(show);
						tableModel.addRow(show.toArray());
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				show = new ArrayList<String>();
				show.add(tableModel.getValueAt(e.getFirstRow(),1).toString());
				show.add(tableModel.getValueAt(e.getFirstRow(),2).toString());
				show.add(tableModel.getValueAt(e.getFirstRow(),0).toString());
			}
		});
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					model.prepare();
					dbm.update(show, model);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					model.prepare();
					dbm.delete(inputID.getText().toString(),model);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void initializeComponents() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		setLayout(gbl);
		setTitle("Daily News");

		name = new JLabel("Daily News",SwingConstants.CENTER);
		name.setHorizontalTextPosition(SwingConstants.CENTER);
		String oprions[] = {"Save","Search","Update","Delete"};
		box = new JComboBox(oprions);
		
		atricleID = new JLabel("ID: ");
		atricleTitle = new JLabel("Title: ");
		atricleDesc = new JLabel("Description: ");
		articleAuthor = new JLabel("Author");
		atricleUV = new JLabel("Upvotes: ");
		articleDV = new JLabel("Downvotes: ");
		message = new JLabel("Extension of WT Project: https://sagundev.com.np/");
		
		inputAuthor = new JTextField();
		inputID = new JTextField();
		inputTitle = new JTextField();
		inputDesc = new JTextField();
		inputUV = new JTextField();
		inputDV = new JTextField();

		inputID.setColumns(5);
		inputTitle.setColumns(5);
		inputDesc.setColumns(5);
		inputUV.setColumns(5);
		inputDV.setColumns(5);

		save = new JButton("Save", new ImageIcon("E:\\eclipse-workspace\\College\\src\\lab4\\Q3\\icons\\save.png"));
		save.setVerticalTextPosition(SwingConstants.BOTTOM);
		save.setHorizontalTextPosition(SwingConstants.CENTER);

		search = new JButton("Search",
				new ImageIcon("E:\\eclipse-workspace\\College\\src\\lab4\\Q3\\icons\\search.png"));
		search.setVerticalTextPosition(SwingConstants.BOTTOM);
		search.setHorizontalTextPosition(SwingConstants.CENTER);

		update = new JButton("Update",
				new ImageIcon("E:\\eclipse-workspace\\College\\src\\lab4\\Q3\\icons\\update.png"));
		update.setVerticalTextPosition(SwingConstants.BOTTOM);
		update.setHorizontalTextPosition(SwingConstants.CENTER);

		delete = new JButton("Delete",
				new ImageIcon("E:\\eclipse-workspace\\College\\src\\lab4\\Q3\\icons\\delete.png"));
		delete.setVerticalTextPosition(SwingConstants.BOTTOM);
		delete.setHorizontalTextPosition(SwingConstants.CENTER);
		
		Object[][] send= arrayListToObject();
		tableModel = new DefaultTableModel(send,column.toArray());
		table = new JTable(tableModel);
		
		inputTitle.setEnabled(true);
		inputDesc.setEnabled(true);
		inputAuthor.setEnabled(true);
		save.setEnabled(true);
		inputID.setEnabled(false);
		inputUV.setEnabled(false);
		inputDV.setEnabled(false);
		search.setEnabled(false);
		update.setEnabled(false);
		delete.setEnabled(false);
	}

	private Object[][] arrayListToObject() {
		Object send[][] = new Object[data.size()][column.size()];
		for(int i = 0;i<data.size();i++) {
			send[i] = data.get(i).toArray();
		}
		return send;		
	}

	private void addConstraints() {
		gbc.gridwidth = 4;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(15, 5, 5, 5);
		gbl.setConstraints(name, gbc);
		add(name);
		
		
		gbc.insets = new Insets(1, 1, 5, 5);
		gbc.gridwidth = 1;
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbl.setConstraints(box, gbc);
		add(box);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbl.setConstraints(atricleID, gbc);
		add(atricleID);

		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbl.setConstraints(inputID, gbc);
		add(inputID);

		gbc.gridwidth = 1;
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbl.setConstraints(atricleTitle, gbc);
		add(atricleTitle);

		gbc.gridwidth = 2;
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbl.setConstraints(inputTitle, gbc);
		add(inputTitle);

		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbl.setConstraints(atricleDesc, gbc);
		add(atricleDesc);

		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(inputDesc, gbc);
		add(inputDesc);

		gbc.gridwidth = 1;
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbl.setConstraints(articleAuthor, gbc);
		add(articleAuthor);
		
		gbc.gridwidth = 2;
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbl.setConstraints(inputAuthor, gbc);
		add(inputAuthor);
		
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbl.setConstraints(atricleUV, gbc);
		add(atricleUV);

		gbc.gridwidth = 2;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbl.setConstraints(inputUV, gbc);
		add(inputUV);

		gbc.gridwidth = 1;
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbl.setConstraints(articleDV, gbc);
		add(articleDV);

		gbc.gridwidth = 2;
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbl.setConstraints(inputDV, gbc);
		add(inputDV);

		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbl.setConstraints(save, gbc);
		add(save);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbl.setConstraints(search, gbc);
		add(search);

		gbc.gridx = 3;
		gbc.gridy = 4;
		gbl.setConstraints(update, gbc);
		add(update);

		gbc.gridx = 4;
		gbc.gridy = 4;
		gbl.setConstraints(delete, gbc);
		add(delete);
		
		gbc.gridwidth = 5;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbl.setConstraints(message, gbc);
		add(message);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 5;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 6;
		table.setBorder(BorderFactory.createBevelBorder(ALLBITS));
		JScrollPane scroll = new JScrollPane(table);
		scroll.setMinimumSize(new Dimension(10,50));
		scroll.setPreferredSize(new Dimension(100,90));
		gbl.setConstraints(scroll, gbc);
		add(scroll);
	}

	public static void main(String[] args) {
		new UIComponent();
	}

}
