package net.adil.nucleus.network.codec;

import java.util.logging.Logger;

import org.jboss.netty.channel.ChannelHandlerContext;

import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class Encoder extends SimpleChannelHandler
{

	Logger logger = Logger.getLogger(this.getClass().getName());
public void WriteRequested(ChannelHandlerContext chctx, MessageEvent e)
{
	if(e.getMessage() instanceof String)
	{
	Object message = e.getMessage();
	Channels.write(chctx.getChannel(),message);
	logger.info("Encoder wrote to channel : Message : "+message);
	
}
}
	
}
