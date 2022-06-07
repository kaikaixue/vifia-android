package com.vifia.module_base.constant;

public class RouterActivityPath {
    public static class Main {
        private static final String MAIN = "/module_main";

        /**
         * 首页
         */
        public static final String PAGER_MAIN = MAIN + "/Main";
    }

    public static class Home {
        private static final String HOME = "/module_home";

        /**
         * 主页
         */
        public static final String PAGER_HOME = HOME + "/Home";
    }

    public static class Mine {
        private static final String MINE = "/module_mine";

        public static final String PAGER_MINE = MINE + "/Mine";

        public static final String PAGER_PERSONAL = MINE + "/Personal";

    }
}