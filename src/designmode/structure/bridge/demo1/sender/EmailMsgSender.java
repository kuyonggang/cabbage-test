package designmode.structure.bridge.demo1.sender;

import java.util.List;

public class EmailMsgSender implements MsgSender {

    private List<String> emails;

    public EmailMsgSender(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void send(String message) {
        // todo 邮件发送逻辑
    }

}
