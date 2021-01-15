import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/1/12 20:17
 * 狄杰斯特拉算法
 */
public class Dijkstra {
    public static void main(String[] args) {
        HashMap<String, Integer> A = new HashMap<String, Integer>() {{
            put("B", 5);
            put("C", 1);
        }};

        HashMap<String, Integer> B = new HashMap<String, Integer>() {{
            put("E", 10);
        }};
        HashMap<String, Integer> C = new HashMap<String, Integer>() {{
            put("D", 5);
            put("F", 6);
        }};
        HashMap<String, Integer> D = new HashMap<String, Integer>() {{
            put("E", 3);
        }};
        HashMap<String, Integer> E = new HashMap<String, Integer>() {{
            put("H", 3);
        }};
        HashMap<String, Integer> F = new HashMap<String, Integer>() {{
            put("G", 2);
        }};
        HashMap<String, Integer> G = new HashMap<String, Integer>() {{
            put("H", 10);
        }};
        HashMap<String, HashMap<String, Integer>> allMap = new HashMap<String, HashMap<String, Integer>>() {{
            put("A", A);
            put("B", B);
            put("C", C);
            put("D", D);
            put("E", E);
            put("F", F);
            put("G", G);
        }};


        Dijkstra dijkstra = new Dijkstra();
        dijkstra.handle("A", "H", allMap);
    }

    /**
     * 找出待处理的里面，时间最小的
     * @param costs 到每个节点所需要的时间
     * @param hasHandleList 已经处理过得节点集合
     * @return
     */
    private String getMiniCostKey(HashMap<String, Integer> costs, List<String> hasHandleList) {
        int mini = Integer.MAX_VALUE;
        // 注意 是null 不能是 ""
        String miniKey = null;
        for (String key : costs.keySet()) {
            if (!hasHandleList.contains(key)) {
                int cost = costs.get(key);
                if (mini > cost) {
                    mini = cost;
                    miniKey = key;
                }
            }
        }
        return miniKey;
    }

    private void handle(String startKey, String target, HashMap<String, HashMap<String, Integer>> all) {
        //存放到各个节点所需要消耗的时间
        HashMap<String, Integer> costMap = new HashMap<String, Integer>();
        //到各个节点对应的父节点
        HashMap<String, String> parentMap = new HashMap<String, String>();
        //存放已处理过的节点key,已处理过的不重复处理
        List<String> hasHandleList = new ArrayList<String>();

        //首先获取开始节点相邻节点信息
        HashMap<String, Integer> start = all.get(startKey);

        //添加起点到各个相邻节点所需耗费的时间等信息
        for (String key : start.keySet()) {
            int cost = start.get(key);
            costMap.put(key, cost);
            parentMap.put(key, startKey);
        }

        //选择最"便宜"的节点，这边即耗费时间最低的
        String minCostKey = getMiniCostKey(costMap, hasHandleList);
        while (minCostKey != null) {
            System.out.println("处理节点：" + minCostKey);
            HashMap<String, Integer> nodeMap = all.get(minCostKey);
            if (nodeMap != null) {
                //该节点没有子节点可以处理了，末端节点
                handleNode(minCostKey, nodeMap, costMap, parentMap);
            }
            //添加该节点到已处理结束的列表中
            hasHandleList.add(minCostKey);
            //再次获取下一个最便宜的节点
            // 注意 是costMap 不是codeMap
            minCostKey = getMiniCostKey(costMap, hasHandleList);
        }
        if (parentMap.containsKey(target)) {
            System.out.println("到目标节点" + target + "最低耗费:" + costMap.get(target));
            List<String> pathList = new ArrayList<String>();
            String parentKey = parentMap.get(target);
            while (parentKey != null) {
                pathList.add(0, parentKey);
                parentKey = parentMap.get(parentKey);
            }
            // 注意是target
            pathList.add(target);
            String path = "";
            for (String key : pathList) {
                path +=key;
                if (!key.equals(target)) {
                    path += "-->";
                }
            }
            System.out.println("路线为" + path);
        } else {
            System.out.print("不存在到达" + target + "的路径");
        }
    }

    /**
     *
     * @param startKey
     * @param nodeMap
     * @param costMap
     * @param parentMap
     */
    private void handleNode(String startKey, HashMap<String, Integer> nodeMap, HashMap<String, Integer> costMap, HashMap<String, String> parentMap) {

        for (String key : nodeMap.keySet()) {
            //获取原本到父节点所需要花费的时间
            int hasCost = costMap.get(startKey);
            //获取父节点到子节点所需要花费的时间
            int cost = nodeMap.get(key);
            //计算从最初的起点到该节点所需花费的总时间
            cost = hasCost + cost;

            if (!costMap.containsKey(key)) {
                //如果原本并没有计算过其它节点到该节点的花费
                costMap.put(key, cost);
                parentMap.put(key, startKey);
            } else {
                //获取原本耗费的时间
                int oldCost = costMap.get(key);
                if (cost < oldCost) {
                    //新方案到该节点耗费的时间更少
                    //更新到达该节点的父节点和消费时间对应的散列表
                    costMap.put(key, cost);
                    parentMap.put(key, startKey);
                    System.out.println("更新节点：" + key + ",cost:" + oldCost + " --> " + cost);
                }
            }
        }
    }
}
