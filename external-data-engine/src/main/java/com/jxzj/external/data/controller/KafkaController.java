package com.jxzj.external.data.controller;

import java.util.List;

import org.apache.curator.shaded.com.google.common.collect.Lists;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jxzj.external.data.utils.KafkaUtils;
import com.jxzj.external.data.vo.KafkaResp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "kafka控制器")

public class KafkaController {

    private static Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaUtils kafkaUtils;

    /**
     * 新增topic (支持批量，这里就单个作为演示)
     *
     * @param topic topic
     * @return ResponseVo
     */
    @ApiOperation("新增topic")
    @PostMapping("kafka")
    public KafkaResp add(String topic) {
        NewTopic newTopic = new NewTopic(topic, 3, (short)1);
        kafkaUtils.createTopic(Lists.newArrayList(newTopic));
        KafkaResp kafkaResp = new KafkaResp();
        kafkaResp.success();
        return kafkaResp;
    }

    /**
     * 查询topic信息 (支持批量，这里就单个作为演示)
     *
     * @param topic 自增主键
     * @return ResponseVo
     */
    @ApiOperation("查询topic信息")
    @GetMapping("kafka/{topic}")
    public KafkaResp getBytTopic(@PathVariable String topic) {
        String topicInfo = kafkaUtils.getTopicInfo(Lists.newArrayList(topic));
        KafkaResp kafkaResp = new KafkaResp();
        kafkaResp.setRspMsg(topicInfo);
        kafkaResp.success();
        return kafkaResp;
    }

    /**
     * 删除topic (支持批量，这里就单个作为演示) (注意：如果topic正在被监听会给人感觉删除不掉（但其实是删除掉后又会被创建）)
     *
     * @param topic topic
     * @return ResponseVo
     */
    @ApiOperation("删除topic")
    @DeleteMapping("kafka/{topic}")
    public KafkaResp delete(@PathVariable String topic) {
        kafkaUtils.deleteTopic(Lists.newArrayList(topic));
        KafkaResp kafkaResp = new KafkaResp();
        kafkaResp.success();
        return kafkaResp;
    }

    /**
     * 查询所有topic
     *
     * @return ResponseVo
     */
    @ApiOperation("查询所有topic")
    @GetMapping("kafka/allTopic")
    public KafkaResp getAllTopic() {
        List<String> allTopic = kafkaUtils.getAllTopic();
        KafkaResp kafkaResp = new KafkaResp();
        kafkaResp.setLists(allTopic);
        kafkaResp.success();
        return kafkaResp;
    }

    /**
     * 生产者往topic中发送消息demo
     *
     * @param topic
     * @param message
     * @return
     */
    @ApiOperation("往topic发送消息")
    @PostMapping("kafka/message")
    public KafkaResp sendMessage(String topic, String message) {
        kafkaUtils.sendMessage(topic, message);
        KafkaResp kafkaResp = new KafkaResp();
        kafkaResp.success();
        return kafkaResp;
    }

    /**
     * 消费者示例demo
     * <p>
     * 基于注解监听多个topic，消费topic中消息 （注意：如果监听的topic不存在则会自动创建）
     */
    @KafkaListener(topics = {"topic1", "topic2", "topic3"})
    public void consume(String message) {
        logger.info("receive msg: " + message);
    }
}
