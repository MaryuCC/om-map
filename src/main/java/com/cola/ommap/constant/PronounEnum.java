package com.cola.ommap.constant;

import com.cola.ommap.config.Information;

public enum PronounEnum implements Information {
    HE {
        @Override
        public String getText() {
            return "He";
        }

        @Override
        public int getCode() {
            return 0;
        }

    },
    SHE {
        @Override
        public String getText() {
            return "She";
        }

        @Override
        public int getCode() {
            return 1;
        }

    },
    THEY {
        @Override
        public String getText() {
            return "They";
        }

        @Override
        public int getCode() {
            return 2;
        }

    },
    OTHER {
        @Override
        public String getText() {
            return "Other";
        }

        @Override
        public int getCode() {
            return 3;
        }

    },
    SECRET {
        @Override
        public String getText() {
            return "Secret";
        }

        @Override
        public int getCode() {
            return 4;
        }

    },

}
