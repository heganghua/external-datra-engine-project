package com.jxzj.external.data.designmode.flowengine;

import java.util.LinkedHashMap;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

public class FlowNode {

    LinkedHashMap<String, NodeConf> nodeMap = Maps.newLinkedHashMap();

    public void add(String groupName, Class<?> nodeName, NodeConf nodeConf) {
        String key = null;
        if (StringUtils.isNotBlank(groupName)) {
            key = groupName + "_" + nodeName.getName();
            System.out.println("key: " + key);
        } else {
            key = nodeName.getName();
        }

        if (nodeMap.containsKey(key)) {
            return;
        }
        nodeMap.put(key, nodeConf);
    }

    public void add(Class<?> nodeName, NodeConf nodeConf) {
        add(nodeName.getName(), nodeName, nodeConf);
    }

    static class NodeConf {

        private int timeout = 100;

        NodeConf() {}

        NodeConf(int timeout) {
            this.timeout = timeout;
        }

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }
    }

}
