package com.my.util;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;

/**
 * @Author: dongqihang
 * @Date: Created in 19:31 2019/3/16
 */
public class runner implements Runnable {
    XMPPConnection connection;
    @Override
    public void run() {
        while (true){
            connection=xmpptest.getCon();
//                Roster roster = connection.getRoster();
//                Collection<RosterEntry> entries = roster.getEntries();
//                for (RosterEntry item:
//                        entries) {
//                    System.out.println(item.getName());
//                    System.out.println(item.getUser());
//                }
            ChatManager cm=connection.getChatManager();
            Chat chat=cm.createChat("user1@129.204.207.18", new MessageListener() {
                @Override
                public void processMessage(Chat chat, Message message) {
//                    message.setBody("send test");
                    System.out.println(message.getFrom()+"said:"+message.getBody());
                }
            });
//                Message m=new Message();
//                m.setBody("send message test");
//                try {
//                    chat.sendMessage(m);
//                } catch (XMPPException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(roster);
        }
    }
}
