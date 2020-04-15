package designmode.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名称：PrizeFactory<br>
 * 类描述：<br>
 * 创建时间：2020年04月14日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class PrizeFactory {
    private static Map<String, IPrize> prizePool = new HashMap<String, IPrize>();
    private PrizeFactory() {}    //私有化,防止生成多个工厂

    /**
     * 根据奖品名称获得奖品对象
     * @param prizeName
     * @return
     */
    public static IPrize getInstance(String prizeName){
        IPrize prize = prizePool.get(prizeName);
        if (prize == null) {
            prize = new PrizeFlyweight(prizeName);
            prizePool.put(prizeName, prize);
        }
        return prize;
    }
}
