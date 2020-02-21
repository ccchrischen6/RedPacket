package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RedPacketService {

    @Autowired
    private RedPacketRepository repository;

    public void createTwo() {
        RedPacket redPacket1 = new RedPacket();
        redPacket1.setProducer("Chris");
        redPacket1.setMoney(new BigDecimal("438"));
        repository.save(redPacket1);

        RedPacket redPacket2 = new RedPacket();
        redPacket2.setProducer("Chris");
        redPacket2.setMoney(new BigDecimal("326"));
        repository.save(redPacket2);

    }
}
