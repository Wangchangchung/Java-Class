package com.wcc.state;

/**
 * Created by WCC on 2017/1/8.
 */
public class GumballMachine {

    //糖果机的4中状态
    final  static  int SOLD_OUT =  0;
    final  static  int NO_QUARTER = 1;
    final  static  int HAS_QUARTER = 2;
    final  static  int SOLD = 3;

    // 初始状态我们设置为 SOLD_OUT
    int state = SOLD_OUT;
    //记录糖果机中的数量
    int count = 0;

    //
    public GumballMachine(int count){
        this.count = count;
        //如果传入的数量大于 0  那么就将状态设置为NO_QUARTER
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter(){
        if (state == HAS_QUARTER){
            System.out.println("正在销售中，你不能再投入另外的硬币！");
        }else if (state == NO_QUARTER){
            System.out.println("你可以投入25美分就可以了！");
        }else if (state == SOLD_OUT){
            System.out.println("卖光了，你不可以再投入硬币了！");
        }else if (state == SOLD){
            System.out.println("请你耐心等待，我们正在给你出糖果！");
        }
    }

    public void ejectQuarter(){
        if (state == HAS_QUARTER){
            System.out.println("硬币退还！");
        }else if (state == NO_QUARTER) {
            System.out.println("没有硬币，你不能执行退还操作！");
        }else if (state == SOLD) {
            System.out.println("对不起，你已经给投入了，不能够退出了！");
        }else if(state == SOLD_OUT){
            System.out.println("我们已经卖完了糖果，怎么可能退还硬币呢！");
        }
    }

    // 顾客扭动曲柄的时候
    public void turnCrank(){
        if (state == SOLD){
            System.out.println("整在销售，请不要再次的去扭动，别想拿两次的糖果");
        }else if (state == NO_QUARTER){
            System.out.println("你先投入硬币才能去取糖果");
        }else if (state == SOLD_OUT){
            System.out.println("已经卖完了！");
        }else if(state == HAS_QUARTER){
            System.out.println("糖果正在出来！");
            state = SOLD;
            display();
        }
    }

    // 发放糖果了
    private void display() {
        if (state == SOLD){
            System.out.println("糖果机正在出糖果了，快要掉下来了！");
            count = count -1;
            if (count == 0){
                System.out.println("糖果卖光了");
                state = SOLD_OUT;
            }else {
                state = NO_QUARTER;
            }
        }else if (state == NO_QUARTER){
            System.out.println("亲，你必须先付钱");
        }else if (state == SOLD_OUT){
            System.out.println("已经卖光了！");
        }else if (state == HAS_QUARTER){
            System.out.println("已经卖光了！");
        }
    }

    public void refill(int numGumBalls) {
        this.count = numGumBalls;
        state = NO_QUARTER;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\nMachine is ");
        if (state == SOLD_OUT) {
            result.append("sold out");
        } else if (state == NO_QUARTER) {
            result.append("waiting for quarter");
        } else if (state == HAS_QUARTER) {
            result.append("waiting for turn of crank");
        } else if (state == SOLD) {
            result.append("delivering a gumball");
        }
        result.append("\n");
        return result.toString();
    }

    //
    public static void main(String[] args){

    }


}
