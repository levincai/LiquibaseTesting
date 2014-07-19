package com.mateusz.test.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("OffersDAO")
public class DataBaseChangeLogDAO
{

	private JdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc)
	{
		this.jdbc = new JdbcTemplate(jdbc);
	}

	public List<DataBaseChangeLog> getDataBaseChangeLog()
	{
		return jdbc.query("select * FROM databasechangelog",
				new RowMapper<DataBaseChangeLog>()
				{

					public DataBaseChangeLog mapRow(ResultSet rs, int rowNum)
							throws SQLException
					{
						DataBaseChangeLog offer = new DataBaseChangeLog();
						offer.setId(rs.getString("id"));
						offer.setAuthor(rs.getString("author"));
						offer.setFilename(rs.getString("filename"));
						offer.setLiquibase(rs.getString("liquibase"));
						offer.setComments(rs.getString("comments"));
						offer.setExectype(rs.getString("exectype"));
						return offer;
					}

				});
	}
}
