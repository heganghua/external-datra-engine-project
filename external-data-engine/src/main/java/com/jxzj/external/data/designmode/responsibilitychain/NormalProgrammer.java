package com.jxzj.external.data.designmode.responsibilitychain;

public class NormalProgrammer extends Programmer {

    @Override
    void handle(Bug bug) {
        if (bug.value > 20 && bug.value <= 50) {
            solve(bug);
        } else if (next != null) {
            next.handle(bug);
        }
    }

    private void solve(Bug bug) {
        System.out.println("中级程序员解决了一个难度为" + bug.value + " 的 bug");
    }

}
