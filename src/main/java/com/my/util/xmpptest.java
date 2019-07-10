package com.my.util;

//import org.jivesoftware.smack.*;
//import org.jivesoftware.smack.packet.Message;
//import org.jivesoftware.smack.packet.Presence;
//import org.jivesoftware.smackx.muc.MultiUserChat;

//import java.util.Collection;
//import java.util.Map;

/**
 * @Author: dongqihang
 * @Date: Created in 19:22 2019/3/15
 */
public class xmpptest {
//    public class runner implements Runnable{

//        @Override
//        public void run() {
//            while (true){
//                XMPPConnection connection;
//                connection=getCon();
////                Roster roster = connection.getRoster();
////                Collection<RosterEntry> entries = roster.getEntries();
////                for (RosterEntry item:
////                        entries) {
////                    System.out.println(item.getName());
////                    System.out.println(item.getUser());
////                }
//                cm=connection.getChatManager();
//                Chat chat=cm.createChat("user1@129.204.207.18", new MessageListener() {
//                    @Override
//                    public void processMessage(Chat chat, Message message) {
//                        message.setBody("send test");
//                        System.out.println(message.getFrom()+"said:"+message.getBody());
//                    }
//                });
////                Message m=new Message();
////                m.setBody("send message test");
////                try {
////                    chat.sendMessage(m);
////                } catch (XMPPException e) {
////                    e.printStackTrace();
////                }
////                System.out.println(roster);
//            }
//        }
//    }
//    private static XMPPConnection con;
//    private static ChatManager cm;
//    public static XMPPConnection getCon(){
//        if(con!=null){
//            return con;
//        }
//        return initCon();
//    }
//    public static XMPPConnection initCon(){
//        con = new XMPPConnection("129.204.207.18");
//        try {
//            con.connect();
//        } catch (XMPPException e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
//    public static boolean conLogin(String username,String password){
//        try {
//            getCon().login(username,password);
//            return true;
//        } catch (XMPPException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    public static void disCon(){
//        if(con!=null){
//            con.disconnect();
//        }
//    }
//    public static void xmppConnect() {
//        con = new XMPPConnection("129.204.207.18");
//        String jid="test1@conference.129.204.207.18";
//        try {
//            getCon();
//            con.connect();
////            Presence presence = new Presence(Presence.Type.available);
////            con.sendPacket(presence);
//            con.login("admin", "admin");
////            MultiUserChat muc = new MultiUserChat(con, jid);
////            try {
////                muc.create("testRoom");
////                muc.sendMessage("testSuccess");
////            } catch (SmackException e) {
////                e.printStackTrace();
////            }
//            Roster roster = con.getRoster();
//            Collection<RosterEntry> entries = roster.getEntries();
//            for (RosterEntry item:
//                 entries) {
//                System.out.println(item.getName());
//                System.out.println(item.getUser());
//            }
//            cm=con.getChatManager();
//            Chat chat=cm.createChat("asdafdasf@conference.129.204.207.18", new MessageListener() {
//                @Override
//                public void processMessage(Chat chat, Message message) {
////                    message.setBody("send test");
//                    System.out.println(message.getFrom()+"said:"+message.getBody());
//                }
//            });
//            Message m=new Message();
//            m.setBody("send message test");
//            chat.sendMessage(m);
//            System.out.println(roster);
//        } catch (XMPPException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        xmppConnect();
////        conLogin("user2", "123456");
////        runner r=new runner();
////        Thread thread=new Thread(r);
////        thread.start();
//    }
}
