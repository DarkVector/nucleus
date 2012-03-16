package net.adil.nucleus.game.message;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class ClientMessage 
{
	private int id;
	private ChannelBuffer body;
	
	public ClientMessage(ChannelBuffer body)
	{
		this.id = body.readInt();
		
		//Initialise the rest of the message.
		this.body = (body == null || body.readableBytes() == 0) ? ChannelBuffers.EMPTY_BUFFER : body;
	}
	
	/*
	 * @param Read an integer received by the buffer
	 */
	public int readInt()
	{
		return this.body.readInt();
	}
	/*
	 * @param Read a byte received by the buffer
	 */
	public byte readByte()
	{
		return this.body.readByte();
	}
	/*
	 * @param Read a boolean in the buffer.
	 */
	public boolean readBoolean()
	{
		if(this.body.readableBytes() > 0 && this.body.readByte() == 1)
		{
			return true;
		}
		return false;
	}
}
