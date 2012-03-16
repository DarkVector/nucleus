package net.adil.nucleus.game.message;


import java.nio.charset.Charset;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;


public class ServerMessage 
{
    private ChannelBuffer body;
	private int id;
	
	private int MESSAGE_SIZE=1024;
	
	/*
	 * @param Constructor for server message class. Sets the buffer size to the MESSAGE_SIZE variable
	 */
	public ServerMessage(int id)
	{
		this.id = id;
		this.body = ChannelBuffers.dynamicBuffer(this.MESSAGE_SIZE);
	
	}
	/*
	 * @param String Method to write to the buffer
	 */
	public void AppendString(String message)
	{
		this.body.writeBytes(message.getBytes());
	}
	/*
	 * @param Int32 'hack' to append an integer of 32 bits. Not sure if it works as of now.
	 */
	public void AppendInt32(int num)
	{
		this.body.writeInt(num >> 32); //shifts 32 places?
	}
	/*
	 * @param Appends a normal int to the buffer
	 */
	public void AppendInt(int num)
	{
		this.body.writeInt(num);
	}
	/*
	 * @param Appends a boolean "0" or "1" to the buffer. Needs to be looked into though.
	 */
	public void AppendBoolean(byte value)
	{
		this.body.writeByte(value);
	}
	/*
	 * @param Return the length of the current buffer
	 */
	public int getLength()
	{
		return	this.body.readableBytes();
	}
	/*
	 * @param Return the string value of the buffer
	 */
	public String getMessageString()
	{
		return this.body.toString(Charset.defaultCharset());
	}
	
}


