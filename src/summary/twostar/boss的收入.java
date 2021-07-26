package summary.twostar;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 【boss的收入】
 * 一个XX产品行销总公司，只有一个boss，其有若干一级分销，一级分销又有若干二级分销，每个分销只有唯一的上级分销。
 * 规定，每个月，下级分销需要将自己的总收入（自己的+下级上交的）每满100元上交15元给自己的上级。
 * 现给出一组分销的关系，和每个分销的收入，请找出boss并计算出这个boss的收入。
 * 比如：
 * 收入100元，上交15元；
 * 收入199元（99元不够100），上交15元；
 * 收入200元，上交30元。
 * 输入：
 * 分销关系和收入： [ [分销id 上级分销的Id 收入], [分销id 上级分销的id 收入], [分销id 上级分销的id 收入] ]
 * 分销ID范围 0..65535
 * 收入范围: 0..65535 , 单位元
 * 提示：输入的数据只存在1个boss，不存在环路
 * 输出：[boss的ID，总收入]
 * <p>
 * 输入描述：
 * 第1行输入关系的总数量N
 * 第2行开始，输入关系信息，格式：分销ID 上级分销ID 收入
 * 比如：
 * 5
 * 1 0 100
 * 2 0 199
 * 3 0 200
 * 4 0 200
 * 5 0 200
 * <p>
 * 输出描述：
 * 输出：boss的ID 总收入
 * 比如：
 * 0 120
 * 备注：
 * 给定的输入数据都是合法的，不存在环路，重复的
 * 示例1：
 * 输入
 * 5
 * 1 0 100
 * 2 0 199
 * 3 0 200
 * 4 0 200
 * 5 0 200
 * 输出
 * 0 120
 */
public class boss的收入 {
    public static class Sale {
        private int id;
        private int bossId;
        private int income;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBossId() {
            return bossId;
        }

        public void setBossId(int bossId) {
            this.bossId = bossId;
        }

        public int getIncome() {
            return income;
        }

        public void setIncome(int income) {
            this.income = income;
        }

        public int getTax() {
            return income / 100 * 15;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Map<Integer, List<Sale>> bossSaleMap = new HashMap<>();
        Map<Integer, Sale> saleMap = new HashMap<>(size);
        Sale sale;
        for (int i = 0; i < size; i++) {
            sale = new Sale();
            sale.setId(sc.nextInt());
            sale.setBossId(sc.nextInt());
            sale.setIncome(sc.nextInt());
            List<Sale> ss = bossSaleMap.get(sale.getBossId());
            if (ss == null) {
                ss = new ArrayList<>();
                bossSaleMap.put(sale.getBossId(), ss);
            }
            ss.add(sale);
            saleMap.put(sale.getId(), sale);
        }

        Set<Integer> midBossSet = new HashSet<>();
        int bossId = 0;
        for (Sale s : saleMap.values()) {
            if (!bossSaleMap.containsKey(s.getId())) {
                midBossSet.add(s.getBossId());
            }
        }
        do {
            Set<Integer> bossSet = new HashSet<>();
            for (int bld : midBossSet) {
                Sale sale1 = saleMap.get(bld);
                if (sale1 == null) {
                    continue;
                }
                List<Sale> saleList = bossSaleMap.get(bld);
                if (saleList == null) {
                    continue;
                }
                int subIncome = saleList.stream().mapToInt(Sale::getTax).sum();
                sale1.setIncome(sale1.getIncome() + subIncome);
                Sale sale2 = saleMap.get(sale1.getBossId());
                if (sale2 != null) {
                    bossSet.add(sale1.getBossId());
                } else {
                    bossId = sale1.getBossId();
                }
            }
            midBossSet = bossSet;
        } while (!midBossSet.isEmpty());
        int bossIncome = bossSaleMap.get(bossId).stream().mapToInt(Sale::getTax).sum();
        System.out.println(bossId + " " + bossIncome);
    }
}
