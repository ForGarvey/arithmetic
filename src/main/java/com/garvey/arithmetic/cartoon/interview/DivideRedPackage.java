package com.garvey.arithmetic.cartoon.interview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description 拆分红包
 *      需要满足的具体规则：
 *          1.所有人抢到的金额之和要等于红包金额，不能多也不能少。
 *          2.每个人至少抢到1分钱。
 *          3.要保证红包拆分的金额尽可能分布均衡，不要出现两极分化太严重的情况。
 *      思路：
 *          为了避免出现高并发引起的一些问题，每个人领取红包的金额不能在领的时候才计算，必须先计算好每个红包拆出的金额，
 *          并把它们放在一个队列里，领取红包的用户要在队列中找到属于自己的那一份。
 *      具体方案：
 *          1.二倍均值法：
 *              1.假设剩余红包金额为m元，剩余人数为n，那么有如下公式：
 *                  每次抢到的金额 = 随机区间[0.01， m / n * 2 - 0.01]元
 *              2.这个公式保证了每次随机金额的平均值是相等的，不会因为抢红包的先后顺序而造成不公平。
 *              3.但是这个方法也存在局限性，即除最后一次外，其他每次抢到的金额都要小于剩余人均金额的2倍，并不是完全自由地随机抢红包。
 *          2.线段切割法：
 *              1.可以把红包总金额想象成一条很长的线段，而每个人抢到的金额，则是这条主线段所拆分出的若干子线段。
 *              2.当n个人一起抢总金额为m的红包时，我们需要做n-1次随机运算，以此确定n-1个切割点。随机的范围是[1, m-1]。
 *              3，要注意切割点重复的情况、以及如何尽可能降低时间复杂度和空间复杂度。
 * @Author Garvey
 * @Date 2019-09-08 23:45
 */
public class DivideRedPackage {

    /**
     * 拆分红包（二倍均值法）
     * @param totalAmount       总金额（以分为单位）
     * @param totalPeopleNum    总人数
     * @return
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;

        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            // 随机范围：[1, 剩余人均金额的2倍-1]分
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;

            amountList.add(amount);
        }

        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPackage(1000, 10);
        int sum = 0;
        for (Integer amount : amountList) {
            sum += amount;
            System.out.println("抢到金额：" + new BigDecimal(amount).divide(new BigDecimal(100)) + "元");
        }
        System.out.println(sum);
    }
}
