package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorretto(String anagramma) {
		String sql="select * "
				+ "from parola "
				+ "where nome=?";
		
		boolean valore=false;
		
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet res= st.executeQuery();
			
			if(res.next())
				return true;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		return valore;
	}
	
}
