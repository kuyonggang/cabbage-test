package designmode.structure.bridge.demo1.notification;

import designmode.structure.bridge.demo1.sender.MsgSender;

public class SevereNotification extends Notification {

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
