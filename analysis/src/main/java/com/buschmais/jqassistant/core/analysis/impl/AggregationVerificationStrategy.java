package com.buschmais.jqassistant.core.analysis.impl;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.analysis.api.Result;
import com.buschmais.jqassistant.core.analysis.api.rule.ExecutableRule;
import com.buschmais.jqassistant.core.analysis.api.rule.RuleException;
import com.buschmais.jqassistant.core.rule.api.reader.AggregationVerification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AggregationVerificationStrategy extends AbstractMinMaxVerificationStrategy implements VerificationStrategy<AggregationVerification> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AggregationVerificationStrategy.class);

    @Override
    public Class<AggregationVerification> getVerificationType() {
        return AggregationVerification.class;
    }

    @Override
    public <T extends ExecutableRule> Result.Status verify(T executable, AggregationVerification verification, List<String> columnNames,
            List<Map<String, Object>> rows) throws RuleException {
        LOGGER.debug("Verifying result of " + executable);
        if (rows.isEmpty()) {
            return getStatus(executable, 0, verification.getMin(), verification.getMax());
        }
        if (columnNames.isEmpty()) {
            throw new RuleException("Result contains no columns, at least one with a numeric value is expected.");
        }
        String column = verification.getColumn();
        if (column == null) {
            column = columnNames.get(0);
            LOGGER.debug("No aggregation column specified, using " + column);
        }
        for (Map<String, Object> row : rows) {
            Object value = row.get(column);
            if (value == null) {
                throw new RuleException("The result does not contain a column '" + column);
            } else if (!Number.class.isAssignableFrom(value.getClass())) {
                throw new RuleException("The value in column '" + column + "' must be a numeric value but was '" + value + "'");
            }
            int aggregationValue = ((Number) value).intValue();
            Result.Status status = getStatus(executable, aggregationValue, verification.getMin(), verification.getMax());
            if (Result.Status.FAILURE.equals(status)) {
                return Result.Status.FAILURE;
            }
        }
        return Result.Status.SUCCESS;
    }
}
