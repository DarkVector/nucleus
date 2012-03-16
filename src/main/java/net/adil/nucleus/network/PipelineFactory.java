package net.adil.nucleus.network;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import net.adil.nucleus.network.codec.Encoder;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class PipelineFactory {
	 private NioServerSocketChannelFactory CFactory;
		public ServerBootstrap SBootstrap;
		public int Port;
		private Logger logger = Logger.getLogger(this.getClass().getName());

	        public PipelineFactory(){
	        this.CFactory = new NioServerSocketChannelFactory
					(
							Executors.newCachedThreadPool(),
	                        Executors.newCachedThreadPool(),
	                        Runtime.getRuntime().availableProcessors()*2+1
					);

	        this.SBootstrap = new ServerBootstrap(CFactory);
	        Network();
	        logger.info("Pipelines initialised");
	        }
	        private void Network(){

	        ChannelPipeline cpipeline = this.SBootstrap.getPipeline();
	        cpipeline.addLast("Encoder",new Encoder());
	     //   cpipeline.addLast("Decoder", new Decoder());
	        //TO-DO


	        }
	        public void BootNetwork(){

	       try{  
	        this.SBootstrap.bind(new InetSocketAddress(Port));
	        Executors.newCachedThreadPool();
	        Executors.newCachedThreadPool();
	       }catch(Exception ex)
	       {
	    	   logger.severe(ex.getMessage());
	       }
	        }
	        public void Close(){

	           SBootstrap.releaseExternalResources();
	          logger.warning("Released pipelines");
	        }

	}