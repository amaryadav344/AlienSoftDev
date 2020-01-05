package com.business.businesstire.Queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageQueue {
    private static MessageQueue mMessageQueue;
    private Channel channel;

    public static MessageQueue getInstance() throws IOException, TimeoutException {
        if (mMessageQueue == null) {
            mMessageQueue = new MessageQueue();
        }
        return mMessageQueue;
    }

    private MessageQueue() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        channel = connection.createChannel();
    }

    public Channel getChannel() {
        return channel;
    }
}
