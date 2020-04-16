package ru.job4j.principle003;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExJob {

    private static final Logger LOG = LoggerFactory.getLogger(ExJob.class.getName());

    public static void main(String[] args) {
        int version = 1;
        LOG.trace("trace message {}", version);
        LOG.debug("trace message {}", version);
        LOG.info("trace message {}", version);
        LOG.warn("trace message {}", version);
        LOG.error("trace message {}", version);
    }
}
