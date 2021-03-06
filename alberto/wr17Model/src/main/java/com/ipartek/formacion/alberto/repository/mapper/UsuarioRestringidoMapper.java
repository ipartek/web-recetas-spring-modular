package com.ipartek.formacion.alberto.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.alberto.domain.Usuario;

/**
 * Mapeo del podo Usuario sin password
 * 
 * @author Curso
 *
 */
public class UsuarioRestringidoMapper implements RowMapper<Usuario> {

	@Override()
	public Usuario mapRow(ResultSet rs, int numRow) throws SQLException {

		Usuario u = new Usuario();

		u.setId(rs.getLong("id"));
		u.setNombre(rs.getString("nombre"));
		u.setEmail(rs.getString("email"));
		u.setImagen(rs.getString("imagen"));

		return u;
	}

}
