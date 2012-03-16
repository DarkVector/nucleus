package net.adil.nucleus.game.message;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;


public class ServerMessage 
{
    private ChannelBuffer body;
	private int id;
	
	private int MESSAGE_SIZE=1024;
	
	
	public ServerMessage(int id)
	{
		this.id = id;
		this.body = ChannelBuffers.dynamicBuffer(this.MESSAGE_SIZE);
	}
	
	public void AppendString(String message)
	{
		this.body.writeBytes(message.getBytes());
	}
	public void AppendInt32(int num)
	{
		this.body.writeInt(num >> 32); //shifts 32 places?
	}
}
