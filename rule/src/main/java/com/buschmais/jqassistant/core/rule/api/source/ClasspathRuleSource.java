package com.buschmais.jqassistant.core.rule.api.source;

import java.io.InputStream;

/**
 * A rule source which is provided from a classpath resource.
 */
public class ClasspathRuleSource extends RuleSource {

    private ClassLoader classLoader;
    private String resource;

    public ClasspathRuleSource(ClassLoader classLoader, String resource) {
        this.classLoader = classLoader;
        this.resource = resource;
    }

    @Override
    public String getId() {
        return resource;
    }

    @Override
    public InputStream getInputStream() {
        ClassLoader currentClassloader = classLoader != null ? classLoader : Thread.currentThread().getContextClassLoader();
        return currentClassloader.getResourceAsStream(resource);
    }
}
