package lab4.Q3.model;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

public class DBMediator {
	public void save(ArrayList<JTextField> row,DBModel model) throws SQLException {
		ArrayList<String> rowStr = new ArrayList<String>();
		boolean satisfied = false;
		for(JTextField fields : row) {
			if(fields.getText().toString().isBlank()) {
				fields.setBackground(Color.RED);
				satisfied = false;
				break;
			}else {
				rowStr.add(fields.getText().toString());
				fields.setBackground(Color.WHITE);
				satisfied = true;
			}
		}
		if(satisfied) {
			model.save(rowStr);
		}
	}

	public ResultSet select(ArrayList<JTextField> row,DBModel model) throws SQLException {
		ArrayList<String> rowStr = new ArrayList<String>();
		for(JTextField fields : row) {
			if(fields.getText().toString().isBlank()) {
				rowStr.add("%");
			}else {
				rowStr.add(fields.getText().toString());
			}
		}
		ResultSet resultSet = model.select(rowStr);
		return resultSet;
	}

	public void update(ArrayList<String> update,DBModel model) throws SQLException {
		model.update(update);
	}

	public void delete(String string,DBModel model) throws SQLException{
		model.delete(string);
	}
}
