package com.jxzj.external.data.designmode.proxymode;

public class StaticProxyDemo {

    public static void main(String[] args) {
        RealMovie realMovie = new RealMovie();
        ProxyCinima proxyCinima = new ProxyCinima(realMovie);
        proxyCinima.play();
    }

    static class ProxyCinima implements Movie {

        RealMovie movie;

        ProxyCinima(RealMovie movie) {
            this.movie = movie;
        }

        @Override
        public void play() {
            guanggao(true);
            movie.play();
            guanggao(false);
        }

        public void guanggao(boolean isStart) {
            if (isStart) {
                System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
            } else {
                System.out.println("电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
            }
        }

    }

    static class RealMovie implements Movie {
        @Override
        public void play() {
            System.out.println("看电影，“肖生客救助”。。。。。");
        }

    }

    static interface Movie {
        public void play();
    }

}
