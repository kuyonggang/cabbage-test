package redPacket;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class RedPacket {

    private int remainSize;
    private double remainMoney;

    public static double getRandomMoney(RedPacket _redPackage) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (_redPackage.remainSize == 1) {
            _redPackage.remainSize--;
            return (double) Math.round(_redPackage.remainMoney * 100) / 100;
        }
        Random r = new Random();
        double min = 0.01; //
        double max = _redPackage.remainMoney / _redPackage.remainSize * 2;
        double money = r.nextDouble() * max;
        money = money <= min ? 0.01: money;
        money = Math.floor(money * 100) / 100;
        _redPackage.remainSize--;
        _redPackage.remainMoney -= money;
        return money;
    }

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextDouble());
        double d = 23.625;
        System.out.println(Math.round(d));
        System.out.println(Math.floor(d));
        int remainSize = 7;
        RedPacket redPacket = new RedPacket(remainSize,200);
        for(int i=0;i<remainSize;i++){
            System.out.println(getRandomMoney(redPacket));
        }
    }
}
