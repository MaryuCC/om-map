package com.cola.ommap.constant;

import com.cola.ommap.config.Information;

public enum GenderEnum implements Information {
    MALE {
        @Override
        public String getText() {
            return "Male";
        }

        @Override
        public int getCode() {
            return 0;
        }

    },
    FEMALE {
        @Override
        public String getText() {
            return "Female";
        }

        @Override
        public int getCode() {
            return 1;
        }

    },
    SECRET {
        @Override
        public String getText() {
            return "Secret";
        }

        @Override
        public int getCode() {
            return 2;
        }

    },
}
