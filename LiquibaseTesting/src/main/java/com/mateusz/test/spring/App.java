package com.mateusz.test.spring;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class App
{

	final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/mateusz/test/spring/beans/beans.xml");

		DataBaseChangeLogDAO OffersDAO = (DataBaseChangeLogDAO) context
				.getBean("OffersDAO");
		App testLog4j = new App();

		try
		{
			List<DataBaseChangeLog> dataBaseChangeLogItems = OffersDAO
					.getDataBaseChangeLog();

			for (DataBaseChangeLog offer : dataBaseChangeLogItems)
			{
				testLog4j.runMe(offer.toString());
			}

		}
		catch (DataAccessException ex)
		{
			testLog4j.runMe(ex.getMessage());
			testLog4j.runMe("" + ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}

	private void runMe(String parameter)
	{
		if (logger.isDebugEnabled())
		{
			logger.debug("This is debug : " + parameter);
		}

		if (logger.isInfoEnabled())
		{
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
	}

}
