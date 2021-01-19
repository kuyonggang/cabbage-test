package designmode.structure.bridge.demo1.sender;

import java.util.List;

public class TelephoneMsgSender implements MsgSender {

    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        // todo 短信发送逻辑
    }

}
