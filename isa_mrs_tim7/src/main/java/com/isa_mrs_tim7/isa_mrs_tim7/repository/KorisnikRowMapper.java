package com.isa_mrs_tim7.isa_mrs_tim7.repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.*;




public class KorisnikRowMapper implements RowMapper<RegistrovaniKorisnik> {

	@Override
	public RegistrovaniKorisnik mapRow(ResultSet rs, int rowNum) throws SQLException {
        RegistrovaniKorisnik user = new RegistrovaniKorisnik();
        user.setIme(rs.getString("ime"));
        user.setLozinka(rs.getString("lozinka"));
        user.setPrezime(rs.getString("prezime"));
        user.setEmail(rs.getString("email"));
        return user;
    }

}
