package com.jxzj.external.data.designmode.responsibilitychain;

public class Clinet {

    public static void main(String[] args) {

        NewbieProgrammer newbieProgrammer = new NewbieProgrammer();
        NormalProgrammer normalProgrammer = new NormalProgrammer();
        ExcellentProgrammer excellentProgrammer = new ExcellentProgrammer();

        newbieProgrammer.setNext(normalProgrammer);
        normalProgrammer.setNext(excellentProgrammer);

        Bug easyBug = new Bug(20);
        Bug middleBug = new Bug(50);
        Bug hardBug = new Bug(80);

        newbieProgrammer.handle(easyBug);
        newbieProgrammer.handle(middleBug);
        newbieProgrammer.handle(hardBug);
    }

}
