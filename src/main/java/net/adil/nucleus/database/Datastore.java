package net.adil.nucleus.database;

import java.sql.Connection;

import org.apache.log4j.Logger;

import net.adil.nucleus.Nucleus;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class Datastore 
{
	static BoneCP connectionPool = null;
	static Connection connection = null;
	private static Logger logger = Logger.getLogger(Datastore.class.getName());

	public static void Connect()
	{
		
 
		try {
			// load the database driver (make sure this is in your classpath!)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			logger.fatal(e.getCause());
			return;
		}
		
		try {
			// setup the connection pool
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl(Nucleus.getConfig().fetchProperty("net.adil.mysql.host").toString()); // jdbc url specific to your database, eg jdbc:mysql://127.0.0.1/yourdb
			config.setUsername(Nucleus.getConfig().fetchProperty("net.adil.mysql.username")); 
			config.setPassword(Nucleus.getConfig().fetchProperty("net.adil.mysql.password"));
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(10);
			config.setPartitionCount(1);
			connectionPool = new BoneCP(config); // setup the connection pool
			
			connection = connectionPool.getConnection(); // fetch a connection
			logger.debug("MySQL initialised");
	}catch(Exception e)
	{
		logger.fatal(e.getCause());
	}
}
}
