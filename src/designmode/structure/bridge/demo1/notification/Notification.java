package designmode.structure.bridge.demo1.notification;

import designmode.structure.bridge.demo1.sender.MsgSender;

public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}
