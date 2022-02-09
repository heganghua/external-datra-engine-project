package com.jxzj.external.data.designmode.flowengine;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

public class FlowNode {

    private Map<String, NodeConf> nodeMap = Maps.newLinkedHashMap();

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

    public void replace(String groupName, Class<?> nodeName, NodeConf nodeConf) {
        String key = null;
        if (StringUtils.isNotBlank(groupName)) {
            key = groupName + "_" + nodeName.getName();
        } else {
            key = nodeName.getName();
        }
        nodeMap.put(key, nodeConf);
    }

    public void replace(Class<?> nodeName, NodeConf nodeConf) {
        replace(nodeName.getName(), nodeName, nodeConf);
    }

    public void remove(String groupName, Class<?> nodeName) {
        String key = null;
        if (StringUtils.isNotBlank(key)) {
            key = groupName + "_" + nodeName.getName();
        } else {
            key = nodeName.getName();
        }
        nodeMap.remove(key);
    }

    public void remove(Class<?> nodeName) {
        remove(nodeName.getName(), nodeName);
    }

    public Set<String> getNodeList() {
        return nodeMap.keySet();
    }

    public Map<String, NodeConf> getNodeMap() {
        return nodeMap;
    }

    public void setMap(Map<String, NodeConf> map) {
        this.nodeMap = map;
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
