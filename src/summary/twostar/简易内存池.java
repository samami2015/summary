package summary.twostar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 【简易内存池】
 * 请实现一个简易内存池,根据请求命令完成内存分配和释放。
 * 内存池支持两种操作命令，REQUEST和RELEASE，其格式为：
 * REQUEST=请求的内存大小 表示请求分配指定大小内存，如果分配成功，返回分配到的内存首地址；如果内存不足，或指定的大小为0，则输出error。
 * RELEASE=释放的内存首地址 表示释放掉之前分配的内存，释放成功无需输出，如果释放不存在的首地址则输出error。
 * 注意：
 * 1.内存池总大小为100字节。
 * 2.内存池地址分配必须是连续内存，并优先从低地址分配。
 * 3.内存释放后可被再次分配，已释放的内存在空闲时不能被二次释放。
 * 4.不会释放已申请的内存块的中间地址。
 * 5.释放操作只是针对首地址所对应的单个内存块进行操作，不会影响其它内存块。
 * <p>
 * 输入描述：
 * 首行为整数N ,表示操作命令的个数，取值范围：0 < N <= 100。
 * 接下来的N行,每行将给出一个操作命令，操作命令和参数之间用 “=”分割。
 * <p>
 * 输出描述：
 * 见题面输出要求
 * <p>
 * 示例1：
 * 输入
 * 2
 * REQUEST=10
 * REQUEST=20
 * 输出
 * 0
 * 10
 */
public class 简易内存池 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            MemPool memPool = new MemPool();
            while (scanner.hasNext()) {
                int n = Integer.parseInt(scanner.nextLine());
                int count = 0;
                List<String> list = new ArrayList<>(n);
                while (count++ < n) {
                    String line = scanner.nextLine();
                    list.add(line);
                }
                for (String line : list) {
                    boolean request = line.startsWith("REQUEST");
                    int number = Integer.parseInt(line.substring(line.indexOf("=") + 1));
                    if (request) {
                        memPool.request(number);
                    } else {
                        memPool.release(number);
                    }
                }
                memPool.releaseAll();
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    static class UsedBlock implements Comparable<UsedBlock> {
        int start = 0;
        int end = 0;

        public UsedBlock(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(UsedBlock o) {
            return start - o.start;
        }

        @Override
        public String toString() {
            return "UsedBlock{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static class MemPool {
        final List<UsedBlock> list = new ArrayList<>();
        int max = 100;
        int used = 0;

        void request(int mem) {
            if (mem == 0 || used + mem > max) {
                System.out.println("error");
            } else {
                int size = list.size();
                if (size == 0) {
                    list.add(new UsedBlock(0, mem));
                    used += mem;
                    System.out.println(0);
                    return;
                }
                UsedBlock block = null;
                boolean success = false;
                int i = 0;
                for (; i < size; i++) {
                    block = list.get(i);
                    if (i == 0 && block.start >= mem) {
                        success = true;
                        list.add(i, new UsedBlock(0, mem));
                        break;
                    } else {
                        if (i == 0) continue;
                        UsedBlock prev = list.get(i - 1);
                        if (block.start - prev.end >= mem) {
                            success = true;
                            list.add(i, new UsedBlock(prev.end, prev.end + mem));
                        }
                    }
                }
                if (success) {
                    used += mem;
                    System.out.println(list.get(i).start);
                } else {
                    if (block != null && max - block.end >= mem) {
                        list.add(i, new UsedBlock(block.end, block.end + mem));
                        used += mem;
                        System.out.println(list.get(i).start);
                    } else {
                        System.out.println("error");
                    }
                }
            }
        }

        void release(int index) {
            UsedBlock usedBlock = null;
            for (UsedBlock block : list) {
                if (block.start == index) {
                    usedBlock = block;
                    break;
                }
            }
            if (usedBlock == null) {
                System.out.println("error");
            } else {
                used -= usedBlock.end - usedBlock.start;
                list.remove(usedBlock);
            }
        }

        void releaseAll() {
            list.clear();
        }
    }
}
