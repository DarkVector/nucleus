package net.adil.nucleus;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.*;

import net.adil.nucleus.database.Datastore;
import net.adil.nucleus.network.PipelineFactory;

import net.adil.nucleus.util.Configurator;

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
public class Nucleus 
{
	public static String BASEPATH = "src/main/resources/";
	public static Configurator cfg = new Configurator();
	private static final Logger logger = Logger.getLogger(Nucleus.class.getName());
	public static ExecutorService executorService;
	private static PipelineFactory pipelineFactory = new PipelineFactory();
	
	
	public static void main(String[] args)
	{
		
		cfg.loadConfiguration(BASEPATH+"nucleus.properties");
		setupExecutorService();
		pipelineFactory.BootNetwork();
	
		Datastore.Connect();
	}
	
	  public static void setupExecutorService() {
	        logger.info("Attempting to configure the executor service");
	        int threadCount = getConfig().fetchInteger("net.adil.nucleus.thread.executorthreads");

	        if (! (threadCount > 4)) {
	            threadCount = 4;
	        }

	       executorService = Executors.newFixedThreadPool(threadCount);
	    }
	  
	  public static Configurator getConfig()
	  {
		  return cfg;
	  }

}
