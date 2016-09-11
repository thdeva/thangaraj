/**
 * =============================================================================
 * COPYRIGHT NOTICE
 * =============================================================================
 * Copyright (C) 2014, HCL Technologies Limited. All Rights Reserved.
 * Proprietary and confidential. All information contained herein is, and
 * remains the property of HCL Technologies Limited. Copying or reproducing the
 * contents of this file, via any medium is strictly prohibited unless prior
 * written permission is obtained from HCL Technologies Limited.
 */
package com.training.passession1;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.hmtp.common.server.util.PersistenceInitUtil;
import com.hcl.hmtp.configuration.application.ApplicationTemplateWithEmaiAndAmqpConfiguration;
@EntityScan(value = { "com.training.entities" })
@Import(ApplicationTemplateWithEmaiAndAmqpConfiguration.class) @SpringBootApplication public class ApplicationBoot {
    public static void main(String[] args) throws Exception {
        final SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(ApplicationBoot.class);
        final ConfigurableApplicationContext applicationContext = applicationBuilder.run(args);
        PersistenceInitUtil.initialize(applicationContext);
    }
}
