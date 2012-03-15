package net.adil.nucleus.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


/*
 *  <Nucleus, a simple server/client base for applications.>
 *  Copyright (C) <2012>  <Adil Hafeez>
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class Configurator 
{
/*
 * @author:Adil
 * class for configuration parsing
 */   Logger  logger = Logger.getLogger(this.getClass().getName());
	private Properties configuration;
	
	public Configurator()
	{
		configuration = new Properties();
	}
	
	public void loadConfiguration(String file)
	{
		 try
	        {
	            
	            configuration.load(new FileInputStream(file));
	        }
		 catch(IOException e)
	        {
	            logger.fatal("Could not load configuration" + file);
	            System.exit(1);
	        }
	        logger.info("Configuration added");
	    }
	
	/*
	 * @param: Returns a key inside the properties file
	 */
	public String fetchProperty(String key)
	{
		return configuration.getProperty(key);
	}
	
	/*
	 * @param: Returns an integer through fetching a key and parsing it
	 */
	public int fetchInteger(String key)
	{
		return Integer.parseInt(fetchProperty(key));
	}
	
}
