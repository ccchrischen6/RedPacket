package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class RedPacketController {
    @Autowired
    private RedPacketRepository repository;

    @Autowired
    private RedPacketService service;


    //receive a Red-Packet
    @GetMapping("/luckymoneys")
    public List<RedPacket> list(){
        return repository.findAll();
    }

    //create a Red-Packet
    @PostMapping("/luckymoney")
    public RedPacket create(@RequestParam("producer") String producer,
                            @RequestParam("money")BigDecimal money){
        RedPacket redPacket = new RedPacket();
        redPacket.setProducer(producer);
        redPacket.setMoney(money);
        return repository.save(redPacket);
    }


    //check the Red-Packet via ID
    @GetMapping("/luckymoneys/{id}")
    public RedPacket findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    //renew the Red-Packet
    @PutMapping("/luckymoneys/{id}")
    public RedPacket update(@PathVariable("id") Integer id,
                            @RequestParam("consumer") String consumer){
        Optional<RedPacket> optional = repository.findById(id);
        if (optional.isPresent()){
            RedPacket redPacket = optional.get();
            redPacket.setConsumer(consumer);
            return repository.save(redPacket);
        }

        return null;
    }

    @PostMapping("/luckymoneys/two")
    public void creatTwo(){
        service.createTwo();
    }

}
