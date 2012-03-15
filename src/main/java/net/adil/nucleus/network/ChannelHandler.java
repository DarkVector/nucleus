package net.adil.nucleus.network;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.jboss.netty.channel.Channel;

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
public class ChannelHandler 
{
	/*
	 * Handle clients here
	 * @author: Adil
	 */
	private Channel mainChannel;
	public int clients = 0;
	private Map<Integer, Channel> clientMap = new HashMap<Integer, Channel>();
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	/*
	 * @param: Add a connection to our hashmap
	 */
	public void AddConnection(Channel channel, int id)
	{
		this.clientMap.put(id, channel);
		++clients;
		logger.info("Client connected");
	}
	/*
	 * @param: Remove a connection
	 */
	public void DestroyConnection(Channel channel)
	{
		this.clientMap.remove(channel);
		channel.close();
		logger.info("Client removed");
	}
	/*
	 * @param: Write to the channel object
	 */
	public void write(Object message)
	{
		
		this.mainChannel.write(message);
	}
	
}
