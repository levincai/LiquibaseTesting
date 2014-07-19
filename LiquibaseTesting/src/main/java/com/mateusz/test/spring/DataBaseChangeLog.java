package com.mateusz.test.spring;

public class DataBaseChangeLog
{

	private String id;
	private String author;
	private String filename;
	private String liquibase;
	private String comments;
	private String exectype;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getLiquibase()
	{
		return liquibase;
	}

	public void setLiquibase(String liquibase)
	{
		this.liquibase = liquibase;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public String getExectype()
	{
		return exectype;
	}

	public void setExectype(String exectype)
	{
		this.exectype = exectype;
	}

	@Override
	public String toString()
	{
		return "Offers [id=" + id + ", author=" + author + ", filename="
				+ filename + ", liquibase=" + liquibase + ", comments="
				+ comments + ", exectype=" + exectype + "]";
	}

}
