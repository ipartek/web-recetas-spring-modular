package com.ipartek.formacion.nagore.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.nagore.domain.Receta;

/**
 * Mapeo del pojo Recetas
 * 
 * @author Curso
 *
 */
public class RecetaMapper implements RowMapper<Receta> {

	@Override()
	public Receta mapRow(ResultSet rs, int numRow) throws SQLException {

		Receta r = new Receta();

		r.setId(rs.getLong("id"));
		r.setNombre(rs.getString("nombre"));
		r.setImagen(rs.getString("imagen"));
		r.setDescripcion(rs.getString("descripcion"));

		return r;
	}

}
