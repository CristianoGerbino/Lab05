package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Parola;

public class ParolaDAO {

	public boolean esisteParola(Parola p) {
		
		final String sql = "SELECT nome FROM parola WHERE nome = ?";
		ResultSet rs;
		boolean res;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, p.toString());
			rs = st.executeQuery();
			
			if (rs.next())
				res = true;
			else 
				res = false;
			conn.close();
		} catch (SQLException e)  {
			throw new RuntimeException("Errore DB");
		}
		return res;
	}

}
