package com.buschmais.jqassistant.core.analysis.api.rule;

public class NoGroupException extends NoRuleException {
    public NoGroupException(String groupId) {
        super(groupId);
    }
}
