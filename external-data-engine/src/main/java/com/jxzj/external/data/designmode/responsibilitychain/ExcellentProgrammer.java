package com.jxzj.external.data.designmode.responsibilitychain;

public class ExcellentProgrammer extends Programmer {

    @Override
    void handle(Bug bug) {
        if (bug.value > 50 && bug.value <= 100) {
            solve(bug);
        } else if (next != null) {
            next.handle(bug);
        }
    }

    private void solve(Bug bug) {
        System.out.println("优秀程序员解决了一个难度为" + bug.value + " 的 bug");
    }

}
