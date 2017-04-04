package com.ipartek.formacion.nagore.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.nagore.domain.Ingrediente;

/**
 * Mapeo del pojo Ingrediente con cantidad
 * 
 * @author Curso
 *
 */
public class IngredienteRecetaMapper implements RowMapper<Ingrediente> {

	@Override()
	public Ingrediente mapRow(ResultSet rs, int numRow) throws SQLException {
		Ingrediente i = new Ingrediente();

		i.setId(rs.getLong("id"));
		i.setNombre(rs.getString("nombre"));
		i.setGluten(rs.getBoolean("gluten"));
		i.setCantidad(rs.getString("cantidad"));

		return i;
	}

}
